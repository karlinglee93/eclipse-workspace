package com.oa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oa.util.Service;

import javafx.scene.control.Alert;

//import com.oa.dao.LabelDao;
//import com.oa.po.Label;
//import com.oa.util.RestUtil;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

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
			// 指定服务器相应的编码格式为utf-8:支持中文
			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
			
			String secretLevel = new String(request.getParameter("level"));
			String choose = new String(request.getParameter("choose"));
			
			String serverUrl = "http://10.165.24.117:1257/api/v1/frame/upload/temp";
			String localFilePath = "/Users/karlinglee/Documents/eclipse-workspace/OA/src/com/oa/others/ljn.doc";
			String serverFieldName = "files";
			String label = "";
			String fileNameInServer = "";
			String fileUrl;
			Service service = new Service();

			try {
				label = service.getBasises(secretLevel, choose);
				System.out.println(label);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fileNameInServer = service.uploadFileImpl(serverUrl, localFilePath, serverFieldName);
				System.out.println(fileNameInServer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fileUrl = "http://10.165.24.117:1257/api/v1/label/" + fileNameInServer;
			try {
				int value = service.sendHttpPost(fileUrl, label);
				if (value == 200) {
					String out = "恭喜你！加密成功！";
					System.out.println(out);
					response.setContentType("text/html;charset=utf-8");
					// response.getWriter().write()与PrintWriter.print()的区别
//					response.getWriter().write(out);
					PrintWriter pWriter = response.getWriter();
					// 输出是html类型
					out += "</br>服务器中的文件名称为：</br>" + fileNameInServer + "</br>欢迎查找！";

					pWriter.println(out);
					pWriter.flush();
					pWriter.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
