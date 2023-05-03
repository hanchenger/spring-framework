//package org.springframework.example;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.spi.ExtendedLogger;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//@Slf4j
//public class Log4jTest {
//
//	@Test
//	public  void test() {
//		//一个项目依赖多个日志依赖是不会冲突，而且同一个类中实例化2个日志的实现对象也不会冲突
//		ExtendedLogger logger = LogManager.getContext().getLogger("a");
//		logger.error("log4j2");
//
//		Logger logger1 = LoggerFactory.getLogger(Log4jTest.class);
//		logger1.debug("logback------------");
//	}
//}
