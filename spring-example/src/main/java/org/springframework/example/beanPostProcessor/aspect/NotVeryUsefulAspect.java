package org.springframework.example.beanPostProcessor.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j(topic = "e")
public class NotVeryUsefulAspect {


	@Pointcut("within(org.springframework.example.beanPostProcessor.bean.BeanPostProcessorService)")
	public void pointCutWithin() {

	}


	@Before("pointCutWithin()")
	public void adviceBeforeService() {
		log.debug("========== before aop=============");
	}


}
