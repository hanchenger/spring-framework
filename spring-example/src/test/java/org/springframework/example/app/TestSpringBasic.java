package org.springframework.example.app;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.example.app.bean.ibdr.util.Z;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j(topic = "e")
public class TestSpringBasic {

	/**
	 *
	 */
	@Test
	public void defaultScanTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		String javaHome = context.getEnvironment().getProperty("k1");
		System.out.println(javaHome);
	}


	/**
	 * 利用java的Properties对象加载配置文件,
	 * 并加入到Spring的Enviroment对象的propertySources的集合中
	 * @throws IOException
	 */
	@Test
	public void testPropertiesSource() throws IOException {
		// 创建 Properties 对象
		Properties properties = new Properties();

		// 加载 application.properties 文件
		try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
			// 从输入流中加载配置
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		context.getEnvironment().getPropertySources().addLast(new PropertiesPropertySource("customer",properties));
		System.out.println(context.getEnvironment().getProperty("k2"));
	}


	/**
	 * 利用ResourcePropertySource对象加载配置文件,
	 * 并加入到Spring的Enviroment对象的propertySources的集合中
	 * @throws IOException
	 */
	@Test
	public void testResourcePropertiesSource() throws IOException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		ResourcePropertySource resourcePropertySource = new ResourcePropertySource("classpath:application.properties");
		context.getEnvironment().getPropertySources().addLast(resourcePropertySource);
		System.out.println(context.getEnvironment().getProperty("k2"));
	}


	@Test
	public void testParse() throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class);
		//context.addBeanFactoryPostProcessor(new Z());
		context.refresh();
	}

}
