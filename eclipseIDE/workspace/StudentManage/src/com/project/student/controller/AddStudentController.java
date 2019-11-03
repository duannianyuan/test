package com.project.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.student.pojo.Student;
import com.project.student.service.StudentService;
import com.project.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentService addStudent = new StudentServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentController() {
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
		// 获取用户输入数据
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String ssex = request.getParameter("ssex");
		String sphone = request.getParameter("sphone");
		
		try {
			// 调用service层
			Student student = new Student();
			student.setSname(sname);
			student.setSage(sage);
			student.setSsex(ssex);
			student.setSphone(sphone);
			int num = addStudent.addStudent(student);
			if(num!=0) {
				request.setAttribute("message", " Add Successfully");
			}
			request.getRequestDispatcher("add.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "Add Failed");
			request.getRequestDispatcher("./").forward(request, response);
		}
	}

}
