package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DemoApplication demoApplication;

	@Test
	public void getContents() throws Exception {
		String expected = "outlook,temperature,humidity,windy,play\novercast,hot,high,FALSE,yes\novercast,cool,normal,TRUE,yes\novercast,mild,high,TRUE,yes\novercast,hot,normal,FALSE,yes\nrainy,mild,high,FALSE,yes\nrainy,cool,normal,FALSE,yes\nrainy,cool,normal,TRUE,no\nrainy,mild,normal,FALSE,yes\nrainy,mild,high,TRUE,no\nsunny,hot,high,FALSE,no\nsunny,hot,high,TRUE,no\nsunny,mild,high,FALSE,no\nsunny,cool,normal,FALSE,yes\nsunny,mild,normal,TRUE,yes";

		String actual = demoApplication.getWeatherContents();
		
		assertEquals(expected, actual);
	}

}
