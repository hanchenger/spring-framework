package org.springframework.example.context.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.example.context.bfpp.TestImportBeanDefinitionRegistrar;
import org.springframework.stereotype.Component;

@ComponentScan("org.springframework.example.context.bfpp")
@Import(TestImportBeanDefinitionRegistrar.class)
public class ContextConfig {


}
