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
 * Servlet implementation class ModifyStudentController
 */
@WebServlet("/ModifyStudentController")
public class ModifyStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService  modifyStudent = new StudentServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 查询要修改的数据
		String sid = request.getParameter("sid");
		try {
			// 调用service方法
			Student student = modifyStudent.getModifyStudent(sid);
			// 保存返回数据
			request.setAttribute("student", student);
			// 页面跳转
			request.getRequestDispatcher("modify.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取修改数据
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String ssex = request.getParameter("ssex");
		String sphone = request.getParameter("sphone");
		
		try {
			Student stu = new Student();
			stu.setSid(Integer.parseInt(sid));
			stu.setSname(sname);
			stu.setSage(sage);
			stu.setSsex(ssex);
			stu.setSphone(sphone);
			modifyStudent.modifyStudent(stu);
			// 由于修改后数据消失，在返回数据
			request.setAttribute("student", stu);
			request.setAttribute("message", "Modify Successfully");
			request.getRequestDispatcher("modify.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "Modify Failed");
			request.getRequestDispatcher("modify.jsp").forward(request, response);
		}
	}

}
