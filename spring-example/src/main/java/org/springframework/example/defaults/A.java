package org.springframework.example.defaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("aa")
@Slf4j(topic = "e")
public class A implements ExampleAware {

	ExampleBean exampleBean;

	public A() {
		log.debug("default Constructor");
	}

	public A(B b) {
		log.debug("default from b ");
	}

    //改变A(B b)和A(C c)方法的顺序发现spring推断构造方法采用了到了 A(C c)
	//这里是按照加载构造方法的顺序的，但是它加载完了之后，就倒过来，并且通过算法会给A(C c)和A(B b)计算一个得分，最后推断构造方法的
	public A(C c) {
		log.debug("default from c");
	}


}
