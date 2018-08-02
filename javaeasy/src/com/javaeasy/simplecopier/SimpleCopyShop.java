package com.javaeasy.simplecopier;				// 程序所在的包

public class SimpleCopyShop{					// 例程
	public static void main(String[] args) {	// main()方法
		Copier canon = new Copier("佳能");		// 创建一台佳能复印机
		Copier sharp = new Copier("夏普");		// 创建一台夏普复印机
		// 创建一个叫做Simth的员工线程，每天工作2次，并让他使用佳能复印机
		Employee simth = new Employee("Simth", 2, canon);
		// 创建一个叫做John的员工线程，每天工作3次并让他使用夏普复印机
		Employee john = new Employee("John", 3, sharp);
		simth.start();							// 启动两个线程
		john.start();
	}
}
