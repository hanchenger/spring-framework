package org.springframework.example.aop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aop.service.AopService;
import org.springframework.stereotype.Component;

@Component("b")
@Slf4j(topic = "e")
public class BAopServiceImpl implements AopService {


	public void m(){
		log.debug(" BAopServiceImpl b");
	}
}
