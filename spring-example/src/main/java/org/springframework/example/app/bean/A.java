package org.springframework.example.app.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import(P.class)
@Slf4j(topic = "e")
public class A {
	public A(){
		log.debug("create a");
	}

}
