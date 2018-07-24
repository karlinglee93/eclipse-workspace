package com.oa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oa.dao.LabelDao;
import com.oa.po.Label;

/**
 * Servlet implementation class Receive
 */
// 把下面的打开会报错，因为它是自动生成servlet maping的，与我之前设置的maping相冲突
//@WebServlet("/Receive")
public class Receive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Receive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 把下面打开会导致中文乱码
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 你的第一个接口请求返回json字符串
		if (request.getParameter("choose") != null) {
//			System.out.println("My name is doGet()"); 
			// 处理中文 获取浏览器的请求数据 String
			String choose = new String(request.getParameter("choose"));
			// 指定服务器相应的编码格式为utf-8:支持中文
			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
			
			int value = Integer.parseInt(choose);
			int Id = value+1;
			
//			System.out.println("Receive.java, doGet(), Id = " + Id);
			// 万物皆对象
			Label lb = new Label();
			LabelDao.getAll(Id, lb);

			
			int level = lb.getLevel();
			int type = lb.getType();
			String period = lb.getPeriod();
			String name = lb.getName();
			String procDefUniqueId = lb.getProcDefUniqueId();
			String organs_name = lb.getOrgans_name();
			String organs_id = lb.getOrgans_id();
			String secretScope = lb.getSecretScope();
			
//			System.out.println(Id);
//			System.out.println(name);
//			System.out.println(level);
//			System.out.println(period);
//			System.out.println(secretScope);
//			System.out.println(type);
//			System.out.println(procDefUniqueId);
//			System.out.println(organs_id);
//			System.out.println(organs_name);
			String Label = 
					"{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},"
                    + "\"basises\":{\"description\":\"1\","
                    + "\"normalItems\":["
                    + "{\"duration\":{\"period\":\"" + period + "\"},\"id\":\"" + Id + "\","
                    + "\"level\":" + level + ",\"name\":\"" + name + "\"},"
                    + "\"type\":" + type + "},"
                    + "\"drafter\":{\"id\":\"0e887468-f53a-46f8-aa6d-2562b4b79da0\",\"name\":\"test\"},"
                    + "\"duration\":{\"condition\":\"1\",\"period\":\"" + period + "\"},"
                    + "\"fileAssetId\":\"\",\"fileContentId\":\"\","
                    + "\"fileUniqueId\":\"" + procDefUniqueId + "\",\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,"
                    + "\"level\":" + level + ","
                    + "\"organs\":[{\"id\":\"" + organs_id + "\",\"name\":\"" + organs_name + "\"}],"
                    + "\"scope\":{\"description\":\"" + secretScope + "\"},\"status\":80}";
			
			System.out.println(Label);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("My name is doPost()"); 
		doGet(request, response);
	}

}
