package org.springframework.example.scan.bean;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j(topic = "e")
public class E implements D{

	@PostConstruct
	public void init(){
		log.debug("d init");
	}
}
