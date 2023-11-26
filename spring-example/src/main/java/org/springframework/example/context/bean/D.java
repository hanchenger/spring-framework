package org.springframework.example.context.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class D {

	public D() {
		log.debug("create d Object");
	}
}