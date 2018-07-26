package com.karlinglee.Util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Secret {
	public static String sendHttpPost(String url, String body) throws Exception { 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>(); 
		pairList.add(new BasicNameValuePair("label", body)); 
		httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8")); 
		CloseableHttpResponse response = httpClient.execute(httpPost); 
		System.out.println(response.getStatusLine().getStatusCode() + "\n"); 
		HttpEntity entity = response.getEntity();
		String responseContent = EntityUtils.toString(entity, "UTF-8"); 
		System.out.println(responseContent);
		response.close();
		httpClient.close();
		return responseContent;
	}
	
	public static void main(String[] args) throws Exception{
		//标志属性
//		String label = "{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},"
//				+ "\"basises\":{\"description\":\"1\",\"normalItems\":[{\"duration\":{\"period\":\"999999\"},"
//				+ "\"id\":\"a494090c-3d3e-4b97-9304-62e05b40 baca\",\"level\":50,"
//				+ "\"name\":\"绩效管理有关信息 \"},{\"duration\":{\"period\":\"999999\"},"
//				+ "\"id\":\"ac803f05-6d3f-4167-8884-c6b1310dc5b1\",\"l evel\":50,"
//				+ "\"name\":\"公司人工成本信息及相关统计数据 \"}],\"type\":10},"
//				+ "\"drafter\":{\"id\":\"0e887468-f53a-46f8-aa6d-2562b4b79da0\","
//				+ "\"name\":\"test\"},\"duration\":{\"condition\":\"1\",\"period\":\"999999\"},"
//				+ "\"fileAssetId\":\"\",\"fileContentId\":\"\",\"fileUniqueId\":\"a6418d3b-7a8c-42f1-8f1d-05b4ede46b31\","
//				+ "\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,"
//				+ "\"level\":180,\"organs\":[{\"id\":\"37bf5a52-d5af-4fdd-a901-a487d8925471\","
//				+ "\"name\":\"国务院\"}],\"scope\":{\"description\":\"有关领导、相关部门及承办人员\"},\"status\":110}";
		String label = "{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},"
				+ "\"basises\":{\"description\":\"1\",\"normalItems\":[{\"duration\":{\"period\":\"999999\"},"
				+ "\"id\":\"a6418d3b-7a8c-42f1-8f1d-05b4ede46b31\",\"level\":120,"
				+ "\"name\":\"涉及食品药品监管全局的重大方针政策、工作部署及相关信息\"}],\"type\":0},"
				+ "\"drafter\":{\"id\":\"0e887468-f53a-46f8-aa6d-2562b4b79da0\","
				+ "\"name\":\"test\"},\"duration\":{\"condition\":\"1\",\"period\":\"999999\"},"
				+ "\"fileAssetId\":\"\",\"fileContentId\":\"\",\"fileUniqueId\":\"\","
				+ "\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,"
				+ "\"level\":120,\"organs\":[{\"id\":\"b33f3cb7-9599-41a5-86ca-cf3007734d8d\","
				+ "\"name\":\"食药监定密依据\"}],\"scope\":{\"description\":\"有关领导、相关部门及承办人员\"},\"status\":80}";
		String url = "http://10.165.24.117:1257/api/v1/label/28e3f0e1-6847-47c8-939d-c837521e7570.doc";
	sendHttpPost(url ,label);
	}
}