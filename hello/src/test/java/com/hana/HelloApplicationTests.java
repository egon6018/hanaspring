package com.hana;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class HelloApplicationTests {

	@Test
	void contextLoads() { // 여기가 main함수(start point)
		log.info("Log Test"); // System.out.print()와 같은 의미
	}

}
