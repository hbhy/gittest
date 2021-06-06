package com.test02;

/**
 * 单例模式
 * @author zwh
 * @date 2021年4月7日
 */
public class Test04_Singleton {
	private static volatile Test04_Singleton instance;
	
	private Test04_Singleton() {}
	
	public static Test04_Singleton getInstance() {
		if(instance == null) {
			synchronized (Test04_Singleton.class) {
				if(instance == null) {
					instance = new Test04_Singleton();
				}
			}
		}
		
		return instance;
	}
}
