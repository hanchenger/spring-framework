package org.springframework.example.aop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aop.service.DeleteService;
import org.springframework.stereotype.Service;


@Slf4j(topic = "e")
public class DeleteAServiceImpl implements DeleteService {
	@Override
	public void delete() {
		log.debug("a delete");
	}
}
