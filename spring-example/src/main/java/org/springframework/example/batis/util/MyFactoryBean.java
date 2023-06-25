package org.springframework.example.batis.util;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.example.batis.dao.TMapper;
import org.springframework.example.batis.mybatis.MySqlSession;
import org.springframework.example.order.T;
import org.springframework.stereotype.Component;


/**
 * FactoryBean来实现把第三方的对象交给spring来管理
 */
//@Component
public class MyFactoryBean implements FactoryBean {

	private Class<T> mapperInterface;

	public void setMapperInterface(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		Object mapper = MySqlSession.getMapper(mapperInterface);
		return mapper;
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
