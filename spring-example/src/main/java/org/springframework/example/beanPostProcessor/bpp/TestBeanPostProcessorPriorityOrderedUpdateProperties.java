package org.springframework.example.beanPostProcessor.bpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.example.beanPostProcessor.bean.BeanPostProcessorService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;


@Slf4j(topic = "e")
//@Component
public class TestBeanPostProcessorPriorityOrderedUpdateProperties implements BeanPostProcessor , PriorityOrdered {

	@Autowired
	BeanPostProcessorService beanPostProcessorService;

	public TestBeanPostProcessorPriorityOrderedUpdateProperties() {
		log.debug("TestBeanPostProcessorPriorityOrderedUpdateProperties create");
	}

	public void printfInfo() {
		log.debug("TestBeanPostProcessorPriorityOrderedUpdateProperties beanPostProcessorService:[{}]", beanPostProcessorService);
	}

	@PostConstruct
	public void postConstruct(){
		log.debug("TestBeanPostProcessorPriorityOrderedUpdateProperties PostConstruct init");
	}


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		if (beanName.equals("beanPostProcessorService")) {
//			Class<?> aClass = bean.getClass();
//			Field[] declaredFields = aClass.getDeclaredFields();
//			for (Field f : declaredFields) {
//				Class<?> type = f.getType();
//				if (f.getName().equals("str")) {
//					try {
//						f.setAccessible(true);
//						f.set(bean, f.get(bean)+"spring");
//					} catch (Exception e) {
//
//					}
//				}
//			}
//			return bean;
//		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 0;
	}


}
