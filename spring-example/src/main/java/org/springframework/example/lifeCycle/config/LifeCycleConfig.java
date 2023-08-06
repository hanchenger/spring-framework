package org.springframework.example.lifeCycle.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.example.lifeCycle.util.EnableAspectAop;

@EnableAspectJAutoProxy
//@EnableAspectAop
@ComponentScan("org.springframework.example.lifeCycle")
public class LifeCycleConfig {
}
