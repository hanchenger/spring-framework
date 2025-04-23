package org.springframework.example.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Component
public class PropagationService1 {

	@Autowired
	JdbcTemplate jdbcTemplate;

//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Autowired
	PropagationService2 propagationService2;

	//@Transactional(propagation = Propagation.REQUIRED)
	public void update()  {
		jdbcTemplate.update("update t set t_desc =? where t_name = ?","n","k1");
		propagationService2.update();
	}
}
