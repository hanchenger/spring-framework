package org.springframework.example.context;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.context.bean.A;
import org.springframework.example.context.bean.C;
import org.springframework.example.context.bfpp.BBeanFactoryPostProcessor;
import org.springframework.example.context.config.ContextConfig;
import org.springframework.util.ObjectUtils;

public class ContextTest {


	@Test
	public void defaultContext(){
		//bean工厂
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();


		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(A.class);
		beanFactory.registerBeanDefinition("a",beanDefinitionBuilder.getBeanDefinition());
		//beanDefinitionBuilder.getBeanDefinition().setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		 beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(C.class);
		beanFactory.registerBeanDefinition("c",beanDefinitionBuilder.getBeanDefinition());

		AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();
		postProcessor.setBeanFactory(beanFactory);
		beanFactory.addBeanPostProcessor(postProcessor);


		C c = beanFactory.getBean(C.class);
		A a = beanFactory.getBean(A.class);
		System.out.println(a.getC());
	}

	@Test
	public void defaultApplicationContext(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
		A bean = context.getBean(A.class);

		System.out.println(bean.getC());
	}

	@Test
	public void beanFactoryPostProcessorTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.context.bfpp");
		context.addBeanFactoryPostProcessor(new BBeanFactoryPostProcessor());
		context.refresh();
	}

	@Test
	public void beanFactoryPostProcessorAndBeanDefinitionRegistryPostProcessorTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//
//		context.scan("org.springframework.example.context.bfpp");
		context.addBeanFactoryPostProcessor(new org.springframework.example.context.bfpp.B());
		context.addBeanFactoryPostProcessor(new org.springframework.example.context.bfpp.C());
		//相当于手动扫描
		context.register(ContextConfig.class);
		context.refresh();
	}
}
