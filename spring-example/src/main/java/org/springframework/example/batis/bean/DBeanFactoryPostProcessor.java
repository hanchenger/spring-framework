package org.springframework.example.batis.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;


@Component
public class DBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		AbstractBeanDefinition xbeanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("x");
//		xbeanDefinition.setBeanClass(D.class);

				AbstractBeanDefinition e = (AbstractBeanDefinition) beanFactory.getBeanDefinition("e");
		e.setAutowireMode(2);

				AbstractBeanDefinition f = (AbstractBeanDefinition) beanFactory.getBeanDefinition("f");
		f.setAutowireMode(2);

		//beanFactory.ignoreDependencyType(K.class);

		beanFactory.ignoreDependencyInterface(IAware.class);
	}
}
