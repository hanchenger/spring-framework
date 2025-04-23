package org.springframework.example.introspect.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
@Component
public class SpringBeanInfoTest {


	@Autowired
	AnnotationAutowiredFieldBeanTest annotationAutowiredFieldBeanTest;



	@Autowired
	public void setAnnotationAutowiredMethodBeanTest(AnnotationAutowiredMethodBeanTest annotationAutowiredMethodBeanTest){
		log.debug("AnnotationAutowiredMethodBeanTest=[{}]",annotationAutowiredMethodBeanTest);
	}


	public void setAutowiredInjectByTypeMethodBeanTest(AutowiredInjectByTypeMethodBeanTest autowiredInjectByTypeMethodBeanTest){
		log.debug("AutowiredInjectByTypeMethodBeanTest=[{}]",autowiredInjectByTypeMethodBeanTest);
	}

	public void setBeanDefinitionPropertyValuesBeanTest(BeanDefinitionPropertyValuesBeanTest beanDefinitionPropertyValuesBeanTest){
		log.debug("BeanDefinitionPropertyValuesBeanTest=[{}]",beanDefinitionPropertyValuesBeanTest);
	}

	public void printIn(){
		log.debug("annotationAutowiredFieldBeanTest=[{}]",annotationAutowiredFieldBeanTest);
	}

}
