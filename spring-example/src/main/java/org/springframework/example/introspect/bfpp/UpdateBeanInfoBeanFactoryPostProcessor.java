package org.springframework.example.introspect.bfpp;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.example.introspect.bean.BeanDefinitionPropertyValuesBeanTest;
import org.springframework.stereotype.Component;

@Component
public class UpdateBeanInfoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition springBeanInfoTest = (AbstractBeanDefinition) beanFactory.getBeanDefinition("springBeanInfoTest");
		springBeanInfoTest.setAutowireMode(0);
		//springBeanInfoTest.getPropertyValues().add("beanDefinitionPropertyValuesBeanTest",new BeanDefinitionPropertyValuesBeanTest());
	}
}
