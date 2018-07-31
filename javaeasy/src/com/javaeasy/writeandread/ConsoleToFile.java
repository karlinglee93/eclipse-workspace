package com.javaeasy.writeandread;

import java.io.BufferedReader;						// 引入需要使用的类
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ConsoleToFile {
	public static void main(String[] args) {		// main()方法
		// 以System.in为参数，创建一个对象
		InputStreamReader isr = new InputStreamReader(System.in);
		// InputStreamReader对象为参数，创建一个BufferedReader对象
		BufferedReader br = new BufferedReader(isr);
		File datafile = prepareFile("D:\\consoleFile.txt");
													// 创建数据文件
		PrintWriter pw = null;
		if (datafile == null) {
			System.out.println("创建数据文件出错，程序退出。");
			return;
		}
		try {
			pw = new PrintWriter(datafile);	// 创建PrintWriter类的实例
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;								// 如果创建失败，则程序退出
		}
		String content = null;
		String endMark = "end";					// 作为输入结束的标志
		try {
			System.out.println("请输出要写入文件的内容，以end结束：");
			while ((content = br.readLine()) != null) {
												// 从控制台读取一行内容
				if (content.equalsIgnoreCase(endMark)) {
											// 如果内容是end，就说明输入结束
					break;
				}
				pw.write(content + "\r\n");		// 将数据写入到文件中
			}
			pw.close();							// 释放资源
			br.close();
			System.out.println("输入结束。");
		} catch (IOException e) {
			e.printStackTrace();
		}
		printFileContent(datafile);				// 输出文件内容
	}

	private static File prepareFile(String filePath) {		// 文件路径
		File dataFile = new File(filePath);				// 创建文件对象
		if (dataFile.exists() && dataFile.isFile()) {		// 文件已经存在
			System.out.println("使用已经存在的" + filePath + "文件");
		} else {						// 文件不存在，创建这个文件
			try {
				dataFile.createNewFile();
				System.out.println("创建" + filePath + "文件。");
			} catch (IOException e) {
				System.out.println("创建d" + filePath + "文件失败，错误信息。"
						+ e.getMessage());
				return null;			// 如果发生异常，则返回null
			}
		}
		return dataFile;				// 如果一切正常，返回文件对象
	}

	private static void printFileContent(File file) {	
		// 参数是一个文件对象
		System.out.println("文件中的内容为：");
		try {
			FileReader fr = new FileReader(file);	
					// 创建BufferedReader对象，读取文件内容
			BufferedReader br = new BufferedReader(fr);	// 
			String content = null;
			while ((content = br.readLine()) != null) {
				System.out.println(content);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件！错误信息为：" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
