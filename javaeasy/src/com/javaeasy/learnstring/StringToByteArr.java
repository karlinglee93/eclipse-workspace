package com.javaeasy.learnstring;

import java.io.UnsupportedEncodingException;

public class StringToByteArr {
	public static void main(String[] args) {
		try {
			String content = "字符串到数组";
			byte[] contentBytes = content.getBytes("UTF-16BE");
												// 将字符串转换为byte数组
			System.out.println("长度为" + content.length()
					+ "的字符串在UTF-16BE编码下对应的字节数组长度为：" +
					contentBytes.length);
			
			for (int i = 0; i < contentBytes.length; i++) {
				System.out.print(contentBytes[i] + ", ");
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
