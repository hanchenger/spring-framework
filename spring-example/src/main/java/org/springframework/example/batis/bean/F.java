package org.springframework.example.batis.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
@Component
public class F implements IAware{

	//@Autowired
	K k;

	public void setK(K k){
		log.debug("Fk:{}",k);
		this.k = k;
	}

	public K getK(){
		return k;
	}

}
