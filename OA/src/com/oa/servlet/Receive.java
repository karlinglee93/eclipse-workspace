package com.oa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oa.dao.LabelDao;

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
			String choose = new String(request.getParameter("choose"));
			// 指定服务器相应的编码格式为utf-8:支持中文
			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
			
			int value = Integer.parseInt(choose);
			int Id = value+1;
			
			System.out.println("Receive.java, doGet(), Id = " + Id);
			
			LabelDao.getAll(Id);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("My name is doPost()"); 
		doGet(request, response);
	}

}
