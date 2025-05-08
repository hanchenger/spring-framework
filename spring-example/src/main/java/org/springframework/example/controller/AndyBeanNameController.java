package org.springframework.example.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



//@Component("/test")
public class AndyBeanNameController  implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("test andy");
		return null;
	}


//	@Override
//	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("test andy");
//	}
}
