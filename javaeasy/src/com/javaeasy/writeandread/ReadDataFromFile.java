package com.javaeasy.writeandread;

import java.io.BufferedReader;					// 引入需要使用的类
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromFile {				// 例程类
	public static void main(String[] args) {	// main()方法
		File dataFile = new File("D:\\datafile.txt");
											// 需要从此文件中读取数据
		if (dataFile.exists() && dataFile.isFile()) {
			System.out.println("从datafile.txt中读取数据。");
		} else {
			System.out.println("datafile.txt文件不存在。");
											// 如果文件不存在，则程序退出
			return;
		}
		System.out.println("文件中的内容为：");
		try {
			FileReader fr = new FileReader(dataFile);
											// 创建FileReader的实例
			BufferedReader br = new BufferedReader(fr);
											// 创建BufferedReader的实例
			String content = null;			// 存放从文件中读出的内容
			while ((content = br.readLine()) != null) {
											// 从文件中读取一行内容
				System.out.println(content);// 向控制台输出读取出来的内容
			}
			fr.close();
			br.close();						// 释放资源
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！错误信息为：" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
