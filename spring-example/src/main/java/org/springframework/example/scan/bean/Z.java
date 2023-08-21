package org.springframework.example.scan.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j(topic = "e")
public class Z {


	@PostConstruct
	public void init(){
		log.debug("z init");
	}
}
