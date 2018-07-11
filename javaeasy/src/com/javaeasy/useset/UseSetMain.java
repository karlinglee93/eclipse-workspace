package com.javaeasy.useset;				// 程序在的包

import java.util.HashSet;					// 引入需要使用的类
import java.util.Set;

public class UseSetMain {					// 例程类

	public static void printSet(Set set) {	// 遍历集合，并向控制台输出其中元素
		Object[] elements = set.toArray();	// 将集合中元素保存到一个数组中
		int size = elements.length;
		System.out.println("集合大小为：" + size + "。其中的元素为：");
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] + ",");
		}
		System.out.println("\n=====集合内容结束=====\n");
	}

	public static void main(String args[]) {	// main()方法
		String str1 = "aaa";					// 3个字符串
		String str2 = "bbb";
		String str3 = "aaa";
		Set set = new HashSet();				// 创建一个HashSet的实例
		set.add(str1);							// 向集合中添加两个元素
		set.add(str2);
		printSet(set);							// 输出集合中的元素
		boolean addResult = set.add(str3);		// 增加第3个元素
		System.out.println("向集合中添加str3结果如下。" + addResult);		// 增加是否成功
		printSet(set);							// 再次输出集合中的元素
	}
}
