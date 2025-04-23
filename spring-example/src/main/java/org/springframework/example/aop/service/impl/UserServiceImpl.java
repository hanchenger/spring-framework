package org.springframework.example.aop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aop.service.UserService;
import org.springframework.stereotype.Service;


@Service
@Slf4j(topic = "e")
public class UserServiceImpl implements UserService {

	@Override
	public void query() {
		log.debug("user service query");
	}

}
