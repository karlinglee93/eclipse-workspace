/**
 * Service.java
 * 主要存放业务逻辑处理时所需的方法。
 * 
 * getBasises()方法：通过传递由request.getParameter()方法所获取的前端密级secretLevel/单选项choose参数，返回加密标签字符串label；
 * uploadFileImpl()方法：通过传递服务器上传文件的接口地址serverUrl/所要上传文件的路径localFilePath等信息参数，返回服务器中已加密的文件名字符串fileNameInServer；
 * sendHttpPost()方法：通过传递label、fileNameInServer等信息参数，返回int加密结果；
 */
package com.oa.util;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.oa.util.RestUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Service {
	/**
	 * getBasises()
	 * 通过传入的参数，获取服务器密标接口的Json串，并对其进行分解，拼接成新的字符串label。
	 * 
	 * @param secretLevel 前端密级
	 * @param choose 前端单选项
	 * @return label 字符串，为加密标签
	 * @throws Exception
	 */
	public String getBasises(String secretLevel, String choose) throws Exception {
		String url = "http://10.165.24.117:1257/api/v1/basis/find?";
		String query = "secretLevel=" + secretLevel;
		int value = Integer.parseInt(choose);
		// RestUtil类的load()方法：与服务器接口进行连接，并返回Json字符串
		RestUtil ru = new RestUtil();
		String label = ru.load(url, query);
		// 对Json串进行分解
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
		//对分解后的Json串进行合并，并拼接成label
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
	* @brief 上传本地文件至服务器
	* @details 上传文件到服务器，
	* 并对getRespString()方法所返回的存储在服务器上的文件信息（Json串）进行分解，
	* 提取该文件在服务器中的文件名并返回。
	* @param serverUrl 服务器接口地址
	* @param localFilePath 所上传文件的本地地址
	* @param serverFieldName
	* @return 返回存储在服务器中的文件名
	* @throws Exception */
	public String uploadFileImpl(String serverUrl, String localFilePath, String serverFieldName) throws Exception {
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
				// 返回存储在服务器上的文件信息
				respStr = getRespString(resEntity); 
				EntityUtils.consume(resEntity);
			} finally { 
				response.close();
			}
		} finally {
			httpclient.close(); 
		}
		JSONArray jsonArray = JSONArray.fromObject(respStr);
		JSONObject jObject = jsonArray.getJSONObject(0);
		String fileNameInServer = jObject.getString("filename");
		
		System.out.println(respStr);
		return fileNameInServer; 
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
	
	/**
	 * 加密方法
	 * @param url 服务器接口地址
	 * @param body 加密label
	 * @return 加密状态
	 * @throws Exception
	 */
	public int sendHttpPost(String url, String body) throws Exception { 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>(); 
		pairList.add(new BasicNameValuePair("label", body)); 
		httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8")); 
		CloseableHttpResponse response = httpClient.execute(httpPost); 
		
		int value = response.getStatusLine().getStatusCode();
		System.out.println(value); 
		HttpEntity entity = response.getEntity();
		String responseContent = EntityUtils.toString(entity, "UTF-8"); 
		System.out.println(responseContent);
		response.close();
		httpClient.close();
		return value;
	}
}
