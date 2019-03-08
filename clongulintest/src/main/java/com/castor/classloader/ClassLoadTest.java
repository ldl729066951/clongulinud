package com.castor.classloader;

public class ClassLoadTest {

	static String classPath = "com.castor.classloader.Tester";

	public static void main(String[] args) throws ClassNotFoundException, Exception, IllegalAccessException {
		/* 初始化的时机 */

		//<1> ClassLoader.loadclass(classpath) 是不包含 连接的  < 加载、连接、初始化 >
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class<?> a = cl.loadClass(classPath); // 用到了 Tester类 加载一个类，并不会导致一个类的 初始化
		// 调用newInstance()方法
		a.newInstance(); // 输出：____________静态块加载



		//<2> 使用Class.forName方法 , 包含了 初始化
		Class.forName(classPath); // 输出：____________静态块加载


		// 调用类变量
		int value = Tester.value;
		Tester.name = "jason"; // 输出：____________静态块加载
		// 调用类方法
		Tester.method(); // 输出：____________静态块加载   一个类方法
		// new 实例化
		Tester t = new Tester(); // 输出：____________静态块加载

	}

}

class Tester {
	public static int value = 10;
	public static String name;

	public static void method() {
		System.out.println("一个类方法");
	}

	static {
		System.out.println("Tester的类的静态初始化。。。");
	}
}