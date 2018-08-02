package com.javaeasy.waitnotify;

public class QuickNotifier implements Runnable {

	private Object notifyObj; 			// 将在此对象上调用notify()方法

	public QuickNotifier(Object notifyObj) {// 构造方法，传入一个对象的引用
		this.notifyObj = notifyObj;
	}

	public void run() { 					// 覆盖抽象方法run()
		String name = Thread.currentThread().getName();
		System.out.println(name + "：开始notify线程");
		synchronized (notifyObj) {		// 获得notifyObj的对象锁
			notifyObj.notify(); 		// 调用notify()方法，唤醒因为调用
										// wait()而挂起的线程
		}
		// 唤醒结束后，向控制台输出下一行文字
		System.out.println(name + "：notify线程结束");
	}

}