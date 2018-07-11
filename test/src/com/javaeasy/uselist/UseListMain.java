package com.javaeasy.uselist;						// 例程所在的包

import java.util.ArrayList;							// 引入需要使用的类
import java.util.List;

public class UseListMain {							// 例程类
	// 静态方法，用于遍历一个List类型的实例，并输出其中的内容
	public static void printList(List list) {
		int size = list.size();						// 得到元素个数
		System.out.println("列表大小为：" + size + "。其中的元素为：");
															// 输出列表大小
		for (int i = 0; i < size; i++) {
			// 依次输出元素内容，但是输出后不换行
			System.out.print(list.get(i) + ",");
		}
		System.out.println("\n=====列表内容结束=====\n");	// 输出结束信息
	}

	public static void main(String[] args) {			// main()方法
		List list;							// 创建一个List引用
		list = new ArrayList();				// 让它指向一个ArrayList的实例
		// str1 - str3 是String 类引用
		// "字符串1 - 3" 是String 类的对象
		String str1 = "字符串1";				// （1）创建3个字符串实例
		String str2 = "字符串2";
		String str3 = "字符串3";
		// ArrayList 对象中都是Object 引用
		list.add(str1);						// （2）将第1个和第3个字符串的引
											// 用放入列表中
		list.add(str3);
		printList(list);					// 输出此时列表中的内容
		list.add(1, str2);					// （3）将第2个数组插入到列表中第
											// 2个元素的位置
		printList(list);					// 输出此时列表中的内容
		list.set(1, str3);					// （4）将第2个元素设置为第3个字
											// 符串的引用
		printList(list);					// 输出此时列表中的内容
		list.remove(0);						// （5）删除第1个元素
		printList(list);					// 输出此时列表中的内容
	}
}
