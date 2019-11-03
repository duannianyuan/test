package com.project.student.service;

import java.util.List;

import com.project.student.pojo.Student;

public interface StudentService {
	// 添加数据
	public int addStudent(Student student) throws Exception;
	// 查询数据
	public List<Student> selectStudent(Student student) throws Exception;
	// 删除数据
	public int delStudent(String sid) throws Exception;
	// 获取待修改数据
	public Student getModifyStudent(String sid) throws Exception;
	// 修改数据
	public int modifyStudent(Student student) throws Exception;
}
