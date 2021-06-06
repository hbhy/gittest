package com.test02;

/**
 * volatile：不保证原子性案例演示
 * @author zwh
 * @date 2021年4月7日
 */
public class Test02_Volatile {
	public static void main(String[] args) {
		MyData01 myData = new MyData01();
		
		for(int i=1; i<=20; i++) {
			new Thread(()->{
				for(int j=1; j<=1000; j++) {
					myData.addPlusPlus();
				}
			}, String.valueOf(i)).start();
		}
		
		//等待20个线程执行完，才能往下操作
		while (Thread.activeCount() > 2) { //jvm默认有2个线程：main线程和GC线程
			//20个线程没执行，mian线程放弃执行权
			Thread.yield();
		}
		
		System.out.println(Thread.currentThread().getName()+" finally number value："+myData.num);
	}
}

class MyData01 {
	volatile int num = 0;
	
	public void addPlusPlus() {
		num++;
	}
	
}
