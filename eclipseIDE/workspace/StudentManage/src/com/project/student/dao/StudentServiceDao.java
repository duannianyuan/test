package com.project.student.dao;

import java.util.List;

import com.project.student.pojo.Student;

public interface StudentServiceDao {
	// �������
	public int addStudentDao(Student student) throws Exception;
	// ��ѯ����
	public List<Student> selectStudentDao(Student student) throws Exception;
	// ɾ������
	public int delStudentDao(String sid) throws Exception;
	// ��ȡ���޸�����
	public Student getModifyStudentDao(String sid) throws Exception;
	// �޸�����
	public int modifyStudentDao(Student student) throws Exception;
}
