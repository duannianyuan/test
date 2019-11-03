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
	
	// ����service�����ݣ���ȡservice�ṩ�ĵ�¼���ݣ��û���������
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
		// ��ȡ�û�����ĵ�¼��Ϣ
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		// ����service������
		try {
			Users users = loginUsers.login(uname, upwd);
			System.out.println(users);
			if(users.getUname()!=null && users.getUname()!="") {
				// ���������session��
				request.getSession().setAttribute("users", users);
				response.sendRedirect("SelectController");
			}else {
				request.setAttribute("message", "������˻�����");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
