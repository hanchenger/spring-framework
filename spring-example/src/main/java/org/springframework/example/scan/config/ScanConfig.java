package org.springframework.example.scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.example.scan.bean.E;
import org.springframework.example.scan.bean.X;
import org.springframework.example.scan.util.MyBeanNameGenerator1;

@ComponentScan(value = "org.springframework.example.scan",nameGenerator = MyBeanNameGenerator1.class,
excludeFilters ={@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = X.class)},
includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = E.class)})
public class ScanConfig {
}
