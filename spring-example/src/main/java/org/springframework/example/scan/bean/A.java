package org.springframework.example.scan.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j(topic = "e")
//@Scope("prototype")
@ComponentScan("org.springframework.example.scan.other")
public class A {


	@PostConstruct
	public void init(){
		log.debug("a init");
	}
}
