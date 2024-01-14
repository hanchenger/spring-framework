package org.springframework.example.enhancer.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j(topic = "e")
public class E {

	public E (){
		log.debug("e create");
	}
}
