package org.springframework.example.batis;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.batis.config.BatisConfig;
import org.springframework.example.batis.dao.TMapper;
import org.springframework.example.batis.mybatis.MySqlSession;
import org.springframework.example.batis.service.TService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j(topic = "e")
public class BatisTest {


	@Test
	public void defaultBatis(){

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BatisConfig.class);
		TService tService = context.getBean(TService.class);

		Map<String, Object> resultMap = tService.queryFroMap(1);
		List<Map<String, Object>> resultList = tService.queryFroList();

		log.debug("resultMap:{}",resultMap);
		log.debug("--------------------------------------------------------------------");
		log.debug("resultList:{}",resultList);

	}

	@Test
	public void onlyBatis(){

//		BatisConfig config = new BatisConfig();
//
//		DataSource dataSource = config.dataSource();
//
//		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		Environment environment = new Environment("development",transactionFactory,dataSource);
//		Configuration configuration = new Configuration(environment);
//		configuration.addMapper(TMapper.class);
//
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		TMapper mapper = sqlSession.getMapper(TMapper.class);
//
//		Map<String, Object> resultMap = mapper.queryFroMap(1);
//
//		log.debug("resultMap:{}",resultMap);


	}

	/**
	 * 测试
	 * 模拟的简单的myBatis
	 */
	@Test
	public void customBatis() {
		MapperFactoryBean MapperFactoryBean = new MapperFactoryBean();
		TMapper mapper = (TMapper) MySqlSession.getMapper(TMapper.class);
		Map<String, Object> resultMap = mapper.queryFroMap(1);
		log.debug("resultMap:{}", resultMap);
	}

	/**
	 * 测试
	 * 把一个第三方的对象给spring
	 *
	 * 思考：如何把第三方的bean交给spring来管理的方式：
	 *
	 * 1.注解（@Service，@Repository，@Component等等）
	 *    这种方式不行,原因
	 * 2.xml配置<bean></bean>  不行
	 * 3.注解（@Bean） 可以
	 * 4.Factory 可以
	 * 5.springAPi可以
	 * 6.动态的向容器注册BeanDefinition 不行
	 */
	@Test
	public void customObjectBatis() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BatisConfig.class);
		TMapper tMapper = (TMapper) MySqlSession.getMapper(TMapper.class);
		context.getBeanFactory().registerSingleton("tMapper",tMapper);

		context.refresh();
		TService tService = context.getBean(TService.class);
		tService.queryFroList();


	}


	/**
	 * 1.MyFactoryBean自己必须生效，存在spring容器当中
	 * 2.mapperInterface必须有值
	 */
	@Test
	public void testFactorBeanBatis() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BatisConfig.class);
		TService tService = context.getBean(TService.class);
		tService.queryFroList();

	}

	/**
	 * 配置多少mapper的时候通过FactoryBean来配置，比较麻烦，
	 * mybatis提供了
	 * @MapperScan("org.mybatis.spring.sample.mapper")
	 * 或者xml
	 * <mybatis:scan base-package="org.mybatis.spring.sample.mapper" />
	 *
	 */
	@Test
	public void testMultiFactorBeanBatis() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BatisConfig.class);
		TService tService = context.getBean(TService.class);
		tService.queryFroList();

	}
}
