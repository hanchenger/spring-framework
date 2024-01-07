package org.springframework.example.enhancer;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.enhancer.config.Appconfig;

public class EnhancerTest {

	@Test
	public void defaultTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		BeanDefinition appconfig = context.getBeanDefinition("appconfig");
		Appconfig bean = context.getBean(Appconfig.class);
		System.out.println("");
	}
}
