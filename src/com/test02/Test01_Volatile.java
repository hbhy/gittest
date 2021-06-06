package com.test02;

/**
 * volatile关键字：保证可见性
 * @author zwh
 * @date 2021年4月7日
 */
public class Test01_Volatile {
	public static void main(String[] args) {
		MyData myData = new MyData();
		
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+" come in");
			//暂停一会儿线程
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			myData.addTo60();
			System.out.println(Thread.currentThread().getName()+" updated number value："+myData.num);
		}, "AAA").start();
		
		while(myData.num == 0) {
			//main线程在这里一直等待，直到number值不再为0
		}
		
		System.out.println(Thread.currentThread().getName()+" mission is over, mian get number:"+myData.num);
	}
}

class MyData {
	volatile int num = 0;
	
	public void addTo60() {
		this.num = 60;
	}
}
