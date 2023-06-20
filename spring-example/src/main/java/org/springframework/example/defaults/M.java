package org.springframework.example.defaults;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mm")

public class M {
	private static final Logger log = LoggerFactory.getLogger(A.class);
	public M() {
		log.debug("default constructor m");
	}

	@Autowired
	public M(N n) {
		log.debug("Constructor N:{}", n);
	}


	private N n;

	public void setN(N n) {
		log.debug("setter N:{}", n);
	}

	public void setA(A a) {
		log.debug("log a");
	}
}
