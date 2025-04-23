package org.springframework.example.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class ServiceInvoke {

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Autowired
	Service1 service1;

	@Autowired
	Service2 service2;

	public void update(){
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setName("事务A");
		TransactionStatus transactionStatus = platformTransactionManager.getTransaction(definition);
		try {
			service1.update();
			service2.update();
 			int i =10/0;
			platformTransactionManager.commit(transactionStatus);
		} catch (Exception e) {
			e.printStackTrace();
			platformTransactionManager.rollback(transactionStatus);
		}
	}
}
