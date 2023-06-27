package org.springframework.example.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class Y {

	public Y(){
		log.debug("y created");
	}
}
