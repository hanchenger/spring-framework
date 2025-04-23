package org.springframework.example.introspect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.introspect.bean.IntrospectDemoBean;
import org.springframework.example.introspect.bean.SpringBeanInfoTest;
import org.springframework.example.introspect.config.App;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


@Slf4j(topic = "e")
public class IntrospectTest {

	Map<String,PropertyDescriptor> propertyDescriptorMap = new HashMap<>();

	@Test
	public void testIntrospect(){
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(IntrospectDemoBean.class);
			PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor p : ps) {
				propertyDescriptorMap.put(p.getName(),p);
			}

			Method age = propertyDescriptorMap.get("age").getWriteMethod();



		} catch (IntrospectionException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public void testSpringIntrospect(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();

		context.getBean(SpringBeanInfoTest.class).printIn();
	}


}
