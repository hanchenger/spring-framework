package org.springframework.example.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class TestSpringLogBack {

	@Test
	public  void test()  {
		log.debug("--------");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.refresh();
	}
}
