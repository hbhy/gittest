package com.test01.singleton;

/**
 * 单例模式：懒汉式
 * @author zwh
 * @date 2021年3月31日
 */
public class Singleton05 {
	private static Singleton05 instance;
	
	private Singleton05() {}
	
	public static Singleton05 getInstance() {
		if(instance == null) {
			synchronized(Singleton05.class) {
				if(instance == null) {
					instance = new Singleton05();
				}
			}
		}
		
		return instance;
	}
}
