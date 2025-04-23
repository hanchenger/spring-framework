package org.springframework.example.aop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aop.service.Service;


@Slf4j(topic = "e")
@org.springframework.stereotype.Service("aService")
public class AServiceImpl implements Service {


	@Override
	public void method() {
		log.debug("general method");
	}

	@Override
	public void methodIntegerArgs(Integer i) {
		log.debug("methodIntegerArgs integer:[{}]",i);
	}

	@Override
	public void methodIntegerMultiArgs(Integer i, String s) {
		log.debug("methodIntegerMultiArgs integer:[{}] string:[{}]",i,s);
	}


}
