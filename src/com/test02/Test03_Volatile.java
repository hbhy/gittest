package com.test02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile不保证原子性解决方案：
 * 		1、synchronized
 * 		2、Auto
 * @author zwh
 * @date 2021年4月7日
 */
public class Test03_Volatile {
	public static void main(String[] args) {
		MyData03 myData = new MyData03();
		
		for(int i=1; i<=20; i++) {
			new Thread(()->{
				for(int j=1; j<=1000; j++) {
					myData.addPlusPlus();
					myData.addAtomicInteger();
				}
			}, String.valueOf(i)).start();
		}
		
		//等待20个线程执行完，才能往下操作
		while (Thread.activeCount() > 2) { //jvm默认有2个线程：main线程和GC线程
			//20个线程没执行，mian线程放弃执行权
			Thread.yield();
		}
		
		System.out.println(Thread.currentThread().getName()+" int type, finally number value："+myData.num);
		System.out.println(Thread.currentThread().getName()+" AtomicInteger type, finally number value："+myData.atomicInteger);
	}
}

class MyData03 {
	volatile int num = 0;
	
	public void addPlusPlus() {
		num++;
	}
	
	AtomicInteger atomicInteger = new AtomicInteger();
	
	public void addAtomicInteger() {
		atomicInteger.getAndIncrement();
	}
}
