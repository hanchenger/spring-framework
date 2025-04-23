package org.springframework.example.introspect.bean;



public class IntrospectDemoBean {

	private String name;
	private int age;

	//no setter getter
	//根据java内省，没有getter或者setter方法，这个属性是无法被识别为属性描述符的
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getpassword() {
		return "";
	}

	public void setpassword(String assword) {

	}
}
