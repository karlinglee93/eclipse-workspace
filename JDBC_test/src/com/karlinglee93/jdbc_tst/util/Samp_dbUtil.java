package com.karlinglee93.jdbc_tst.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Samp_dbUtil {
	// 连接数据库
	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/samp_db?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user = "root";
		String password = "wsljn123";
		
		// 加载mysql驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("无法加载数据库驱动。");
			e.printStackTrace();
		}
		
		// 创建数据库连接
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建数据库连接出错：");
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("无法创建数据库连接。");
		} else {
//			System.out.println("数据源测试成功。");
		}
		
		return conn;
	}
}
