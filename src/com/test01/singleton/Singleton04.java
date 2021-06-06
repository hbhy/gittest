package com.test01.singleton;

/**
 * 单例模式：懒汉式
 * @author zwh
 * @date 2021年3月31日
 */
public class Singleton04 {
	private static Singleton04 instance;
	
	private Singleton04() {}
	
	public static Singleton04 getInstance() {
		if(instance == null) {
			instance = new Singleton04();
		}
		
		return instance;
	}
}
