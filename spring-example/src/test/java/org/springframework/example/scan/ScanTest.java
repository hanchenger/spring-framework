package org.springframework.example.scan;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.scan.config.ScanConfig;
import org.springframework.example.scan.util.MyBeanNameGenerator;
import org.springframework.example.scan.util.ScanBeanDefinitionRegistryPostProcessor;

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
}
