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
		// ����user
		Users user = new Users();
		// �������ݿ����Ӷ���
		Connection connection = null;
		// ��ȡԤ�������
		PreparedStatement preSta = null;
		// ��������
		ResultSet resultSet = null;
		// ����һ������
		ArrayList<Users> arrayList = new ArrayList<Users>();
		// ����sql������
		String sql = "SELECT * FROM users WHERE uname=? AND upwd =?";
		try {
			connection = JDBCUtils.getConnection();
			preSta = connection.prepareStatement(sql);
			// ��Ԥ������и�ֵ		
			preSta.setString(1, uname);
			preSta.setString(2, upwd);
			// ִ�в�ѯ�������ؽ��
			resultSet = preSta.executeQuery();
			// ͬ�α��ȡ��Ӧ����
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
			// �ر���Դ
			JDBCUtils.getClose1(connection, preSta, resultSet);
		}
		return user;
	}
}
