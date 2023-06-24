package org.springframework.example.automode;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.config.ModelConfig;
import org.springframework.example.defaults.ModelBeanFactoryPostProcessor;
import org.springframework.example.inject.F;
import org.springframework.example.inject.I;
import org.springframework.example.lookup.LA;
import org.springframework.example.lookup.LC;
import org.springframework.example.order.E;
import org.springframework.example.order.T;
import org.springframework.example.statics.A;
import org.springframework.example.statics.Config;
import org.springframework.example.statics.ObjectFactory;
import org.springframework.example.statics.SupplierFactory;

import java.util.List;
import java.util.function.Supplier;

@Slf4j(topic = "e")
public class ModeTest {


	@Test
	public void dependsOnModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.dependsOn");
		context.refresh();
	}

	@Test
	public void staticsModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context.register(Config.class);

		//beanDefinition称为bean的原料
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(A.class);

		context.registerBeanDefinition("a", beanDefinition);

		context.refresh();
	}

	@Test
	public void staticsDefinitionModel2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ObjectFactory.class);

		//beanDefinition称为bean的原料
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(A.class);
		beanDefinition.setFactoryBeanName("objectFactory");
		beanDefinition.setFactoryMethodName("instanceObject");

		context.registerBeanDefinition("a", beanDefinition);

		context.refresh();
	}

	@Test
	public void staticsDefinitionModel3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ObjectFactory.class);

		//beanDefinition称为bean的原料
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(A.class);
		SupplierFactory supplierFactory = new SupplierFactory();
		beanDefinition.setInstanceSupplier(supplierFactory::instanceObject);

		context.registerBeanDefinition("a", beanDefinition);
		context.refresh();
	}

	@Test
	public void staticsDefinitionModel5() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ObjectFactory.class);

		//beanDefinition称为bean的原料
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(A.class);
		beanDefinition.setInstanceSupplier(SupplierFactory::getObject);

		context.registerBeanDefinition("a", beanDefinition);
		context.refresh();
	}

	@Test
	public void staticsDefinitionModel6() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ObjectFactory.class);

		//beanDefinition称为bean的原料
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(A.class);

		beanDefinition.setFactoryBeanName("objectFactory");
		beanDefinition.setFactoryMethodName("instanceObject");
		beanDefinition.setInstanceSupplier(SupplierFactory::getObject);

		context.registerBeanDefinition("a", beanDefinition);
		context.refresh();

	}

	/**
	 * 测试注入模型对bean的影响
	 * 包括实例化，或者一些高级特性
	 */
	@Test
	public void defaultModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ModelConfig.class);
        context.register(ModelBeanFactoryPostProcessor.class);
		context.refresh();

	}

	/**
	 * spring中的所有bean默认情况下的注入模型都是0（也就是手动注入）
	 * 手动注入就是说你的明确告诉spring这些依赖项的来源
	 */
	@Test
	public void defaultModel1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ModelConfig.class);
		//context.register(ModelBeanFactoryPostProcessor.class);
		context.refresh();

	}

	@Test
	public void autowiredModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.inject");
		context.refresh();

		//context.getBean(F.class).getK();
		I i = context.getBean(F.class).getI();
		log.debug("i==[{}]",i);

	}

	/**
	 * 测试@Order注解的功能
	 *
	 */
	@Test
	public void orderModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.order");
		context.refresh();

		List<E> beanFactoryPostProcessor = context.getBean(T.class).getBeanFactoryPostProcessor();
        for(E e : beanFactoryPostProcessor){
			e.orderList();
		}

	}


	/**
	 * 测试@Lookup注解的功能
	 */
	@Test
	public void lookupModel() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.lookup");
		context.refresh();

		//context.getBean(LA.class).printInfo();

		context.getBean(LC.class).printInfo();
	}
}
