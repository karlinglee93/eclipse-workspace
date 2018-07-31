package com.javaeasy.writeandread;

import java.io.File;										// 引入需要使用的类
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;

public class ReadDataFromFileUsingStream {
	public static void main(String[] args) {
		File dataFile = new File("D:\\DataFileForOutputStream.txt");// 准备数据文件
		if (dataFile.exists() && dataFile.isFile()) {
			System.out.println("从DataFileForOutputStream.txt中读取数据。");
		} else {
			System.out.println("DataFileForOutputStream.txt文件不存在。");
			return;								// 文件不存在则退出
		}
		System.out.println("文件中的内容为：");
		try {
			FileInputStream fis = new FileInputStream(dataFile);// 创建输入流
			byte[] data = new byte[1024];		// 存放文件数据的byte数组
			int len = fis.read(data);			// 读取数据，放入byte数组
			String content = new String(data, 0, len);	
												// 将byte数组转成字符串
			System.out.println(content);		// 输出字符串
			fis.close();						// 关闭输入流
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！错误信息为：" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
