/**
 * 18.1.2 创建和删除文件
 * 创建文件夹和文件的标准流程：
 * 创建文件夹时，需要首先判断这个文件夹是否存在，如果不存在则创建，否则就使用已经存在的文件夹；
 * 在创建文件时，也需要判断文件是否存在，如果存在，则根据具体情况处理；如果不存在，就创建这个文件。
 */
package com.javaeasy.fileoperation;				// 例程所在的包

import java.io.File;								// 引入使用的类
import java.io.IOException;

public class CreateFileAndFolder {					// 例程类

	public static void main(String[] args) {		// main()方法
		String folderPath = "/Users/karlinglee/Documents/eclipse-workspace/javaeasy/src/com/javaeasy/fileoperation/testingfolder";
		String fileName = "testingfile.txt";		// 文件名
		
		// 创建一个File对象，对应文件夹
		File folder = new File(folderPath);
		if (folder.exists() && folder.isDirectory()) {	
											// 如果文件已经存在，且正是文件夹
			System.out.println("该文件夹已经存在了。");// 输出信息
		} else {
			boolean creatFolders = folder.mkdirs();
											// 文件夹不存在，创建需要的文件夹
			if (creatFolders) {				// 根据创建文件夹结果输出相应信息
				System.out.println("文件夹创建成功。");
			} else {
				System.out.println("文件夹创建失败。");
				return;						// 如果创建失败，则程序结束
			}
		}
		
		// 创建一个File对象，对应文件
		File file = new File(folder, fileName);
		if (file.exists() && file.isFile()) {	// 如果文件存在
			System.out.println("文件已经存在，将文件删除！");	// 将文件删除
			boolean deleteFile = file.delete();
			if (deleteFile) {					// 根据删除结果输出相应信息
				System.out.println("文件删除成功！");
			} else {
				System.out.println("文件删除失败！");
				return;							// 如果删除失败，则程序退出
			}
		}
		try {									// 创建文件
			file.createNewFile();
			System.out.println("文件创建成功。");
		} catch (IOException e) {				// 捕捉异常，输出错误信息
			System.out.println("文件创建失败。错误信息。" + e.toString());
			return;
		}
	}
}
