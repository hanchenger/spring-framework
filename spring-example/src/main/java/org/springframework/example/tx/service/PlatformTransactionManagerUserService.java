package org.springframework.example.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


/**
 * 编程式事务
 * 方式一
 */
@Component
public class PlatformTransactionManagerUserService {


	/**
	 * 这个对象需要我们去配置，默认不存在spring容器当中
	 * 1.注解
	 * 2.xml
	 * 这个对象的注入方式1或者2没有区别
	 * 但是实现spring的事务方式注解和xml以及他们混合开发是有区别的
	 */
	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Autowired
	JdbcTemplate jdbcTemplate;


	//@Transactional
	public  void update(){
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setName("事务A");
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(definition);

		try {
			jdbcTemplate.update("update t set t_desc =? where t_name = ?","n","k1");
			int i =10/0;
			jdbcTemplate.update("update t set t_desc =? where t_name = ?","n","k2");
			platformTransactionManager.commit(transactionStatus);
		} catch (Exception e) {
			e.printStackTrace();
			platformTransactionManager.rollback(transactionStatus);
		}

	}
}
