package org.springframework.example.app.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j(topic = "e")
public class M {

	public M(){
		log.debug("create m");
	}


	@Bean
	public N n(){
		return new N();
	}
}
