package org.springframework.example.scan.bean;


import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j(topic = "e")
public class C {

	static {
		log.debug("c static ......");
	}

	@PostConstruct
	public void init(){
		log.debug("c init");
	}

}
