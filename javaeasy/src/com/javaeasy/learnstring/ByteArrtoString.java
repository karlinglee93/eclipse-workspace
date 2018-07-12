package com.javaeasy.learnstring;

import java.io.UnsupportedEncodingException;

public class ByteArrtoString {
	public static void main(String[] args) {
		try {
			byte[] byteContent = new byte[] { 0x5f, (byte) 0x97, 0x4e, 0x4b,
					0x4e, 0x0d, (byte) 0x96, (byte) 0xbe, (byte) 0xff, 0x0c,
					0x59, 0x31, 0x4e, 0x4b, 0x5f, (byte) 0xc5, 0x66, 0x13,
					0x30, 0x02 };					// 数组内容
			String str = new String(byteContent, "UTF-16BE");
													// 指定byte数组和编码
			System.out.println(str);				// 输出转换后的内容
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
