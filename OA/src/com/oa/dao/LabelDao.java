package com.oa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.oa.po.Label;
import com.oa.util.OA_LabelUtil;

public class LabelDao {
	public static void getAll(int Id) {
		
//		System.out.println("LabelDao.java, getAll(), Id = " + Id);
		
		Connection conn = OA_LabelUtil.getConn();
		String sql = "select * from Label where id =" + Id;

		PreparedStatement psmt;
		try {
			// 预编译sql 语句
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			// 执行sql 语句
			ResultSet rs = psmt.executeQuery();
			// 万物皆对象
			Label lb = new Label();
			// 读取ResultSet 关键字个数
//			int col = rs.getMetaData().getColumnCount();
			// 解析ResultSet 为字符串
			while (rs.next()) {
				lb.setName(rs.getString(2));
				lb.setLevel(rs.getInt(3));
				lb.setPeriod(rs.getString(4));
				lb.setSecretScope(rs.getString(5));
				lb.setType(rs.getInt(6));
				lb.setProcDefUniqueId(rs.getString(7));
				lb.setOrgans_id(rs.getString(8));
				lb.setOrgans_name(rs.getString(9));
			}
		
//	        while (rs.next()) {
//	            for (int i = 2; i <= col; i++) {
//	                System.out.print(rs.getString(i));
////	                System.out.print(rs.getString(i) + "\t");
////	                if ((i == 2) && (rs.getString(i).length() < 8)) {
////	                    System.out.print("\t");
////	                }
//	             }
////	            System.out.println("");
//	        }
	        
	        psmt.close();
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
