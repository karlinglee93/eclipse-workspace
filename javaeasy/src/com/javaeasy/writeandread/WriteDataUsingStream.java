package com.javaeasy.writeandread;

import java.io.File;							// 引入需要的类
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataUsingStream{				// 例程类
	public static void main(String[] args) {	// main()方法
		File dataFile = new File("D:\\DataFileForOutputStream.txt");
												// 准备数据文件
		if (dataFile.exists() && dataFile.isFile()) {
			System.out.println("使用已经存在的DataFileForOutputStream.txt文件");
		} else {
			try {
				dataFile.createNewFile();
				System.out.println("创建DataFileForOutputStream.txt文件。");
			} catch (IOException e) {
				System.out.println("创建DataFileForOutputStream.txt文件失败，错误信息。" + e.getMessage());
				return;							// 创建文件出错，程序结束
			}
		}
		try {
			String content = "通过输出流向文件写入数据。";	// 将要写入的数据
			FileOutputStream fos = new FileOutputStream(dataFile);	
														// 输出流
			byte[] contentBytes = content.getBytes();	
													// 将数据转换为byte数组
			fos.write(contentBytes);				// 写入数据
			fos.close();							// 关闭输出流
			System.out.println("数据写入成功。");
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！错误信息为：" + e.getMessage());
		} catch (IOException e) {
			System.out.println("输出内容出错，错误信息为：" + e.getMessage());
		}
	}
}
