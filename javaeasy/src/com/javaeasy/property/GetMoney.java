package com.javaeasy.property;					// 包名

public class GetMoney implements Runnable {	// GetMoney实现了Runnable
												// 接口
	private BankAccount account;				// 银行账户类的引用
	private int cash;							// 取钱的数额

	public GetMoney(BankAccount account, int cash) {	// 构造方法
		this.account = account;							// 想从哪个账户取钱
		this.cash = cash;								// 取多少钱
	}

	public void run() {									// 实现run()方法
		String name = Thread.currentThread().getName();// 得到当前线程的名字
		System.out.println("线程\"" + name + "\"开始取钱！");
														// 输出开始取钱信息
		account.getMoneyOutOfBank(cash);				// 调用取钱方法
		System.out.println("线程\"" + name + "\"取钱完毕！");
														// 输出取钱完毕信息
	}
}
