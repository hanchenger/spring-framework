package org.springframework.example.scan.other;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j(topic = "e")
//@Scope("prototype")
public class H {


	@PostConstruct
	public void init(){
		log.debug("H init");
	}
}
