package com.javaeasy.threadname;				// 程序所在的包

public class ShowThreadName extends Thread {	// 继承自Thread类
	public ShowThreadName() {					// 构造方法，没有参数
		super();								// 调用父类相应的构造方法
	}
	public ShowThreadName(String name) {		// 构造方法，提供线程的名字
		super(name);							// 调用父类相应的构造方法
	}

	public void run() {							// 覆盖run()方法
		System.out.println("这个线程的名字是：" + this.getName());
												// 输出线程的名字
	}
}
