package com.javaeasy.learnchar;					// 程序在的包名

public class PrintCodeRange {
	public static void main(String[] args) {		// main()方法
		if (args.length != 2) {						// 检查长度是否为2
			System.out.println("程序需要两个参数！");
			return;
		}
		int begin = 0;								// 编码的开始和结束
		int end = 0;
		try {
			begin = Integer.valueOf(args[0]);		// 尝试将两个参数转换为int变量
			end = Integer.valueOf(args[1]);
		} catch (NumberFormatException ex) {
			System.out.println("程序需要两个整数做参数！");
													// 如有异常，程序结束
			return;
		}
		for (int i = begin; i <= end; i++) {	
			// 循环输出编码对应的字符
			char ch = (char) i;
			System.out.print(ch);
		}
	}
}
