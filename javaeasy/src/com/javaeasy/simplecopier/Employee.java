package com.javaeasy.simplecopier;			// 包名

public class Employee extends Thread {		// 继承自Thread类的Employee类
	private int workTimes;					// 该员工一天的工作份额
	private Copier copier;					// 复印机
	
	// 构造方法，name是线程的名字，也是员工的名字，剩下两个参数直接赋值给相应的属性
	public Employee(String name, int workTimes, Copier copier) {
		super(name);						// 调用父类的构造方法
		this.workTimes = workTimes;
		this.copier = copier;
	}

	public void run() {						// 覆盖Thread类的run()方法
		System.out.println(this.getName() + "：开始工作。");
											// 开始一天的工作
		for (int i = 0; i < workTimes; i++) {	// 工作workTimes次
			// 生成一个从1～6的随机数，代表此次需要复印的张数
			int pageAmount = (int) (5 * Math.random()) + 1;	
			System.out.println("\"" + this.getName() + "\"尝试调用\"" + copier.getName() + "\"的copyPages()方法");

			copier.copyPages (pageAmount);	// 调用printPages()方法进行复印
		}
		// 完成了workTimes次循环后，员工完成了当天的工作份额，下班回家
		System.out.println(this.getName() + "：完成了工作，下班。");
	}
}
