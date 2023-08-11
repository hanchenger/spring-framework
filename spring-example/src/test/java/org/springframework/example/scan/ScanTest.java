package org.springframework.example.scan;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.lifeCycle.config.LifeCycleConfig;
import org.springframework.example.scan.config.ScanConfig;

@Slf4j(topic = "e")
public class ScanTest {


	@Test
	public void defaultScanTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);
	}

}
