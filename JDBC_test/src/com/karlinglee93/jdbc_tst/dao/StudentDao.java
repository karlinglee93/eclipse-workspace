package com.karlinglee93.jdbc_tst.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.karlinglee93.jdbc_tst.po.Student;
import com.karlinglee93.jdbc_tst.util.Samp_dbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class StudentDao {
	// 增insert
	public static void insert(Student student) {
	    Connection conn = Samp_dbUtil.getConn();
	    
	    String sql = "insert into students (Name,Sex,Age) values(?,?,?)";
	    // 预编译
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        // 传参
	        pstmt.setString(1, student.getName());
	        pstmt.setString(2, student.getSex());
	        pstmt.setInt(3, student.getAge());
	        // 执行
	        pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// 改update
	public static void update(Student student) {
	    Connection conn = Samp_dbUtil.getConn();
	    
	    String sql = "update students set Age=? where Name=?";
	    
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, student.getAge());
	        pstmt.setString(2, student.getName());
	        
	        pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// 查所有
	public static Integer getAll() {
	    Connection conn = Samp_dbUtil.getConn();
	    String sql = "select * from students";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        
	        ResultSet rs = pstmt.executeQuery();

	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	        System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	// 删
	public static void delete(String name) {
	    Connection conn = Samp_dbUtil.getConn();
	    String sql = "delete from students where Name=?";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        
	        pstmt.setString(1, name);
	        
	        pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
