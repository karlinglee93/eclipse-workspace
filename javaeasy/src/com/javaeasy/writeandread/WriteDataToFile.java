package com.javaeasy.writeandread;

import java.io.File;							// 引入需要使用的类
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteDataToFile {					// 例程类
	public static void main(String[] args) {	// main()方法
		File dataFile = new File("D:\\datafile.txt");
												// 例程将向这个文件写入数据
		if (dataFile.exists() && dataFile.isFile()) {
											// 如果这个文件已经存在，就直接使用
			System.out.println("使用已经存在的datafile.txt文件");
		} else {							// 如果不存在，就创建这个文件
			try {
				dataFile.createNewFile();
				System.out.println("创建datafile.txt文件。");
			} catch (IOException e) {		// 创建文件出现异常
				System.out.println("创建datafile.txt文件失败，错误信息。" + e.
				getMessage());
				return;
			}
		}
		// 下面开始向文件中写入数据
		try {
			// 创建一个PrintWriter类的实例，其构造方法是一个File对象
			PrintWriter pw = new PrintWriter(dataFile);
			// 调用write()方法写入数据
			pw.write("向文件中写入数据。");
			// 调用close()释放资源
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！错误信息为：" + e.getMessage());
		}
	}
}
