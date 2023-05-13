package org.springframework.automode;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.config.ModelConfig;
import org.springframework.example.defaults.ModelBeanFactoryPostProcessor;
import org.springframework.example.statics.A;
import org.springframework.example.statics.Config;
import org.springframework.example.statics.ObjectFactory;
import org.springframework.example.statics.SupplierFactory;

import java.util.function.Supplier;

@Slf4j
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

}
