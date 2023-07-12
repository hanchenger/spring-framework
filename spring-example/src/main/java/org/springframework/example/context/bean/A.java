package org.springframework.example.context.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.example.context.event.ABeanInitEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@Slf4j(topic = "e")
public class A implements InitializingBean {

	@Autowired
	C c;


	@Autowired
	//ApplicationContext context;


	public A(){
		log.debug("create a Object");
	}

	@PostConstruct
	public void init(){
		log.debug("a init PostConstruct");
		//context.publishEvent(new ABeanInitEvent(context));
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("a init afterPropertiesSet");

	}

	public C getC() {
		log.debug("c:[{}]",c);
		return c;
	}

	public void setC(C c) {
		log.debug("autowired C");
		this.c = c;
	}
}
