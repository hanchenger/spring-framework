package org.springframework.example.aop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aop.anno.Aop;
import org.springframework.example.aop.service.AopService;
import org.springframework.stereotype.Component;

@Component("a")
@Slf4j(topic = "e")
public class AAopServiceImpl implements AopService {


	public void m(){
		log.debug(" AAopServiceImpl a");
	}
}
