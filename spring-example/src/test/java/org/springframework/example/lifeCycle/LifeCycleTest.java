package org.springframework.example.lifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.lifeCycle.bean.D;
import org.springframework.example.lifeCycle.bean.E;
import org.springframework.example.lifeCycle.bean.F;
import org.springframework.example.lifeCycle.config.LifeCycleConfig;


@Slf4j(topic = "e")
public class LifeCycleTest {

	@Test
	public void defaultCycleTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		E e = context.getBean(D.class).getE();
		log.debug("e:[{}]",e);
	}
	@Test
	public void defaultCycleAopTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
	    context.getBean(F.class).m0();
		context.getBean(E.class).m0();
	}

}
