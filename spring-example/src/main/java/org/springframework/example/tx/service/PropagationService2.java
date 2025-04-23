package org.springframework.example.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
public class PropagationService2 {

	@Autowired
	JdbcTemplate jdbcTemplate;

//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Transactional(propagation = Propagation.NEVER)
	public void update(){
		jdbcTemplate.update("update t set t_desc =? where t_name = ?","n","k2");
		//int i = 10/0;
	}
}
