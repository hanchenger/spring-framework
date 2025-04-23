package org.springframework.example.tx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicePropagationInvoke {


	@Autowired
	PropagationService1 service1;

	@Autowired
	PropagationService2 service2;

	/**
     * 测试事务传播行为
	 */
	public void updatePropagation(){
		try {
			service1.update();
			service2.update();
			//int i =10/0;
		} catch (Exception e) {

		}
	}
}
