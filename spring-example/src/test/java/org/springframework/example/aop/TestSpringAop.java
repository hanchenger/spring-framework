package org.springframework.example.aop;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.aop.advice.BeforeAdvice;
import org.springframework.example.aop.anno.Parameter;
import org.springframework.example.aop.anno.Parameter2Anno;
import org.springframework.example.aop.anno.ParameterAnno;
import org.springframework.example.aop.config.App;
import org.springframework.example.aop.service.*;
import org.springframework.example.aop.service.impl.*;


@Slf4j(topic = "e")
public class TestSpringAop {

	/**
	 *
	 */
	@Test
	public void defaultScanTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		Service bean = (Service) context.getBean("aService");
		bean.method();
		bean.methodIntegerArgs(2);
		bean.methodIntegerMultiArgs(3,"3");

		Service beanb = (Service) context.getBean("bService");
		beanb.method();
		beanb.methodIntegerArgs(12);
		beanb.methodIntegerMultiArgs(13,"13");

		ServiceOther bean1 = context.getBean(ServiceOther.class);
		bean1.methodOther();

		CglibTestService bean2 = context.getBean(CglibTestService.class);
		bean2.method();


	}

	/**
	 * 测试Introduction
	 */
	@Test
	public void testAopIntroduction(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		UserService bean = context.getBean(UserService.class);
		bean.query();


		if(bean instanceof DeleteService){
			DeleteService deleteService = (DeleteService) bean;
			deleteService.delete();
		}


	}

	/**
	 * 测试@Args
	 */
	@Test
	public void testAopArgsAnnotation(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		AnnotationArgsService bean = context.getBean(AnnotationArgsService.class);
		bean.method1(new Parameter());
		bean.method2(new ParameterAnno());
		bean.method3(new ParameterAnno(),new Parameter2Anno());
		bean.method4(new ParameterAnno());
	}

	/**
	 * 测试@within
	 */
	@Test
	public void testAopWithInAnnotation() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		AnnoWithinService bean = context.getBean(AnnoWithinService.class);
		bean.m();



		AnnoWithinServiceNormal normal = context.getBean(AnnoWithinServiceNormal.class);
		normal.m();

	}



	/**
	 * 测试@annotation
	 */
	@Test
	public void testAopAnnotation() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		AnnoAnnotationService bean = context.getBean(AnnoAnnotationService.class);
		bean.m();

		AnnoAnnotationServiceNormal normal = context.getBean(AnnoAnnotationServiceNormal.class);
		normal.m();
	}


	/**
	 * 测试@annotation
	 */
	@Test
	public void testAop() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		AopService bean = (AopService) context.getBean("a");
		bean.m();

		AopService bBean = (AopService) context.getBean("b");
		bBean.m();
	}


	/**
	 *
	 */
	@Test
	public void testCustomerAop() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(AopService.class);
		proxyFactory.addAdvice(new BeforeAdvice());
		proxyFactory.setTarget(new BAopServiceImpl());

		AopService proxy = (AopService)proxyFactory.getProxy();
		//通知是怎么执行的
		//目标方法是什么时候调用的
		proxy.m();
	}

}
