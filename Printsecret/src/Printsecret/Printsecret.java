package Printsecret;

import java.util.Scanner;

public class Printsecret {

	public static void main(String[] args) {
		Scanner myin = new Scanner(System.in);
		System.out.println("请输入要加密的数据");
		String password = myin.nextLine();
		
		// 字符串是一个对象，将字符串转换成字符数组的形式，已对数据进行格式化。
		char[] array = password.toCharArray();
		// 采用建立一个秘钥"20000" 与每一个字符进行异或运算
		for (int i = 0; i < array.length; i++) {
			array[i] = (char)(array[i] ^ 20000);  
		}
		System.out.println("信息加密后显示如下：");
		System.out.println(new String(array));
		myin.close();
		
		// 解密：异或运算的自反性，将加密后的字符数组在与秘钥"20000" 进行一次异或运算就会回到原来的状态
		for (int i = 0; i < array.length; i++) {
			array[i] = (char)(array[i] ^ 20000);  
		}
		System.out.println("解密后显示如下：");
		System.out.println(new String(array));
	}

}
