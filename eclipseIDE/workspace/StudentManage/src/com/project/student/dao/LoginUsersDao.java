package com.project.student.dao;

import com.project.student.pojo.Users;

public interface LoginUsersDao {
	/**
	 * ��ȡ���ݿ���û���������
	 * @param uname  
	 * @param upwd
	 * @return
	 * @throws Exception
	 */
	public Users loginDao(String uname, String upwd) throws Exception;
}
