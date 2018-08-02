package com.javaeasy.multithreads;

public class RunMultiPrintNumThread {				// 例程
	public static void main(String[] args) {		// main()方法
		// 分别创建两个PrintNumberThread的实例。
		PrintNumberThread threadOne = new PrintNumberThread(3);
		PrintNumberThread threadTwo = new PrintNumberThread(5);
		// 给两个PrintNumberThread的实例设置不同的名字
		threadOne.setName("线程1");
		threadTwo.setName("线程2");
		// 分别启动两个线程
		threadOne.start();
		threadTwo.start();
		System.out.println("主线程结束了。");			// main()方法最后一行，输
													// 出线程结束的语句
	}
}
