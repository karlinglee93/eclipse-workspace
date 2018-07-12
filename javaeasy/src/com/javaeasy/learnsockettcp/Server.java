package com.javaeasy.learnsockettcp;

import java.io.BufferedReader;						// 引入需要使用的类
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//服务器端程序
public class Server {								
	public static void main(String[] args) {		// main()方法
		try {
			  ServerSocket ss = new ServerSocket(7777);
											// （1）在本机的7777端口监听
			  System.out.println("服务器端在7777端口监听……"); 
			  Socket s = ss.accept();		// （2）等待客户端连接到7777端口
			  // 如果没有客户端连接过来，accept()方法不会返回
			  System.out.println("已有客户端连接过来，开始进行通信……");
			  
			  InputStream in = s.getInputStream();	// （3）得到输入流
			  OutputStream out = s.getOutputStream();// （4）得到输出流
			  
			  // 使用PrintWriter向客户端输出数据
			  PrintWriter pw = new PrintWriter(out);	
			  System.out.println("正在向客户端发送消息……");
			  pw.write("客户端，你好，这里是服务器端。\r\n");
			  pw.flush();				// 强制发送数据
			  System.out.println("向客户端发送消息完成。");
			  
			  // 使用BufferedReader读取客户端发送来的数据
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String response = br.readLine();
			  System.out.println("======下面是客户端发来的消息======");
			  System.out.println(response);
			  System.out.println("================================");
			  
			  // （5）调用close()方法释放资源
			  br.close();					
			  pw.close();
			  s.close();
			  ss.close();
		} catch (UnknownHostException e) {
			  System.out.println("无法找到相应的机器，错误信息。" + e.getMessage());
		} catch (IOException e) {
			 System.out.println("数据传输出现异常：" + e.getMessage());
		}
	}
}
