/**
 * 18.1.3 列出文件和文件夹
 * printPath()
 */
package com.javaeasy.fileoperation;

import java.io.File;							// 引入需要使用的类
import java.util.ArrayList;
import java.util.List;

public class ListForderAndFile {				// 例程
	public static void main(String[] args) {	// main()方法
		if (args.length != 1) {					// 没有参数，程序退出
			System.out.println("程序需要一个文件夹路径作为参数！");
			return;
		}
		String folderPath = args[0];			// 第一个参数作为路径名
		File folder = new File(folderPath);	// 创建File对象，表示文件夹
		if (!folder.exists()) {					// 如果文件夹不存在，退出程序
			System.out.println(folderPath + "不是有效的路径！");
			return;
		}
		if (!folder.isDirectory()) {			// 如果不是文件夹，退出程序
			System.out.println(folderPath + "不是有效的文件夹！");
			return;
		}
		File[] allFiles = folder.listFiles();// 得到文件夹中所有的文件和文件夹
		List files = new ArrayList();	// 创建两个List，分别保存文件和文件夹
		List folders = new ArrayList();
		for (int i = 0; i < allFiles.length; i++) {	// 遍历allFiles
			if (allFiles[i].isFile()) {		// 是文件，则放入files这个list
				files.add(allFiles[i]);
			} else {
				folders.add(allFiles[i]);	// 否则放入folders这个list
			}
		}
		// 分别输出文件和文件夹
		System.out.println("文件夹\"" + folderPath + "\"中包含如下文件夹：");
		printPath(folders);
		System.out.println("文件夹\"" + folderPath + "\"中包含如下文件：");
		printPath(files);
	}
	
	private static void printPath(List list) {
										// 输出list中所有文件夹或文件的名称
		for (int i = 0; i < list.size(); i++) {	// 遍历这个list
			File file = (File) list.get(i);
									// 得到当前元素，并强制类型转换为File类型
			System.out.println(file.getName());
									// 输出文件夹或者文件的名字
		}
	}
}
