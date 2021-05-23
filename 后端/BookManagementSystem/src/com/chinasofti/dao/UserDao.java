package com.chinasofti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.entity.User;
/**
 * 
 * @author 林镕琛
 * @version 1.0
 * 将登录的数据库操作封装在此类中
 */
public class UserDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// 根据用户ID获取用户信息
	public User getUserById(String uid){
		String sql = "select * from user_tb where uid = ?";
		User user = null;
		try {
			//通过公共类得到连接对象
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			String pwd = null;
			String role= null;
			String userName = null;
			//给sql中的？占位符指定数据，注意数据类型
			stmt.setString(1, uid);
			rs = stmt.executeQuery();
			while(rs.next()){					
				pwd = rs.getString("pwd");
				role = rs.getString("role");
				user = new User(uid,userName, pwd,role);  // 返回对象
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}	
	}	
}
