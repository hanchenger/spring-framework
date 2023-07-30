package org.springframework.example.lifeCycle.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class D implements  F{

	@Autowired
	private E e;

	public E getE() {
		return e;
	}

	public void m0(){
		log.debug("dmo");
	}
}
