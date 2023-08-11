package org.springframework.example.scan.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j(topic = "e")
public class B {

	@PostConstruct
	public void init(){
		log.debug("b init");
	}

}
