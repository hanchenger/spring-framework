package org.springframework.example.defaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mm")
@Slf4j
public class M {

	public M() {
		log.info("default constructor m");
	}

	//@Autowired
	public M(N n) {
		log.info("Constructor N:{}", n);
	}


	private N n;

	public void setN(N n) {
		log.info("setter N:{}", n);
	}

	public void setA(A a) {
		log.info("log a");
	}
}
