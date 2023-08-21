package org.springframework.example.scan.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j(topic = "e")
//@Scope("prototype")
@ComponentScan("org.springframework.example.scan.other")
public class Y {


	@PostConstruct
	public void init(){
		log.debug("y init");
	}

	@Bean
	public Z z(){
		return  new Z();
	}
}
