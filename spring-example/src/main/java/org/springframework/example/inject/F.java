package org.springframework.example.inject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class F {

	/**
	 * autowired 先type 1  t
	 *           先type >1 再名称 =1 true >1 f
	 *           先type =0 看request如为true则报错
	 *
	 *
	 *
	 */
	//Autowired
	@Resource
	I a;

	@Resource(name = "cc")
	G g;

	@Autowired
	L l;

	K k;

	public K getK() {
		return k;
	}

	public I getI() {
		return a;
	}

	public void setA(I a) {
		log.debug("a---{}", a);
	}
}
