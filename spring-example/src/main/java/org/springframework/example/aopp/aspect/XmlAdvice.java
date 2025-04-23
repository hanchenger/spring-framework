package org.springframework.example.aopp.aspect;


import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "e")
public class XmlAdvice {


	public void before(){
		log.debug("  aop xml before");
	}

	public void afterReturning(){
		log.debug(" aop xml afterReturning");
	}


	public void after(){
		log.debug(" aop xml after");
	}
}
