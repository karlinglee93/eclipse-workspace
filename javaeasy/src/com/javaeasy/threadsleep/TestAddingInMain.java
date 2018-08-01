package com.javaeasy.threadsleep;

public class TestAddingInMain {
	public static void main(String[] args) {
		int a = (int) (100 * Math.random());	// 生成一个0～100的随机数
		int b = (int) (100 * Math.random());	// 生成另一个0～100的随机数
		System.out.println("请在5秒钟内计算出下面两个整数的和：" + a + "+" + b);
												// 输出两个随机数
		try {
			Thread.sleep(5000);					// （1）让线程挂起5秒钟
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
