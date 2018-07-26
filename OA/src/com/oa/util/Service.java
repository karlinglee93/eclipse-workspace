package com.oa.util;

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

import com.oa.util.RestUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Service {
	public String getBasises(String secretLevel, String choose) throws Exception {
		String url = "http://10.165.24.117:1257/api/v1/basis/find?";
		String query = "secretLevel=" + secretLevel;
		int value = Integer.parseInt(choose);
		
		RestUtil ru = new RestUtil();
		String label = ru.load(url, query);
		JSONArray jArray = JSONArray.fromObject(label);
		JSONObject jObject = jArray.getJSONObject(value);
		String id = jObject.getString("id");
		String name = jObject.getString("name");
		
		String secretLimit = jObject.getString("secretLimit");
		JSONObject jObject1 = JSONObject.fromObject(secretLimit);
		String period = jObject1.getString("period");
		
		String secretScope = jObject.getString("secretScope");
		String type = jObject.getString("type");
		
		String combinactions = jObject.getString("combinactions");
		jArray = JSONArray.fromObject(combinactions);
		jObject = jArray.getJSONObject(0);
		String organs_id = jObject.getString("id");
		String organs_name = jObject.getString("name");
		
		String basis_combination = jObject.getString("basis_combination");
		jObject = JSONObject.fromObject(basis_combination);
		String procDefUniqueId = jObject.getString("basis_id");
		
		String Label = 
		"{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},"
        + "\"basises\":{\"description\":\"1\","
        + "\"normalItems\":["
        + "{\"duration\":{\"period\":\"" + period + "\"},\"id\":\"" + id + "\","
        + "\"level\":" + secretLevel + ",\"name\":\"" + name + "\"}],"
        + "\"type\":" + type + "},"
        + "\"drafter\":{\"id\":\"0e887468-f53a-46f8-aa6d-2562b4b79da0\",\"name\":\"test\"},"
        + "\"duration\":{\"condition\":\"1\",\"period\":\"" + period + "\"},"
        + "\"fileAssetId\":\"\",\"fileContentId\":\"\","
        + "\"fileUniqueId\":\"" + procDefUniqueId + "\",\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,"
        + "\"level\":" + secretLevel + ","
        + "\"organs\":[{\"id\":\"" + organs_id + "\",\"name\":\"" + organs_name + "\"}],"
        + "\"scope\":{\"description\":\"" + secretScope + "\"},\"status\":80}";
	
		return Label;

//			int Id = value+1;
//			
////			System.out.println("Receive.java, doGet(), Id = " + Id);
//			// 万物皆对象
//			Label lb = new Label();
//			LabelDao.getAll(Id, lb);
//
//			
//			int level = lb.getLevel();
//			int type = lb.getType();
//			String period = lb.getPeriod();
//			String name = lb.getName();
//			String procDefUniqueId = lb.getProcDefUniqueId();
//			String organs_name = lb.getOrgans_name();
//			String organs_id = lb.getOrgans_id();
//			String secretScope = lb.getSecretScope();
//			
////			System.out.println(Id);
////			System.out.println(name);
////			System.out.println(level);
////			System.out.println(period);
////			System.out.println(secretScope);
////			System.out.println(type);
////			System.out.println(procDefUniqueId);
////			System.out.println(organs_id);
////			System.out.println(organs_name);
//			String Label = 
//					"{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},"
//	                + "\"basises\":{\"description\":\"1\","
//	                + "\"normalItems\":["
//	                + "{\"duration\":{\"period\":\"" + period + "\"},\"id\":\"" + Id + "\","
//	                + "\"level\":" + level + ",\"name\":\"" + name + "\"},"
//	                + "\"type\":" + type + "},"
//	                + "\"drafter\":{\"id\":\"0e887468-f53a-46f8-aa6d-2562b4b79da0\",\"name\":\"test\"},"
//	                + "\"duration\":{\"condition\":\"1\",\"period\":\"" + period + "\"},"
//	                + "\"fileAssetId\":\"\",\"fileContentId\":\"\","
//	                + "\"fileUniqueId\":\"" + procDefUniqueId + "\",\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,"
//	                + "\"level\":" + level + ","
//	                + "\"organs\":[{\"id\":\"" + organs_id + "\",\"name\":\"" + organs_name + "\"}],"
//	                + "\"scope\":{\"description\":\"" + secretScope + "\"},\"status\":80}";
//			
//			System.out.println(Label);
	}
	
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
//				System.out.println(response.getStatusLine()); 
				HttpEntity resEntity = response.getEntity(); 
				respStr = getRespString(resEntity); 
				EntityUtils.consume(resEntity);
			} finally { 
				response.close();
			}
		} finally {
			httpclient.close(); 
		}
//		System.out.println("resp=" + respStr);
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
}
