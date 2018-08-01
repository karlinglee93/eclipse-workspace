package com.javaeasy.threadname;				// 程序所在的包

public class ShowThreadNameMain {				// 例程
	public static void main(String[] args) {	// main()方法
		// 使用无参数的构造方法创建Thread类实例，这时它将有一个默认的名字
		ShowThreadName defaultName = new ShowThreadName();
		// 使用构造方法给线程指定一个名字
		ShowThreadName name = new ShowThreadName("线程的名字");
		// 启动两个线程
		defaultName.start();
		name.start();
	}
}
