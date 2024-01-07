package org.springframework.example.enhancer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
@ComponentScan("com.test.enhancer.bean")
@Slf4j(topic = "e")
public class AppconfigProxy  {
	//cglib在生成这个代理类的时候动态添加的一个属性
	BeanFactory $$beanFactory;

//	@Bean
//	public X x(){
//		//BeanMethodInterceptor.intercept
//		return null;
//	}
//
//
//
//	@Bean
//	public Y y(){
//		//BeanMethodInterceptor.intercept
//		return y();
//	}
//
//
//	// 什么时候调用？----？
//	@Override
//	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//		//BeanFactoryAwareMethodInterceptor.intercept(this)
//	}

}
