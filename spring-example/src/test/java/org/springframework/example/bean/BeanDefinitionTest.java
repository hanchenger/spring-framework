package org.springframework.example.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {


	@Test
	public void testBeanDefinition() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.bean");
		context.refresh();
		context.getBean(X.class);

	}
}
