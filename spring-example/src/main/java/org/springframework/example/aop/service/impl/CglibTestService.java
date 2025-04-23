package org.springframework.example.aop.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = "e")
public class CglibTestService {

	public void method(){
		log.debug("cglib method");
	}
}
