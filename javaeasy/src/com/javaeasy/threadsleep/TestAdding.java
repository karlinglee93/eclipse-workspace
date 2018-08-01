package com.javaeasy.threadsleep;				// 程序所在的包

public class TestAdding{						// 没有继承自Thread类
	public void giveAddingTest () {			// 加法测验方法
		int a = (int) (100 * Math.random());	// 生成一个0～100的随机数
		int b = (int) (100 * Math.random());	// 生成另一个0～100的随机数
		System.out.println("请在5秒钟内计算出下面两个整数的和：" + a + "+" + b);
												// 输出两个随机数
		// 通过Thread.currentThread()得到当前线程，进而得到其名字
		String currThreadName = Thread.currentThread().getName();
		// 向控制台输出当前线程的名字
		System.out.println("执行当前代码的线程名叫做：" + currThreadName);
		try {
			Thread.sleep(5000);					// 让当前线程挂起5秒钟
		} catch (InterruptedException e) {		// sleep()方法可能抛出Inte-
												// rruptedException异常
			// 输出异常信息
			System.out.println("对不起，程序运行出错，错误信息为：" + e.getMessage());
			return;								// 程序出错，不再向下执行
		}
		int result = a+b;
		System.out.println(a + "+" + b + "的运算结果是" + result);
												// 输出运算结果
	}
}
