package org.springframework.example.app.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j(topic = "e")
public class T {

	public T(){
		log.debug("create t");
	}

}
