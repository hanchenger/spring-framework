package org.springframework.example.batis.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.example.batis.dao.TMapper;
import org.springframework.example.batis.mybatis.MySqlSession;
import org.springframework.example.batis.util.MyImportBeanDefinitionRegistrar;
import org.springframework.example.batis.util.MyMapperScan;
import org.springframework.example.order.E;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@ComponentScan("org.springframework.example.batis")
//@MapperScan("org.springframework.example.batis.dao")
@ImportResource("classpath:spring-batis.xml")
//@Import(MyImportBeanDefinitionRegistrar.class)
@MyMapperScan()
public class BatisConfig {


//	@Bean
//	public DataSource dataSource() {
//
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		driverManagerDataSource.setPassword("root");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/shadow?useSSL=false");
//		return driverManagerDataSource;
//
//	}
//
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(dataSource());
//		return factoryBean.getObject();
//
//	}

	/**
	 * @Bean的方式
	 * 实现把第三方的对象交给spring来管理
	 */
//	@Bean
//	public TMapper tMapper() throws Exception {
//		return (TMapper) MySqlSession.getMapper(TMapper.class);
//
//	}

}
