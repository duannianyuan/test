package com.project.student.service;

import com.project.student.pojo.Users;

public interface LoginUsers {
	/**
	 * 获取dao层返回的用户名和密码作为一个对象
	 * @param uname
	 * @param upwd
	 * @return
	 * @throws Exception
	 */
	public Users login(String uname, String upwd) throws Exception;
}
