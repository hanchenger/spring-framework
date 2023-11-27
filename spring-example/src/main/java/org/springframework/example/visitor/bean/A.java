package org.springframework.example.visitor.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.example.visitor.util.VisitorAnno;
import org.springframework.stereotype.Component;

@Slf4j(topic = "e")
@Component
@VisitorAnno
public class A implements C{

}
