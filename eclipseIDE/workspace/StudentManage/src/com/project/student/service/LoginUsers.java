package com.project.student.service;

import com.project.student.pojo.Users;

public interface LoginUsers {
	/**
	 * ��ȡdao�㷵�ص��û�����������Ϊһ������
	 * @param uname
	 * @param upwd
	 * @return
	 * @throws Exception
	 */
	public Users login(String uname, String upwd) throws Exception;
}
