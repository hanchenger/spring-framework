package org.springframework.example.log;

import lombok.extern.slf4j.Slf4j;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.spi.ExtendedLogger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过桥接器   implementation group: 'org.apache.logging.log4j', name: 'log4j-to-slf4j', version: '2.9.1'
 * 实现 历史遗留硬编码问题的解决
 */
@Slf4j
public class TestSpringLog4j2 {

	@Test
	public  void test()  {
//		ExtendedLogger logger = LogManager.getContext().getLogger("a");
//		logger.error("log4j2");

		Logger logger1 = LoggerFactory.getLogger("a");
		logger1.debug("logback");
	}
}
