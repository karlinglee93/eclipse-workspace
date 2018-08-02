package com.javaeasy.multithreads;					// 程序所在的包

public class PrintNumberThread extends Thread {	// 继承自Thread类
	private int times;						// times属性，用来控制输出内容的
											// 次数

	public PrintNumberThread(int times) {	// 构造方法，以一个int变量为参数
		this.times = times;					// 给times属性赋值
	}
	public void run() {						// 覆盖Thread类的run()方法
		for (int i = 0; i < times; i++) {	// for循环，循环次数为times次
			// 生成需要输出的内容。其中this.getName()是得到线程的名字
			String content = this.getName()+ "\t:\t" + i;	
			try {
				this.sleep(1);				// 让程序沉睡1毫秒
			} catch (InterruptedException e) {
				System.out.println("对不起，程序运行出错，错误信息为：" +
				e.getMessage());
			}
			System.out.println(content);	// 向控制台输出内容
		}
		// 在run()方法的最后一行，输出线程结束的信息
		System.out.println("线程\"" + this.getName() + "\"程结束了。");
	}
}
