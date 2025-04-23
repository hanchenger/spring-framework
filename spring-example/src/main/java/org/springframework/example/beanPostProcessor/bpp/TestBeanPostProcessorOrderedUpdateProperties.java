package org.springframework.example.beanPostProcessor.bpp;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.example.beanPostProcessor.bean.BeanPostProcessorService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;


@Slf4j(topic = "e")
//@Component
public class TestBeanPostProcessorOrderedUpdateProperties implements BeanPostProcessor , Ordered  {

	@Autowired
	BeanPostProcessorService beanPostProcessorService;

	public TestBeanPostProcessorOrderedUpdateProperties() {
		log.debug("TestBeanPostProcessorOrderedUpdateProperties create");
	}

	public void printfInfo() {
		log.debug("TestBeanPostProcessorOrderedUpdateProperties beanPostProcessorService:[{}]", beanPostProcessorService);
	}

	@PostConstruct
	public void postConstruct(){
		log.debug("TestBeanPostProcessorOrderedUpdateProperties PostConstruct init");
	}



	@SneakyThrows
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
