package com.cn;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static final String KEY_MD5 = "MD5";
	
	public static void getResult(String inputStr) throws NoSuchAlgorithmException {
		System.out.println("=====加密前的数据=====" + inputStr);
		
		MessageDigest md = MessageDigest.getInstance(KEY_MD5);
		byte[] inputData = inputStr.getBytes();
		System.out.println("=====MD5加密后=====" + md.digest(inputData).toString());
	}
	
	public static void main(String[] args) {
		try {
            String inputStr = "12345678";   
            getResult(inputStr);
       } catch (Exception e) {
           e.printStackTrace();
       }
	}

}
