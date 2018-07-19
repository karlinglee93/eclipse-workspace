package com.oa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
			System.out.println("My name is doGet()"); 
			// 处理中文 获取浏览器的请求数据 String
			String choose = new String(request.getParameter("choose")
					.getBytes("ISO8859-1"), "UTF-8"); 
			// 指定服务器相应的编码格式为utf-8:支持中文
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();//记得导入gson.jar
			ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
 
			for (int i = 0; i < 10; i++) {//模拟数据库数据
				Map<String, String> map = new HashMap<String, String>();
				map.put("oneKey", "one");
				map.put("twoKey", "tow");
				map.put("thirdKey", "third");
				map.put("chineseTest", "小明");
				map.put("choose", choose);
				list.add(map);
			}
			String json = gson.toJson(list);
			//输出json字符串给客户端
			out.print(json);
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
