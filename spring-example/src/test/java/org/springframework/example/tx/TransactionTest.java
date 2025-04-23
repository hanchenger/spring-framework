package org.springframework.example.tx;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.example.tx.config.App;
import org.springframework.example.tx.service.*;

import java.io.IOException;


@Slf4j(topic = "e")
public class TransactionTest {

	@Test
	public void testJdbcTemplate(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PlatformTransactionManagerUserService.class).update();
	}


	/**
	 * 编程式事务
	 * 第一种实现方式
	 */
	@Test
	public void testTransactionManagerOne(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PlatformTransactionManagerUserService.class).update();
	}


	/**
	 * 编程式事务
	 * 第二种实现方式
	 */
	@Test
	public void testTransactionManagerTwo(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(TransactionTemplateUserService.class).update();
	}

	/**
	 * 测试事务失效
	 *
	 *
	 */
	@Test
	public void testTransactionInvalidation(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(ServiceInvoke.class).update();
	}

	/**
	 * 声明式事务
	 * xml
	 *
	 *
	 */
	@Test
	public void testXMlTransaction(){
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:appTransaction4xml.xml");
		XMLService bean = classPathXmlApplicationContext.getBean(XMLService.class);
		bean.update();
	}

	/**
	 * 声明式事务
	 * 注解
	 *
	 *
	 */
	@Test
	public void testAnnotationTransaction(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(AnnotationService.class).update();
	}

	/**
	 * 声明式事务
	 * 注解和xml混合使用
	 *
	 *
	 */
	@Test
	public void testAnnotationAndXmlTransaction(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(AnnotationAndXmlService.class).update();
	}

	/**
	 * 测试事务的传播行为
	 *
	 *
	 */
	@Test
	public void testTransactionPropagation(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(ServicePropagationInvoke.class).updatePropagation();
	}

	/**
	 * 测试事务的传播行为
	 * required
	 *
	 */
	@Test
	public void testTransactionPropagationRequired(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PropagationService1.class).update();
	}

	/**
	 * 测试事务的传播行为
	 * requires_new
	 *
	 */
	@Test
	public void testTransactionPropagationRequiresNew(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PropagationService1.class).update();
	}

	/**
	 * 测试事务的传播行为
	 * nested
	 *
	 */
	@Test
	public void testTransactionPropagationNested(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PropagationService1.class).update();
	}

	/**
	 * 测试事务的传播行为
	 * mandatory
	 *
	 */
	@Test
	public void testTransactionPropagationMandatory(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PropagationService1.class).update();
	}

	/**
	 * 测试事务的传播行为
	 * supports
	 *
	 */
	@Test
	public void testTransactionPropagationSupports(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PropagationService1.class).update();
	}

	/**
	 * 测试事务的传播行为
	 * not_supported
	 *
	 */
	@Test
	public void testTransactionPropagationNotSupported(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PropagationService1.class).update();
	}

	/**
	 * 测试事务的传播行为
	 * never
	 *
	 */
	@Test
	public void testTransactionPropagationNever(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(PropagationService1.class).update();
	}

	/**
	 * 测试事务回滚
	 *
	 *
	 */
	@Test
	public void testTransactionRollback() throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		context.refresh();
		context.getBean(RollbackRuleService.class).update();
	}

}
