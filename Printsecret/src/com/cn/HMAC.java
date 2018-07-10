package com.cn;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
HMAC 
HMAC(Hash Message Authentication Code)散列消息鉴别码，基于密钥的Hash算法的认证协议。
消息鉴别码实现鉴别的原理是，用公开函数和密钥产生一个固定长度的值作为认证标识，用这个标识鉴别消息的完整性。
使用一个密钥生成一个固定大小的小数据块，
即MAC，并将其加入到消息中，然后传输。接收方利用与发送方共享的密钥进行鉴别认证等。
*/

public class HMAC {

	public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
	
	public static byte[] getSecretKey() throws Exception {
		// 秘钥生成器keyGenerator, 可填入 HmacSHA1，HmacSHA256 等
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5"); 
	    SecretKey key = keyGenerator.generateKey();
	    
	    byte[] keyBytes = key.getEncoded();
	    return keyBytes;
	}

	public static String encryptHmac(byte[] key, byte[] data) throws Exception {
	    SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");

	    Mac mac = Mac.getInstance("HmacMD5");
	    mac.init(secretKey);

	    byte[] resultBytes = mac.doFinal(data);
	    String resultString = bytesToHexString(resultBytes);

	    return resultString;
	}

	
	public static void main(String[] args) throws Exception {
		String str = "12345678";
		System.out.println(encryptHmac(getSecretKey(), str.getBytes()));
	}

}
