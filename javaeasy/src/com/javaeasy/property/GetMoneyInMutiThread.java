package com.javaeasy.property;

public class GetMoneyInMutiThread {				// 例程
	public static void main(String[] args) {		// main()方法
		BankAccount account = new BankAccount();	// 创建银行账户类
		account.putMoneyToBank(100);				// 存入100元
		// 创建3个GetMoney的实例， 注意，它们都是使用account为参数的，也就是说
		// 它们会从同一个银行账户取钱
		GetMoney money1 = new GetMoney(account, 100);
		GetMoney money2 = new GetMoney(account, 100);
		GetMoney money3 = new GetMoney(account, 100);
		// 使用前面创建的GetMoney实例，分别创建3个Thread类实例
		Thread moneyThread1 = new Thread(money1, "取钱线程1");		
		Thread moneyThread2 = new Thread(money2, "取钱线程2");
		Thread moneyThread3 = new Thread(money3, "取钱线程3");
		// 启动这三个线程。
		moneyThread1.start();
		moneyThread2.start();
		moneyThread3.start();
	}
}