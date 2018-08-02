package com.javaeasy.simplecopier;			// 程序在的包

public class Copier {						// 复印机类
	private String name;					// 复印机的名字

	public Copier(String name) {			// 构造方法，参数为复印机的名字
		this.name = name;
	}
	public String getName() {				// 得到复印机的名字
		return name;
	}
	// 线程同步
	public synchronized void copyPages (int pages) {	// 复印
		Thread employee = Thread.currentThread();
											// 得到当前的“员工”线程
		// 向控制台输出哪个员工正在使用哪个复印机
		System.out.println(employee.getName() + "\t正在使用复印机\t" +
		name);
		long time = pages * 1000;			// 假设复印一张纸需要1秒钟
		try {
			Thread.sleep(time);				// 以挂起线程代表工人正在忙着复印
		} catch (InterruptedException e) {
			System.out.println("对不起，程序运行出错，错误信息为：" +
			e.getMessage());
		}
		// 向控制台输出哪个员工使用完了哪个复印机
		System.out.println(employee.getName() + "\t用完了打印机\t" + name);
	}
}
