package com.javaeasy.sync;									// 包名

public class SyncMethods {									// 提供方法的类
	public synchronized static void syncStaticMethod1() {	// 静态同步方法
		System.out.println("这是一个静态的同步方法");
	}
	public synchronized static void syncStaticMethod2() {	// 静态同步方法
		System.out.println("这是一个静态的同步方法");
	}
	public static void staticMethod() {					// 静态方法
		System.out.println("这是一个静态的方法");
	}
	public synchronized void syncMethod1() {				// 同步方法
		System.out.println("这是一个同步方法");
	}
	public synchronized void syncMethod2() {				// 同步方法
		System.out.println("这是一个同步方法");
	}
	public synchronized void method() {					// 方法
		System.out.println("这是一个普通方法");
	}
}
