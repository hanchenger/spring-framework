package org.springframework.example.aopp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aopp.service.StudentService;
import org.springframework.stereotype.Component;


@Component("s")
@Slf4j(topic = "e")
public class StudentServiceImpl implements StudentService {

	public void add(String name){
		log.debug("name-[{}]",name);
//		int i =1/0;
	}

}
