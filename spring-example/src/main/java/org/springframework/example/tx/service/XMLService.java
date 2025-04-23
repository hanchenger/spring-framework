package org.springframework.example.tx.service;


import org.springframework.jdbc.core.JdbcTemplate;

public class XMLService {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	public void update(){
		jdbcTemplate.update("update t set t_desc =? where t_name = ?","n","k1");
		//throw new NullPointerException();
	}
}
