package com.oa.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class OA_LabelUtil {
	// 连接数据库
	public static Connection getConn() {
		
		System.out.println("OA_LabelUtil.java, getConn()");
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/oa_label";
		String user = "root";
		String password = "wsljn123";
		Connection conn = null;
		
		// 加载mysql 驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("无法加载mysql 数据库驱动！");
			e.printStackTrace();
		}
		// 创建mysql 数据库连接
		try {
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建mysql 数据库连接出错！");
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("无法创建mysql 数据库连接！");
		} else {
			System.out.println("创建mysql 数据库连接成功！");
		}
		
		return conn;
	}
}
