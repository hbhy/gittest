package com.test02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS：比较交换
 * @author zwh
 * @date 2021年4月8日
 */
public class Test05_CAS {
	public static void main(String[] args) {
		//物理内存值是5
		AtomicInteger atomicInteger = new AtomicInteger(5);
		
		//线程期望值是5，和物理内存值一样，就修改为2021
		System.out.println(atomicInteger.compareAndSet(5,  2021)+" current data:"+atomicInteger.get());
		//物理内存值已被修改为2021，线程期望值仍然是5，和物理内存之不一样，不修改
		System.out.println(atomicInteger.compareAndSet(5,  2022)+" current data:"+atomicInteger.get());
	}
}
