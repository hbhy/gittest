package com.test01;

import org.junit.Test;

/**
 * 需求：
 * 	编程题：有n步台阶，一次只能上1步或2步，共有多少种走法
 * 
 * 	递归实现
 * 
 * @author zwh
 * @date 2021年4月6日
 */
public class Test01_Step {
	@Test
	public void test_step() {
		System.out.println(step(4));
	}
	
	public int step(int n) {
		if(n < 1) {
			throw new IllegalArgumentException(n+"不能小于1");
		} 
		
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		return step(n-2)+step(n-1);
	}
}
