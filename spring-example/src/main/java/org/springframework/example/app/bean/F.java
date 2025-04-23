package org.springframework.example.app.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;

@Slf4j(topic = "e")
public class F {
	public F(){
		log.debug("create f");
	}

}
