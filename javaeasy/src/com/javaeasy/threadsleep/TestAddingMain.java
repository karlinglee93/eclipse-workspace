package com.javaeasy.threadsleep;				// 程序所在的包

public class TestAddingMain {					// 例程名
	public static void main(String[] args) {	// main()方法
		Runnable runnable = new Runnable() {	// 通过匿名类创建Runnable的
												// 实例
			public void run() {					// 实现抽象方法run()
				TestAdding adding = new TestAdding();
												// 创建TestAdding的实例
				adding.giveAddingTest();		// 调用giveAddingTest()
												// 方法
			}
		};
		// 使用runnable创建一个线程实例，名字是"加法测试线程"
		Thread thread = new Thread(runnable, "加法测试线程");
		thread.start();
		System.out.println("主线程结束了");
	}
}
