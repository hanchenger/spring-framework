package org.springframework.example.scan;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.scan.config.ScanConfig;
import org.springframework.example.scan.inherited.PImpl;
import org.springframework.example.scan.inherited.S;
import org.springframework.example.scan.inherited.SImpl;
import org.springframework.example.scan.inherited.Sinherited;
import org.springframework.example.scan.util.MyBeanNameGenerator;
import org.springframework.example.scan.util.ScanBeanDefinitionRegistryPostProcessor;

import java.lang.annotation.Annotation;

@Slf4j(topic = "e")
public class ScanTest {


	/**
	 * spring完成扫描的代码在哪里
	 */
	@Test
	public void defaultScanTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);
	}

	/**
	 * 模拟spring的扫描
	 */
	@Test
	public void defaultImitateScanTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addBeanFactoryPostProcessor(new ScanBeanDefinitionRegistryPostProcessor());
		context.refresh();

	}

	/**
	 * 理解spring当中有两个扫描器
	 * 测试两个扫描器
	 */
	@Test
	public void defaultTowScannerTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.example.scan.bean");
		context.refresh();
	}

	/**
	 * 测试Scanner1beanNameGenerate
	 */
	@Test
	public void defaultScanner1BeanNameGenerateTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ScanConfig.class);
		context.setBeanNameGenerator(new MyBeanNameGenerator());
		context.refresh();

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
	}

	/**
	 * 测试Scanner2beanNameGenerate
	 */
	@Test
	public void defaultScanner2BeanNameGenerateTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
	}


	/**
	 * inherited注解有什么用
	 */
	@Test
	public void inheritedScanTest(){
		Annotation[] annotations = Sinherited.class.getAnnotations();

		log.info("------------------------子类测试------------------------");
		for(Annotation annotation: annotations){
			log.info("annotation:[{}]",annotation);
		}

		log.info("------------------------接口测试------------------------");
		log.info("不会有任何打印，因为子接口不能继承父接口上的注解，那怕加了@Inherited注解");
		annotations = S.class.getAnnotations();
		for(Annotation annotation: annotations){
			log.info("annotation:[{}]",annotation);
		}

		log.info("------------------------子接口实现类测试------------------------");
		log.info("不会有任何打印，因为接口实现类不能继承接口上的注解，那怕加了@Inherited注解");
		annotations = SImpl.class.getAnnotations();
		for(Annotation annotation: annotations){
			log.info("annotation:[{}]",annotation);
		}


		log.info("------------------------父接口实现类测试------------------------");
		log.info("不会有任何打印，因为接口实现类不能继承接口上的注解，那怕加了@Inherited注解");
		annotations = PImpl.class.getAnnotations();
		for(Annotation annotation: annotations){
			log.info("annotation:[{}]",annotation);
		}

	}


}
