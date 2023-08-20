package org.springframework.example.scan;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.scan.config.ScanConfig;
import org.springframework.example.scan.util.ScanBeanDefinitionRegistryPostProcessor;

@Slf4j(topic = "e")
public class ScanTest {


	@Test
	public void defaultScanTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);
	}

	/**
	 * 模拟扫描
	 */
	@Test
	public void defaultImitateScanTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addBeanFactoryPostProcessor(new ScanBeanDefinitionRegistryPostProcessor());
		context.refresh();

	}


}
