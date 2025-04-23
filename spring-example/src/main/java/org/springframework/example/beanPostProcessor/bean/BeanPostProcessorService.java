package org.springframework.example.beanPostProcessor.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j(topic = "e")
@Component
public class BeanPostProcessorService {

	String str;
	Integer i;

	public BeanPostProcessorService(){
		log.debug("BeanPostProcessorService create");
	}

	public Integer getI(){
		return i;
	}

	public String getStr(){
		return str;
	}

	public void testAop(){
		log.debug("-------BeanPostProcessorService testAop logic----------");
	}

}
