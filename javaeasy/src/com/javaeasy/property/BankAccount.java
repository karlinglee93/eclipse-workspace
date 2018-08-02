package com.javaeasy.property;						// 包名

public class BankAccount {							// 代表银行账户的类
	private int money = 0;							// 账户余额

	public synchronized void getMoneyOutOfBank(int cash) {		// 取钱方法
		if (cash <= 0) {							// 如果取钱的数额小于0
			System.out.println("取钱数额必须大于0");	// 则输出错误信息
			return;									// 方法结束
		}
		if (money < cash) {							// 如果取钱数额超过现金
													// 余额
			System.out.println("现金不足！");		// 输出错误提示
			return;									// 方法结束
		}
		System.out.println("正在处理，请稍后……");// 可以进行取钱，输出等待消息
		try {
			Thread.sleep(1000);		// 线程挂起，表示银行正在处理这笔取钱业务
		} catch (InterruptedException e) {
			System.out.println("对不起，程序运行出错，错误信息为：" +
			e.getMessage());
			return;
		}
		money = money - cash;		// 将账户中的钱减去相应的数额
		// 输出本次取钱金额，并输出账户余额
		System.out.println("取钱成功，请拿好现金：" + cash + "元。现在账户余额为：" + money + "元。");
	}

	public synchronized void putMoneyToBank(int cash) {		// 存钱方法
		if (cash <= 0) {				// 如果存钱数额是小于等于0的
			System.out.println("存钱数额必须大于0");		// 输出错误提示
			return;										// 方法返回
		}
		System.out.println("正在处理存钱操作，请稍后……");
										// 输出正在处理的提示
		int tempMoney = money + cash;	// 用一个临时变量保存新账户的余额
		try {
			Thread.sleep(1000);			// 线程挂起，表示银行正在处理存钱业务
		} catch (InterruptedException e) {
			System.out.println("对不起，程序运行出错，错误信息为：" +
			e.getMessage());
			return;
		}
		money = tempMoney;				// 给账户余额赋值
		// 输出本次存钱金额，并输出账户余额
		System.out.println("存钱成功，金额为：" + cash + "元。现在账户余额为：" + money + "元。");
	}

	public void peekMoney() {			// 输出账户余额的方法
		System.out.println("现在账户余额为：" + money + "元。");
										// 输出账户余额
	}

}
