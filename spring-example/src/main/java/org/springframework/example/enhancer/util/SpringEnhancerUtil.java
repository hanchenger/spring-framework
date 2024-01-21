package org.springframework.example.enhancer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.*;
import org.springframework.example.enhancer.bean.A;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

@Slf4j(topic = "e")
public class SpringEnhancerUtil {

	/**
	 * 创建一个继承了A的代理对象
	 * cglib
	 * @param clazz
	 * @return
	 */
	public Object createProxyClazz(Class clazz){
		try {
			saveGeneratedCGlibProxyFiles("d:\\cglib\\");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setUseFactory(false);
		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		//enhancer.setStrategy(new ConfigurationClassEnhancer.BeanFactoryAwareGeneratorStrategy(this.getClass().getClassLoader()));
		enhancer.setCallback(new MyCallBack());
		//区别  setCallback会默认为所有方法增强
		//setCallbackFilter 会过滤一些方法，只有符合过滤条件的才会增强
		//setCallbackFilter spring当中主要过滤@Bean方法和setBeanFactory的方法
//		enhancer.setCallbackFilter(new CallbackFilter() {
//			//不是过滤某个类 过滤某个方法
//			@Override
//			public int accept(Method method) {
//				if (method.getName().equals("m0")){
//					return 0;
//				}if(method.getName().equals("m1")){
//					return 1;
//				}else {
//					return 0;
//				}
//			}
//		});
		//enhancer.setCallbackTypes(CALLBACK_FILTER.getCallbackTypes());
		Object o = enhancer.create();
		return o;
	}

	public static void main(String[] args) {
		SpringEnhancerUtil springEnhancerUtil = new SpringEnhancerUtil();
		A a = (A) springEnhancerUtil.createProxyClazz(A.class);
		a.m0();
		a.m1();


	}

	public static void saveGeneratedCGlibProxyFiles(String dir) throws Exception {
		Field field = System.class.getDeclaredField("props");
		field.setAccessible(true);
		Properties props = (Properties) field.get(null);
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);//dir为保存文件路径
		props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
	}
}
