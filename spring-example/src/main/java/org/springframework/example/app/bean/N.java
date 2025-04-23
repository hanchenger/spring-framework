package org.springframework.example.app.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j(topic = "e")
@Import(P.class)
public class N {
	public N(){
		log.debug("create n");
	}

}
