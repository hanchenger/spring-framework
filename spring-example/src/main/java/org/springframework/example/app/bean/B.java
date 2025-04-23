package org.springframework.example.app.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j(topic = "e")
public class B {
	public B(){
		log.debug("create b");
	}

}
