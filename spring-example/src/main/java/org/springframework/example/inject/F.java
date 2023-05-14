package org.springframework.example.inject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class F {

	@Autowired
	I a;

	K k;

	public K getK() {
		return k;
	}

	public I getI() {
		return a;
	}

	public void setA(I a) {
		log.debug("a---{}", a);
	}
}
