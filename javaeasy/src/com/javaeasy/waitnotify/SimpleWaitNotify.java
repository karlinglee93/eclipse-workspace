package com.javaeasy.waitnotify;

public class SimpleWaitNotify {				// 例程类

	public static void main(String[] args) {	// main()方法
		Object obj = new Object();				// 创建用于执行wait()和
												// notify()方法的类Object的
												// 对象
		Waiting waiting = new Waiting(obj);	// 以obj为参数，创建Waiting
												// 类的实例
		Notifier notifier = new Notifier(obj);	// 以obj为参数，创建Notifier
												// 类的实例
		Thread waitingThread = new Thread(waiting, "挂起线程");
												// 创建"等待线程"
		Thread notifierThread = new Thread(notifier, "唤醒线程");
												// 创建"唤醒线程"
		waitingThread.start();					// 启动两个线程
		notifierThread.start();
	}

}
