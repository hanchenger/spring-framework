package org.springframework.example.batis.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
@Component
public class E {

	K k;

	public void setK(K k){
		log.debug("Ek:{}",k);
		this.k = k;
	}

}
