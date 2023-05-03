package org.springframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class LogBackTest {

	//private Logger log = LoggerFactory.getLogger(LogBackTest.class);

	@Test
	public  void test()  {
		//这个采用的loback的绑定实现来打印的日志，这是因为build.gradle文件中有logback-classic的依赖，这个包含logback的核心包，slf4j接口包，以及绑定实现
		//而我们的build.gradle也有log4j2的包，但是没有log4j2的绑定实现，所以这里的log是走的logback的实现
		log.debug("--------");

		//这个是采用的log4j2的实现打印的日志,这是因为在spring源码中，是采用的spring的日志技术jcl,这个底层实现如有有log4j2的依赖走的是log4j2的实现
		//如有logback的依赖，走的是logback的实现,
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context.register(AppConfig.class);
		context.refresh();

//		UserService userService = (UserService) context.getBean("userService");
//		userService.sayHello();
	}
}