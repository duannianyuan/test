package com.project.student.dao;

import com.project.student.pojo.Users;

public interface LoginUsersDao {
	/**
	 * 获取数据库的用户名和密码
	 * @param uname  
	 * @param upwd
	 * @return
	 * @throws Exception
	 */
	public Users loginDao(String uname, String upwd) throws Exception;
}
