package org.springframework.example.defaults;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;


public class ModelBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	private static final Logger log = LoggerFactory.getLogger("e");

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition)beanFactory.getBeanDefinition("mm");
		log.debug("mode:{}",beanDefinition.getAutowireMode());
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		//beanDefinition.setAutowireMode(3);

	}
}
