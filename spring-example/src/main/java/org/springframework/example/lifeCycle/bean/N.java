package org.springframework.example.lifeCycle.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "c")
public class N {

	@Autowired
	M m;

	public N(){
		log.debug("create bean n");
	}

	public void printf(){
		log.debug("printf");
	}
}
