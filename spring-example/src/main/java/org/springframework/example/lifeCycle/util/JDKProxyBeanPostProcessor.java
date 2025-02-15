package org.springframework.example.lifeCycle.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


@Slf4j(topic = "e")
@Component
public class JDKProxyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("d")){
			ClassLoader classLoader = JDKProxyBeanPostProcessor.class.getClassLoader();
			Class<?>[] interfaces = bean.getClass().getInterfaces();
			Object o = Proxy.newProxyInstance(classLoader, interfaces, new MyInvocationHandler(bean));
			return o;
		}
		return bean;
	}


	class MyInvocationHandler implements InvocationHandler{

		Object target;
		public MyInvocationHandler(Object target){
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			log.debug("method before");
			method.invoke(target,args);
			log.debug("method after");
			return null;
		}
	}

}
