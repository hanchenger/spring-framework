package org.springframework.example.controller;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class AndyControllerAdvice // implements ResponseBodyAdvice//
//
{

	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat,false));
	}

//	@ModelAttribute("user")
//	public String addString(@RequestParam(value = "user",required = false) String value) {
//		return value;  // 返回 /WEB-INF/views/index.jsp
//	}

//	@Override
//	public boolean supports(MethodParameter returnType, Class converterType) {
//		return true;
//	}
//
//	@Override
//	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//		return "hello:"+body;
//	}
}
