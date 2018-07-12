package com.javaeasy.learnchar;					// 程序在的包

public class PrintCharCoder {						// 程序名
	public static void main(String[] args) {		// main()方法
		if (args.length != 1) {						// 检查参数长度
			System.out.println("程序没有参数！");		// 如果没有参数，则退出
			return;
		}
		if (args[0].length() == 0) {		// 如果参数的字符串长度为0，则退出
			System.out.println("字符串为空！");
			return;
		}
		// 获取第一个参数的第一个字符
		char ch = args[0].charAt(0);
		// 转换为int，也就是其编码
		int value = ch;						
		System.out.println("字符\'" + ch + "\'对应的编码是：" + value);		// 输出其编码
	}
}
