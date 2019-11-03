package com.project.student.service.impl;

import java.util.List;

import com.project.student.dao.StudentServiceDao;
import com.project.student.dao.impl.StudentServiceDaoImpl;
import com.project.student.pojo.Student;
import com.project.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	// 调用dao层
	StudentServiceDao addStudentDao = (StudentServiceDao) new StudentServiceDaoImpl();
	
	/**
	 * 添加数据
	 */
	@Override
	public int addStudent(Student student) throws Exception {
		System.out.println(student);
		// 分别判断数据是否为空
		if(student.getSname()!=null && !"".equals(student.getSname())) {
			return addStudentDao.addStudentDao(student);
		}
		if(student.getSage()!=null && !"".equals(student.getSage())) {
			return addStudentDao.addStudentDao(student);
		}
		if(student.getSsex()!=null && !"".equals(student.getSsex())) {
			return addStudentDao.addStudentDao(student);
		}
		if(student.getSphone()!=null && !"".equals(student.getSphone())) {
			return addStudentDao.addStudentDao(student);
		}
		return 0;
	}
	
	/**
	 * 查询数据
	 */
	@Override
	public List<Student> selectStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return addStudentDao.selectStudentDao(student);
	}

	/**
	 * 删除数据
	 */
	@Override
	public int delStudent(String sid) throws Exception {
		// TODO Auto-generated method stub
		return addStudentDao.delStudentDao(sid);
	}

	/**
	 * 获取待修改数据
	 */
	@Override
	public Student getModifyStudent(String sid) throws Exception {
		// TODO Auto-generated method stub
		return addStudentDao.getModifyStudentDao(sid);
	}

	@Override
	public int modifyStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return addStudentDao.modifyStudentDao(student);
	}

	

	

}
