package org.springframework.example;

import org.apache.ibatis.logging.LogFactory;

public class Main {
	public static void main(String[] args) {

		System.out.println("Hello world!");

	    //mybatis日志
		String name = LogFactory.class.getName();
		System.out.println(name);
	}
}