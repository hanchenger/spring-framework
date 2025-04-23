package org.springframework.example.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Component
public class RollbackRuleService {

	@Autowired
	JdbcTemplate jdbcTemplate;

//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Transactional(rollbackFor = IOException.class,readOnly = true)
	public void update() throws IOException {
		jdbcTemplate.update("update t set t_desc =? where t_name = ?","n","k1");
		throw new IOException();
	}
}
