package com.test01;

import org.junit.Test;

/**
 * 需求：
 * 	编程题：有n步台阶，一次只能上1步或2步，共有多少种走法
 * 
 * 	循环实现
 * 
 * @author zwh
 * @date 2021年4月6日
 */
public class Test02_Step {
	@Test
	public void test_step() throws IllegalAccessException {
		System.out.println(loop(4));
	}
	
	public int loop(int n) throws IllegalAccessException {
		if(n < 1) {
			throw new IllegalAccessException(n+"不能小于1");
		}
		
		if(n==1 || n==2) {
			return n;
		}
		
		int f1 = 1;
		int f2 = 2;
		int fn = 0;
		
		for(int i=3; i<=n; i++) {
			fn = f1+f2;
			f1 = f2;
			f2 = fn;
		}
		
		return fn;
	}
}
