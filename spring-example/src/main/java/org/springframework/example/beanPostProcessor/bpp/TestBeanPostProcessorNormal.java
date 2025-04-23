package org.springframework.example.beanPostProcessor.bpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.example.beanPostProcessor.bean.BeanPostProcessorService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Slf4j(topic = "e")
@Component
public class TestBeanPostProcessorNormal implements BeanPostProcessor, InitializingBean {

	@Autowired
	BeanPostProcessorService beanPostProcessorService;

	public TestBeanPostProcessorNormal() {
		log.debug("TestBeanPostProcessorNormal create");
	}


	@PostConstruct
	public void postConstruct(){
		log.debug("TestBeanPostProcessorNormal PostConstruct init");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("TestBeanPostProcessorNormal InitializingBean init");
	}

	public void printfInfo() {
		log.debug("TestBeanPostProcessorNormal beanPostProcessorService:[{}]", beanPostProcessorService);
	}



}
