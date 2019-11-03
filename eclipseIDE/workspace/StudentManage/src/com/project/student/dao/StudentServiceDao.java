package com.project.student.dao;

import java.util.List;

import com.project.student.pojo.Student;

public interface StudentServiceDao {
	// 添加数据
	public int addStudentDao(Student student) throws Exception;
	// 查询数据
	public List<Student> selectStudentDao(Student student) throws Exception;
	// 删除数据
	public int delStudentDao(String sid) throws Exception;
	// 获取待修改数据
	public Student getModifyStudentDao(String sid) throws Exception;
	// 修改数据
	public int modifyStudentDao(Student student) throws Exception;
}
