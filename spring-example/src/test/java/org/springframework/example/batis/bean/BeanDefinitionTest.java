package org.springframework.example.batis.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.batis.config.BatisConfig;
import org.springframework.example.batis.dao.AMapper;
import org.springframework.example.batis.dao.TMapper;
import org.springframework.example.batis.service.TService;

import java.util.Optional;

@Slf4j(topic = "e")
public class BeanDefinitionTest {


	@Test
	public void testBeanDefinition() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.bean");
		context.refresh();
		context.getBean(X.class);

	}

	@Test
	public void testRegisterBeanDefinitions() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BatisConfig.class);
		TService tService = (TService) context.getBean("TServiceImpl");
		tService.queryFroList();

	}
}
