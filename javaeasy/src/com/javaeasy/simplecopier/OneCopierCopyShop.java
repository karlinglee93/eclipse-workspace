package com.javaeasy.simplecopier;

public class OneCopierCopyShop {
	public static void main(String[] args) {
		Copier canon = new Copier("佳能");		// 创建一台佳能复印机
		// 创建一个叫做Simth的员工线程，每天工作1次，并让他使用佳能复印机
		Employee simth = new Employee("Simth", 1, canon);
		// 创建一个叫做John的员工线程，每天工作2次，也让他使用佳能复印机
		Employee john = new Employee("John", 2, canon);
		simth.start();							// 启动两个线程
		john.start();
	}
}
