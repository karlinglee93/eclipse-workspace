/**
 * 重命名文件
 * renameTo()
 */
package com.javaeasy.fileoperation;

import java.io.File;

public class RenameFile {				// 例程
	public static void main(String[] args) {
		if (args.length != 1) {			// 检查参数是否为一个存在的文件路径
			System.out.println("程序需要一个文件路径作为参数！");
			return;
		}
		String folderPath = args[0];
		File file = new File(folderPath);
		if (!file.exists()) {
			System.out.println(folderPath + "不是有效的路径！");
			return;
		}
		if (!file.isFile()) {
			System.out.println(folderPath + "不是有效的文件！");
			return;
		}
		// 使用新的文件名创建新的文件实例
		File renameFile = new File(file.getParentFile(), "renamedFile");
		// 如果新的文件名已经被占用了，则不进行重命名
		if (renameFile.exists()) {
			System.out.println("文件名已被占用！");
			return;
		}
		// 重命名并输出结果
		if (file.renameTo(renameFile)) {
			System.out.println("文件重命名成功。");
		} else {
			System.out.println("文件重命名失败。");
		}
	}
}
