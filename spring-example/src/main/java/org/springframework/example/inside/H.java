package org.springframework.example.inside;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 内部类实例化现象
 * bean -- java对象
 * 1.java 常识
 * 2.spring
 */
public class H {

	static class J {


	}

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(J.class);
		context.refresh();
		context.getBean(J.class);
	}
}
