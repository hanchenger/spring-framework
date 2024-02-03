package org.springframework.example.enhancer.bean;


import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "e")
public class Z {
	public Z(){
		log.debug("z create");
	}

	public void m0() {
		log.debug("-----===m0=============");
		log.debug("-----===m0 end=============");
	}

	public void m1() {
		log.debug("-----===m1=============");
		log.debug("-----===m1 end=============");
	}

	public void m2() {
		log.debug("-----===m2============");
		log.debug("-----===m2 end=============");
	}
}
