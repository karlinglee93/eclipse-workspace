package com.oa.service;

import com.oa.util.RestUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Basises {
	public String getBasises(String choose, String secretLevel) throws Exception {
		int value = Integer.parseInt(choose);
		
//		int secretLevel = -1;
//		if (value == 0 || value == 1 || value == 2 || value == 3) {
//			secretLevel = 120;
//		} else if (value == 4 || value == 5 || value == 6 || value == 7) {
//			secretLevel = 150;
//		} else {
//			System.out.println("secretLevel is wrong! ");
//		}
		
		String url = "http://10.165.24.117:1257/api/v1/basis/find?";
		String query = "secretLevel=" + secretLevel;
		
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
        + "\"level\":" + secretLevel + ",\"name\":\"" + name + "\"},"
        + "\"type\":" + type + "},"
        + "\"drafter\":{\"id\":\"0e887468-f53a-46f8-aa6d-2562b4b79da0\",\"name\":\"test\"},"
        + "\"duration\":{\"condition\":\"1\",\"period\":\"" + period + "\"},"
        + "\"fileAssetId\":\"\",\"fileContentId\":\"\","
        + "\"fileUniqueId\":\"" + procDefUniqueId + "\",\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,"
        + "\"level\":" + secretLevel + ","
        + "\"organs\":[{\"id\":\"" + organs_id + "\",\"name\":\"" + organs_name + "\"}],"
        + "\"scope\":{\"description\":\"" + secretScope + "\"},\"status\":80}";
	
		return Label;

//		int Id = value+1;
//		
////		System.out.println("Receive.java, doGet(), Id = " + Id);
//		// 万物皆对象
//		Label lb = new Label();
//		LabelDao.getAll(Id, lb);
//
//		
//		int level = lb.getLevel();
//		int type = lb.getType();
//		String period = lb.getPeriod();
//		String name = lb.getName();
//		String procDefUniqueId = lb.getProcDefUniqueId();
//		String organs_name = lb.getOrgans_name();
//		String organs_id = lb.getOrgans_id();
//		String secretScope = lb.getSecretScope();
//		
////		System.out.println(Id);
////		System.out.println(name);
////		System.out.println(level);
////		System.out.println(period);
////		System.out.println(secretScope);
////		System.out.println(type);
////		System.out.println(procDefUniqueId);
////		System.out.println(organs_id);
////		System.out.println(organs_name);
//		String Label = 
//				"{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},"
//                + "\"basises\":{\"description\":\"1\","
//                + "\"normalItems\":["
//                + "{\"duration\":{\"period\":\"" + period + "\"},\"id\":\"" + Id + "\","
//                + "\"level\":" + level + ",\"name\":\"" + name + "\"},"
//                + "\"type\":" + type + "},"
//                + "\"drafter\":{\"id\":\"0e887468-f53a-46f8-aa6d-2562b4b79da0\",\"name\":\"test\"},"
//                + "\"duration\":{\"condition\":\"1\",\"period\":\"" + period + "\"},"
//                + "\"fileAssetId\":\"\",\"fileContentId\":\"\","
//                + "\"fileUniqueId\":\"" + procDefUniqueId + "\",\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,"
//                + "\"level\":" + level + ","
//                + "\"organs\":[{\"id\":\"" + organs_id + "\",\"name\":\"" + organs_name + "\"}],"
//                + "\"scope\":{\"description\":\"" + secretScope + "\"},\"status\":80}";
//		
//		System.out.println(Label);
	}
}
