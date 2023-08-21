package org.springframework.example.scan.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j(topic = "e")
//@ComponentScan("org.springframework.example.scan.other")
public class A {


	@PostConstruct
	public void init(){
		log.debug("a init");
	}

//	@Bean
//	public Z z(){
//		return  new Z();
//	}
}
