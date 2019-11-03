package com.project.student.service.impl;

import com.project.student.dao.LoginUsersDao;
import com.project.student.dao.impl.LoginUsersDaoImpl;
import com.project.student.pojo.Users;
import com.project.student.service.LoginUsers;

public class LoginUsersImpl implements LoginUsers {
	
	LoginUsersDao loginUsersDao = new LoginUsersDaoImpl();
	
	@Override
	public Users login(String uname, String upwd) throws Exception {
		// 调用dao层数据库数据
		Users user = loginUsersDao.loginDao(uname, upwd);
		return user;
	}

}
