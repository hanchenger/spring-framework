package org.springframework.example.scan.bean;


import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "e")
public class P {

	static {
		log.debug("p static");
	}
}
