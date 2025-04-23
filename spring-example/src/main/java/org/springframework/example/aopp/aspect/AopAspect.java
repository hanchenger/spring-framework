package org.springframework.example.aopp.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j(topic = "e")
public class AopAspect {

	@Pointcut("execution(* org.springframework.example.aopp.service..*.*(..))")
	public void pointCut(){

	}


	@AfterThrowing("pointCut()")
	public void b (){
		log.debug("aop anno afterThrowing");
	}

	@After("pointCut()")
	public void d (){
		log.debug("aop anno after");
	}

	@AfterReturning("pointCut()")
	public void c (){
		log.debug("aop anno afterReturning");
	}





	@Before("pointCut()")
	public void a (){
		log.debug("aop anno before");
	}







}
