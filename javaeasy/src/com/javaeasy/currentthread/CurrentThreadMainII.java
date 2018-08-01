package com.javaeasy.currentthread;			// 包名

public class CurrentThreadMainII {				// 例程名
	public static void main(String[] args) {	// main()方法
		Runnable runnable = new Runnable() {
									// 通过匿名内部类创建一个Runnable的实例
			public void run() {		// 实现抽象方法run()
				// 创建一个PrintCurrentThreadName类的实例
				PrintCurrentThreadName printer = new PrintCurrentThreadName();
				// 调用printCurrentThreadName()方法，用来输出执行此方法的线程的
				// 名字
				printer.printCurrentThreadName();
			}
		};
		// 使用runnable创建一个线程，线程名字叫做“线程-1”
		Thread thread = new Thread(runnable, "线程-1");	
		thread.start();							// 启动线程
	}
}
