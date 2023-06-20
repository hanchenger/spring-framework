package org.springframework.example.log;


import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class TestJul {

	@Test
	public  void test()  {
		Logger logger = Logger.getLogger("a");
		logger.info("jul");
	}
}
