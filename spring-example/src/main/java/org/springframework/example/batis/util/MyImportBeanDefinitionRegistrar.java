package org.springframework.example.batis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.example.batis.dao.AMapper;
import org.springframework.example.batis.dao.TMapper;

import java.util.HashMap;
import java.util.Map;


@Slf4j(topic = "e")
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		log.debug("registerBeanDefinitions execute ......");

		//模拟spring的beanDefinitionMap
		Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(TMapper.class);
		beanDefinitionMap.put("tMapper",builder.getBeanDefinition());
		builder = BeanDefinitionBuilder.genericBeanDefinition(AMapper.class);
		beanDefinitionMap.put("aMapper",builder.getBeanDefinition());


		for(String key : beanDefinitionMap.keySet()){
			AbstractBeanDefinition bd = (AbstractBeanDefinition) beanDefinitionMap.get(key);
			Class<?> beanClass = bd.getBeanClass();
			bd.setBeanClass(MyFactoryBean.class);
			bd.getPropertyValues().add("mapperInterface",beanClass.getName());
			registry.registerBeanDefinition(key,bd);
		}

	}
}
