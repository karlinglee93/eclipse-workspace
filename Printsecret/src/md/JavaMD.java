package md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class JavaMD {
	
	private static String src = "object-oriented";

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println("原始字符串: " + src + "\n");
		
		jdkMD5();
	}
	
	/**
	 * jdk实现MD5(消息摘要算法)加密
	 * @throws NoSuchAlgorithmException 
	 */
	public static void jdkMD5() throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] md5Bytes = md.digest(src.getBytes());
		// 利用第三方包将byte数组转化为16进制字符串
		System.out.println("JDK MD5: " + Hex.encodeHexString(md5Bytes));
		
	}
	
}
