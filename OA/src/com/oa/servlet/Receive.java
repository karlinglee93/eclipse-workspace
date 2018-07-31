/**
 * Receive.java
 * 主要用于前端向后端传递参数、进行业务逻辑处理、后端向前端响应。
 * 
 * 由于index.jsp中的action采用的是post方法，所以在servlet层的Receive.java里调用的是doPost()方法；
 * doPost()方法中有两个参数，一个是request，一个是response；前者是前端之于后端的给予，后者是业务逻辑处理后后端对前端的响应。
 * 
 * 参数传入Service.java中的getBasises()方法，返回字符串label；
 * 参数sendHttpPost()方法，对文件进行加密；
 * 		当返回值为200时，代表加密成功；否则加密失败，具体原因见密标文档。
 * 
 * 并通过PrintWriter类中的response.getWriter()方法向前台响应。
 * 响应结束后对PrintWriter类进行，flush/close()
 * 
 */
package com.oa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oa.util.Service;

/**
 * Servlet implementation class Receive
 */
// 把下面的打开会报错，因为它是自动生成servlet maping的，与我之前设置的maping相冲突
// @WebServlet("/Receive")
public class Receive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Receive() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 把下面打开会导致中文乱码
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 你的第一个接口请求返回json字符串
		if (request.getParameter("choose") != null) {
			// 指定服务器相应的编码格式为utf-8:支持中文
			response.setContentType("text/html;charset=utf-8");

			String secretLevel = new String(request.getParameter("level"));
			String choose = new String(request.getParameter("choose"));
			String label = "";

			Service service = new Service();
			try {
				label = service.getBasises(secretLevel, choose);
				System.out.println(label);
			} catch (Exception e) {
				e.printStackTrace();
			}

			String serverUrl = "http://10.165.24.117:1257/api/v1/frame/upload/temp";
			String localFilePath = "/Users/karlinglee/Documents/eclipse-workspace/OA/src/com/oa/others/ljn.doc";
			String serverFieldName = "files";
			String fileNameInServer = "";

			try {
				fileNameInServer = service.uploadFileImpl(serverUrl, localFilePath, serverFieldName);
				System.out.println(fileNameInServer);
			} catch (Exception e) {
				e.printStackTrace();
			}

			String fileUrl;
			String out;
			// response.getWriter().write()与PrintWriter.print()的区别
			PrintWriter pWriter = response.getWriter();

			fileUrl = "http://10.165.24.117:1257/api/v1/label/" + fileNameInServer;
			try {
				int value = service.sendHttpPost(fileUrl, label);
				if (value == 200) {
					out = "恭喜你！加密成功！" + "</br>服务器中的文件名称为：</br>" + fileNameInServer + "</br>欢迎查找！";
					System.out.println(out);
					// response.getWriter().write(out);
				} else {
					out = "加密失败！";
					System.out.println(out);
				}
				// 输出是html类型
				pWriter.println(out);
				pWriter.flush();
				pWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("My name is doPost()");
		doGet(request, response);
	}

}
