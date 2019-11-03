package com.project.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.student.pojo.Student;
import com.project.student.service.StudentService;
import com.project.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class SelectController
 */
@WebServlet("/SelectController")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService  selectStudent = new StudentServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectController() {
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
		try {
			// ��ȡ������ѯ��ֵ
			String sname = request.getParameter("sname");
			Student student = new Student();
			student.setSname(sname);
			// ����service�㷽��
			List<Student> list = selectStudent.selectStudent(student);
			System.out.println("list:"+list);
			request.setAttribute("list", list);
			// ��תҳ��
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
