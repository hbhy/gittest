package com.test01.singleton;

/**
 * 单例模式：饿汉式
 * @author zwh
 * @date 2021年3月31日
 */
public class Singleton01 {
	public static final Singleton01 INSTANCE= new Singleton01();
	
	private Singleton01() {}
}
