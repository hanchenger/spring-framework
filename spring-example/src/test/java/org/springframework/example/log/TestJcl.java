package org.springframework.example.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class TestJcl {

	@Test
	public  void test()  {
		Log logger = LogFactory.getLog("a");
		logger.info("jcl");

	}
}
