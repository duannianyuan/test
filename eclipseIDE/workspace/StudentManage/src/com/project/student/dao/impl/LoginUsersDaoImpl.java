package com.project.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.project.student.dao.LoginUsersDao;
import com.project.student.pojo.Users;
import com.project.student.utils.JDBCUtils;


public class LoginUsersDaoImpl implements LoginUsersDao {
	
	@Override
	public Users loginDao(String uname, String upwd) throws Exception {
		// 创建user
		Users user = new Users();
		// 创建数据库连接对象
		Connection connection = null;
		// 获取预编译对象
		PreparedStatement preSta = null;
		// 接受数据
		ResultSet resultSet = null;
		// 创建一个集合
		ArrayList<Users> arrayList = new ArrayList<Users>();
		// 创建sql语句对象
		String sql = "SELECT * FROM users WHERE uname=? AND upwd =?";
		try {
			connection = JDBCUtils.getConnection();
			preSta = connection.prepareStatement(sql);
			// 给预编译进行赋值		
			preSta.setString(1, uname);
			preSta.setString(2, upwd);
			// 执行查询，并返回结果
			resultSet = preSta.executeQuery();
			// 同游标获取对应数据
			while(resultSet.next()) {
				user.setUid(resultSet.getInt("uid"));
				user.setUname(resultSet.getString("uname"));
				user.setUpwd(resultSet.getString("upwd"));
				arrayList.add(user);
			}
			System.out.println("arrayList:"+arrayList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.getClose1(connection, preSta, resultSet);
		}
		return user;
	}
}
