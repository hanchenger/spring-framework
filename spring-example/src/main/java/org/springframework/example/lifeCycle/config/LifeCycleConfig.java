package org.springframework.example.lifeCycle.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan("org.springframework.example.lifeCycle")
public class LifeCycleConfig {
}
