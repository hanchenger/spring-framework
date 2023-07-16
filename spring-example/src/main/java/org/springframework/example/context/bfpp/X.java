package org.springframework.example.context.bfpp;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j(topic = "e")
public class X {

	public X () {
		log.debug("x bd create normal");
	}

	//@Bean 注解容许这个bean不在spring容器中,
	@Bean
	public Y y(){
		log.debug("x @bean create y");
		return new Y();
	}
}
