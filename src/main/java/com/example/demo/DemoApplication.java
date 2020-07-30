package com.example.demo;

import java.io.File;
import java.nio.file.Files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.AbstractFileResolvingResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static final String FILENAME = "weather.csv";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Scheduled(fixedRate = 120000) // Every 2 mins
	public void printWeatherContents() throws Exception {
		String contents = getWeatherContents();
		System.out.println(contents);
	}

	public String getWeatherContents() throws Exception {
		AbstractFileResolvingResource resource = new ClassPathResource(FILENAME);
		File file = resource.getFile();
		return new String(Files.readAllBytes(file.toPath()));
	}

}
