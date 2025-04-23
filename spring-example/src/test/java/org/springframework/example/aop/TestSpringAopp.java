package org.springframework.example.aop;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.example.aop.advice.BeforeAdvice;
import org.springframework.example.aop.anno.Parameter;
import org.springframework.example.aop.anno.Parameter2Anno;
import org.springframework.example.aop.anno.ParameterAnno;
import org.springframework.example.aop.service.*;
import org.springframework.example.aop.service.impl.*;
import org.springframework.example.aopp.config.App;
import org.springframework.example.aopp.service.StudentService;


@Slf4j(topic = "e")
public class TestSpringAopp {

	/**
	 *
	 */
	@Test
	public void testXml() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-aop.xml");
		StudentService bean = context.getBean(StudentService.class);
		bean.add("String");
	}

	/**
	 *
	 */
	@Test
	public void testAop() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		StudentService bean = context.getBean(StudentService.class);
		bean.add("String");
	}

}
