package com.javaeasy.currentthread;			// 程序包

public class CurrentThreadMain {				// 例程类
	public static void main(String[] args) {	// main()方法
		// 创建一个PrintCurrentThreadName类的实例
		PrintCurrentThreadName printer = new PrintCurrentThreadName();
		// 调用PrintCurrentThreadName()方法，用来输出执行此方法的线程的名字
		printer.printCurrentThreadName();
	}
}
