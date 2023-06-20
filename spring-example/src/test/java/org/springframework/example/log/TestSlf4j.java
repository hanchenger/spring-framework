package org.springframework.example.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlf4j {

	@Test
	public  void test()  {
		Logger logger = LoggerFactory.getLogger("a");
		logger.debug("slf4j");



	}
}
