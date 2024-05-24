package org.springframework.example.batis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.example.batis.dao.AMapper;
import org.springframework.example.batis.dao.TMapper;
import org.springframework.example.defaults.M;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Slf4j(topic = "e")
@Component
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		log.debug("registerBeanDefinitions execute ......");
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
		AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		registry.registerBeanDefinition("myBeanFactory",beanDefinition);
	}

}
