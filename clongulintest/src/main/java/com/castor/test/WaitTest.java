package com.castor.test;

class ThreadA extends Thread{
	ThreadA(String name) {
		super(name);
	}
	@Override
	public synchronized void run() {
		synchronized(ThreadA.class) {
			for (int i = 0; i < 10; i++) {
				System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
				if(i % 4 ==0){
					Thread.yield();
				}
			}
		}
	}
}

public class WaitTest{
	public static void main(String[] args) {
		ThreadA t1 = new ThreadA("t1");
		ThreadA t2 = new ThreadA("t2");
		t1.start();
		t2.start();
	}
}
