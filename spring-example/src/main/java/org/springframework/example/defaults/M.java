package org.springframework.example.defaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mm")
@Slf4j(topic = "e")
public class M {

	public M() {
		log.debug("default constructor m");
	}

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
