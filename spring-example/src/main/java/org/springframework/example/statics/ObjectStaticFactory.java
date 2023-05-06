package org.springframework.example.statics;

public class ObjectStaticFactory {

	public static Object instanceObject() {
		return new A("xx");
	}
}
