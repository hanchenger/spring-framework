package org.springframework.example.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
public class D {

	public D(){
		log.debug("d created");
	}
}
