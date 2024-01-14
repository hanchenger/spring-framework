package org.springframework.example.enhancer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.example.enhancer.bean.X;
import org.springframework.example.enhancer.bean.Y;

@Configuration
@Slf4j(topic = "e")
@ComponentScan("org.springframework.example.enhancer.bean")
public class Appconfig {


	@Bean
	public X x(){
		log.debug("Appconfig#x() invoke");
		return  new X();
	}

	@Bean
	public Y y(){
		x();
		return  new Y();
	}

}
