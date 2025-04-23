package org.springframework.example.app.bean;

import org.springframework.context.annotation.Bean;

public interface I {

	@Bean
	public default S s(){
		return  new S();
	}
}
