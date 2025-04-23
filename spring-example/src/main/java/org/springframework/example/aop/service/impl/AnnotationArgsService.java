package org.springframework.example.aop.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.example.aop.anno.Parameter;
import org.springframework.example.aop.anno.Parameter2Anno;
import org.springframework.example.aop.anno.ParameterAnno;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "e")
public class AnnotationArgsService {

	public void  method1(Parameter p){
		log.debug("m1---p[{}]",p);
	}

	public void  method2(ParameterAnno p){
		log.debug("m2--p[{}]",p);
	}

	public void  method3(ParameterAnno p, Parameter2Anno p2){
		log.debug("m3---p-p2[{}],[{}]",p,p2);
	}

	public void  method4(ParameterAnno p){
		log.debug("m4---p[{}]",p);
	}

}
