package com.karlinglee.Util;

import java.io.File;
import java.io.FileOutputStream; 
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse; 
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder; 
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class UploadFile {
	/** *
	* @brief 上传文件
	* @details 详细说明
	* @param serverUrl
	* @param localFilePath
	* @param serverFieldName
	* @return
	* @throws Exception */
	public static String uploadFileImpl(String serverUrl, String localFilePath, String serverFieldName) throws Exception {
		String respStr = null;
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		try {
			HttpPost httppost = new HttpPost(serverUrl);
			FileBody binFileBody = new FileBody(new File(localFilePath)); 
			MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create(); 
			// add the file params
			multipartEntityBuilder.addPart(serverFieldName, binFileBody);
			HttpEntity reqEntity = multipartEntityBuilder.build(); httppost.setEntity(reqEntity);
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				System.out.println(response.getStatusLine()); 
				HttpEntity resEntity = response.getEntity(); 
				respStr = getRespString(resEntity); 
				EntityUtils.consume(resEntity);
			} finally { 
				response.close();
			}
		} finally {
			httpclient.close(); 
		}
		System.out.println("resp=" + respStr);
		return respStr; 
	}
	/**
	* 将返回结果转化为 String * @param entity
	* @return
	* @throws Exception
	*/
	private static String getRespString(HttpEntity entity) throws Exception { 
		if (entity == null) {
			return null; 
		}
		InputStream is = entity.getContent(); 
		StringBuffer strBuf = new StringBuffer(); 
		byte[] buffer = new byte[4096];
		int r = 0;
		while ((r = is.read(buffer)) > 0) {
			strBuf.append(new String(buffer, 0, r, "UTF-8"));
		}
		return strBuf.toString(); 
	}
//	/**
//	* 下载文件
//	* @param url
//	* @param destFileName
//	* @throws ClientProtocolException * @throws IOException
//	*/
//	public static void getFile(String url, String destFileName) throws Exception {
//		// 生成一个 httpclient 对象
//		CloseableHttpClient httpclient = HttpClients.createDefault(); 
//		HttpGet httpget =new HttpGet(url);
//		HttpResponse response = httpclient.execute(httpget); 
//		HttpEntity entity = response.getEntity();
//		InputStream in = entity.getContent();
//		File file =new File(destFileName);
//		try{
//			FileOutputStream fout =new FileOutputStream(file); 
//			int l = -1;
//			byte[] tmp =new byte[1024];
//			while((l = in.read(tmp)) != -1) { 
//				fout.write(tmp,0, l);
//			} 
//			fout.flush(); 
//			fout.close();
//		}finally{
//			// 关闭低层流。
//			in.close(); 
//		}
//		httpclient.close(); 
//	}
	
	public static void main(String[] args) throws Exception{ 
		//上传文件,将本机桌面上的文件上传至密标服务器 temp 文件夹下
		uploadFileImpl("http://10.165.24.117:1257/api/v1/frame/upload/temp/","/Users/karlinglee/Documents/eclipse-workspace/OA/src/com/oa/others/ljn.doc","files");
		//下载文件,从密标服务器将 temp 文件夹下的 456.pdf 下载至本机桌面
//		getFile("http://10.165.24.117:1258/api/v1/frame/download/temp/456.pdf","C:/Users/yanf a/Desktop/456.pdf");
	} 
};