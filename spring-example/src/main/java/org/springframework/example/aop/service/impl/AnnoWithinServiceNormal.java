package org.springframework.example.aop.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aop.anno.Aop;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class AnnoWithinServiceNormal {

	public void  m(){
		log.debug("AnnoWithinServiceNormal m ");
	}

}
