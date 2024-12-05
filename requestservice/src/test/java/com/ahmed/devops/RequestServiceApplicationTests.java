package com.ahmed.devops;

import com.ahmed.devops.service.RequestDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RequestServiceApplicationTests {
	@Autowired
	private RequestDataService requestDataService;

	@BeforeAll
	static void setup() {
		System.setProperty("LOKI_URL", "http://localhost:9000/");
	}

	@Test
	void shouldGenerateTenData() {
		int generatedDataCount = requestDataService.generate(10);
		assertEquals(generatedDataCount, 10);
	}

}
