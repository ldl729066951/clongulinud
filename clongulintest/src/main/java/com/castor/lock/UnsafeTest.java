package com.castor.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Unsafe类让我们明白了java是如何实现对操作系统操作的，
 * 一般我们使用java是不需要在内存中处理java对象及内存地址位置的，但有的时候我们确实需要知道java对象相关的地址，于是我们使用Unsafe类，尽管java对其提供了足够的安全管理
 */
public class UnsafeTest {

	private int flag = 100;
	private static long offset;
	private static Unsafe unsafe = null;

	static{
		try{
			unsafe= getUnsafeInstance();
			offset= unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("flag"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		int expect = 100;
		int update = 101;

		UnsafeTest unsafeTest = new UnsafeTest();
		System.out.println("unsafeTest对象的flag字段的地址偏移量为："+offset);
		unsafeTest.doSwap(offset,expect, update);
		System.out.println("CAS操作后的flag值为：" +unsafeTest.getFlag());

	}

	private boolean doSwap(long offset, int expect, int update) {
		return unsafe.compareAndSwapInt(this, offset, expect, update);
	}

	public int getFlag() {
		return flag;
	}

	private static Unsafe getUnsafeInstance() throws SecurityException,NoSuchFieldException,IllegalArgumentException,IllegalAccessException{
		Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafeInstance.setAccessible(true);
		return(Unsafe) theUnsafeInstance.get(Unsafe.class);
	}

}
