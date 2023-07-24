package org.springframework.example.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.lifeCycle.config.LifeCycleConfig;

public class LifeCycleTest {

	@Test
	public void defaultCycleTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);



	}
}
