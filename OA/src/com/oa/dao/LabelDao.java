package com.oa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.oa.util.OA_LabelUtil;

public class LabelDao {
	public static void getAll(int Id) {
		Connection conn = OA_LabelUtil.getConn();
		String sql = "select * from Label where id =" + Id;

		PreparedStatement psmt;
		try {
			// 预编译sql 语句
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			// 执行sql 语句
			ResultSet rs = psmt.executeQuery();
			
			int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	        
	        psmt.close();
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
