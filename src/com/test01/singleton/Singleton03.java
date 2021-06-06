package com.test01.singleton;

/**
 * 单例模式：饿汉式
 * @author zwh
 * @date 2021年3月31日
 */
public class Singleton03 {
	public static final Singleton03 INSTANCE;
	
	static {
		/*
		 * 使用静态代码块饿汉式场景：
		 * 		初始化数据（如从配置文件中读取数据并初始化）
		 */
		INSTANCE = new Singleton03();
	}
	
	private Singleton03() {}
}
