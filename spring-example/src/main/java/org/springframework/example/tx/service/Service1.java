package org.springframework.example.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Service1 {


	@Autowired
	JdbcTemplate jdbcTemplate;

	public void update(){
		jdbcTemplate.update("update t set t_desc =? where t_name = ?","n","k1");
	}
}
