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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Slf4j(topic = "e")
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	Set<BeanDefinitionHolder> beanDefinitionHolders = null;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		log.debug("registerBeanDefinitions execute ......");
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName());
		scan(registry,annotationAttributes);
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			AbstractBeanDefinition bd = (AbstractBeanDefinition) beanDefinitionHolder.getBeanDefinition();
			String beanClassName = bd.getBeanClassName();
			bd.setBeanClass(MyFactoryBean.class);
			bd.getPropertyValues().add("mapperInterface", beanClassName);
		}

	}

	public void scan(BeanDefinitionRegistry registry,Map<String, Object> annotationAttributes ) {
		String scanMapperStr = (String) annotationAttributes.get("value");
		MyMapperScanner myMapperScanner = new MyMapperScanner(registry, false);
		myMapperScanner.registerFilters();
		beanDefinitionHolders = myMapperScanner.doScan(scanMapperStr);

	}
}
