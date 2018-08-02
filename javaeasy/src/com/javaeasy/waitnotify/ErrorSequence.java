package com.javaeasy.waitnotify;

public class ErrorSequence{						// 例程类

	public static void main(String[] args) {	// main()方法
		Object obj = new Object();			// 创建用于执行wait()和notify()
											// 方法的类Object的对象
		Waiting waiting = new Waiting(obj);// 以obj为参数，创建Waiting
											// 类的实例
		QuickNotifier notifier = new QuickNotifier (obj);
								// 以obj为参数，创建QuickNotifier类的实例
		Thread waitingThread = new Thread(waiting, "挂起线程");
										// 创建“挂起线程”
		Thread notifierThread = new Thread(notifier, "唤醒线程");
										// 创建“唤醒线程”
		notifierThread.start();			// 首先启动唤醒线程
		waitingThread.start();			// 然后启动挂起线程
	}
}
