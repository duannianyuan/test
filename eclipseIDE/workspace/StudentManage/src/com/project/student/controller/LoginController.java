package com.project.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.student.pojo.Users;
import com.project.student.service.LoginUsers;
import com.project.student.service.impl.LoginUsersImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 调用service层数据，获取service提供的登录数据，用户名和密码
	LoginUsers loginUsers = new LoginUsersImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户输入的登录信息
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		// 调用service层数据
		try {
			Users users = loginUsers.login(uname, upwd);
			System.out.println(users);
			if(users.getUname()!=null && users.getUname()!="") {
				// 将对象存入session中
				request.getSession().setAttribute("users", users);
				response.sendRedirect("SelectController");
			}else {
				request.setAttribute("message", "密码和账户错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
