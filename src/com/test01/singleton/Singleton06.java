package com.test01.singleton;

/**
 * 单例模式：懒汉式
 * @author zwh
 * @date 2021年3月31日
 */
public class Singleton06 {
	private Singleton06() {}
	
	/*
	 * 在内部类被加载和初始化时，也就是调用getInstance方法，该方法使用到Inner时，才创建INSTANCE对象
	 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独加载和初始化的
	 * 因为在内部类加载和初始化时创建的，因此线程是安全的
	 */
	private static class Inner {
		private static final Singleton06 INSTANCE = new Singleton06();
	}
	
	public static Singleton06 getInstance() {
		return Inner.INSTANCE;
	}
}
