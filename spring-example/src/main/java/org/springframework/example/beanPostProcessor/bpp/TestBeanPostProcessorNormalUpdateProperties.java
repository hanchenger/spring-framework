package org.springframework.example.beanPostProcessor.bpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.example.beanPostProcessor.bean.BeanPostProcessorService;
import org.springframework.example.order.E;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;


@Slf4j(topic = "e")
//@Component
public class TestBeanPostProcessorNormalUpdateProperties implements BeanPostProcessor {

	public TestBeanPostProcessorNormalUpdateProperties() {
		log.debug("TestBeanPostProcessorNormalUpdateProperties create");
	}


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("beanPostProcessorService")) {
			Class<?> aClass = bean.getClass();
			Field[] declaredFields = aClass.getDeclaredFields();
			for (Field f : declaredFields) {
				Class<?> type = f.getType();
				if (f.getName().equals("str")) {
					try {
						f.setAccessible(true);
						f.set(bean, "spring");
					} catch (Exception e) {

					}
				}
			}
			return bean;
		}
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
