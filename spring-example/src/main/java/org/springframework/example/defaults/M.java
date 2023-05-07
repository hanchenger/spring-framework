package org.springframework.example.defaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("mm")
@Slf4j(topic = "e")
public class M {

	public M(){
		log.debug("default constructor m");
	}
}
