package org.springframework.example.batis.util;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * 1.不要使用spring的那套过滤器
 * 2.注册一个过滤器Include -- match方法永远返回true
 * 3.重写的isCandidateComponent（AnnotatedBeanDefinition）
 *
 *
 */
public class MyMapperScanner extends ClassPathBeanDefinitionScanner {
	public MyMapperScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
		super(registry, useDefaultFilters);
	}


	public void registerFilters() {
		addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		return super.doScan(basePackages);
	}

	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface();
	}
}
