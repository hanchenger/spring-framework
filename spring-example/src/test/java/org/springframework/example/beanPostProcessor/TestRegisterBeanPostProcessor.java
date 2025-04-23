package org.springframework.example.beanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.beanPostProcessor.bean.BeanPostProcessorService;
import org.springframework.example.beanPostProcessor.bpp.TestBeanPostProcessorNormal;
import org.springframework.example.beanPostProcessor.bpp.TestBeanPostProcessorOrderedUpdateProperties;
import org.springframework.example.beanPostProcessor.bpp.TestBeanPostProcessorPriorityOrderedUpdateProperties;
import org.springframework.example.beanPostProcessor.config.App;


@Slf4j(topic = "e")
public class TestRegisterBeanPostProcessor {



	@Test
	public void testBeanFactoryPostProcessor(){

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		//context.addBeanFactoryPostProcessor(new Z());
		context.refresh();

	}

	@Test
	public void testBeanPostProcessor(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		//context.addBeanFactoryPostProcessor(new Z());
		context.refresh();

		BeanPostProcessorService bean = context.getBean(BeanPostProcessorService.class);
		String str = bean.getStr();
		Integer i = bean.getI();
		log.debug("str[{}],i[{}]",str,i);
	}


	@Test
	public void testBeanPostProcessorAutoWired(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();

		TestBeanPostProcessorNormal bean = context.getBean(TestBeanPostProcessorNormal.class);
		bean.printfInfo();
	}


	@Test
	public void testBeanPostProcessorOrderAutoWired(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();



		TestBeanPostProcessorOrderedUpdateProperties bean = context.getBean(TestBeanPostProcessorOrderedUpdateProperties.class);
		bean.printfInfo();
	}

	@Test
	public void testBeanPostProcessorPriorityOrderAutoWired(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();



		TestBeanPostProcessorPriorityOrderedUpdateProperties bean = context.getBean(TestBeanPostProcessorPriorityOrderedUpdateProperties.class);
		bean.printfInfo();
	}

	@Test
	public void testBeanPostProcessorAop(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();

		BeanPostProcessorService bean = context.getBean(BeanPostProcessorService.class);
		bean.testAop();
	}


	@Test
	public void testBeanPostProcessorAop1(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();


//		BeanPostProcessorService beans = context.getBean(BeanPostProcessorService.class);
//		beans.testAop();

		TestBeanPostProcessorOrderedUpdateProperties bean = context.getBean(TestBeanPostProcessorOrderedUpdateProperties.class);
		bean.printfInfo();

		TestBeanPostProcessorPriorityOrderedUpdateProperties bean1 = context.getBean(TestBeanPostProcessorPriorityOrderedUpdateProperties.class);
		bean1.printfInfo();

	}


}
