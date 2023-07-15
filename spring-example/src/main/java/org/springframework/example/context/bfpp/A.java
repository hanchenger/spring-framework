package org.springframework.example.context.bfpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.example.batis.bean.X;
import org.springframework.stereotype.Component;


@Component
@Slf4j(topic = "e")
public class A implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;

//		BeanDefinitionBuilder k = BeanDefinitionBuilder.genericBeanDefinition(K.class);
//		defaultListableBeanFactory.registerBeanDefinition("k",k.getBeanDefinition());

		BeanDefinitionBuilder x = BeanDefinitionBuilder.genericBeanDefinition(X.class);
		defaultListableBeanFactory.registerBeanDefinition("x",x.getBeanDefinition());

		log.debug("a-p scan parent postProcessBeanFactory");
	}

}
