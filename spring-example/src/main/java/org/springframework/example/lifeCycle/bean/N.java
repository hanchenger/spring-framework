package org.springframework.example.lifeCycle.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class N implements InitializingBean {

	@Autowired
	M m;

	public N(){
		log.debug("create bean n");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		m.printf();
	}
}
