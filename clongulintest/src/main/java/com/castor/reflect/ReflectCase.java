package com.castor.reflect;

import java.lang.reflect.Method;

public class ReflectCase {

	public static void main(String[] args) throws Exception {
		/*Proxy target = new Proxy();
		Method method = Proxy.class.getDeclaredMethod("run");
		method.invoke(target);*/

		TestJavaStack test = new TestJavaStack();
		test.testInt();

	}

	static class Proxy {
		public void run() {
			System.out.println("run");
		}
	}


}

class TestJavaStack {
	int c = 2;
	public void testInt() {
		int a = 10;

		int b = 10;
		c=a+b;
	}
}

