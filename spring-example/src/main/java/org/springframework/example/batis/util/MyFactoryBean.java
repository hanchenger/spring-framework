package org.springframework.example.batis.util;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.example.batis.dao.TMapper;
import org.springframework.example.batis.mybatis.MySqlSession;
import org.springframework.stereotype.Component;


/**
 * FactoryBean来实现把第三方的对象交给spring来管理
 */
@Component
public class MyFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return MySqlSession.getMapper(TMapper.class);
	}

	@Override
	public Class<?> getObjectType() {
		return TMapper.class;
	}
}
