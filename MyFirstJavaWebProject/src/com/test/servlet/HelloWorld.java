package com.test.servlet;
 
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
 
public class HelloWorld extends HttpServlet {
 
	/**
	 * Constructor of the object.
	 */
	public HelloWorld() {
		super();
	}
 
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
 
	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 你的第一个接口请求返回json字符串
		if (request.getParameter("name") != null) {
			System.out.println("My name is doGet()"); 
			// 处理中文 获取浏览器的请求数据 String
			String name = new String(request.getParameter("name")
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
				map.put("name", name);
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
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("My name is doPost");
		// 方法请求的方法,一般情况下web程序员都是用这种处理方式get安全性非常低，post安全性较高。但是执行效率却比Post方法好
		doGet(request, response);
	}
 
	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
 
}

