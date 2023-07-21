package org.springframework.example.batis.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Z {


	@Autowired
	ApplicationContext applicationContext;
}
