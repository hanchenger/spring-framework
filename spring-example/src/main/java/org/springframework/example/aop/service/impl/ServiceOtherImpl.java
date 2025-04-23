package org.springframework.example.aop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aop.service.Service;
import org.springframework.example.aop.service.ServiceOther;


@Slf4j(topic = "e")
@org.springframework.stereotype.Service
public class ServiceOtherImpl implements ServiceOther {


	@Override
	public void methodOther() {
		log.debug("methodOther ");
	}
}
