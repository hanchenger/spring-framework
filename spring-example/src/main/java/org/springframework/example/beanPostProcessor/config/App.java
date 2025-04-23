package org.springframework.example.beanPostProcessor.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy()
@ComponentScan("org.springframework.example.beanPostProcessor")
public class App {
}
