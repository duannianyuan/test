package com.project.student.service;

import java.util.List;

import com.project.student.pojo.Student;

public interface StudentService {
	// �������
	public int addStudent(Student student) throws Exception;
	// ��ѯ����
	public List<Student> selectStudent(Student student) throws Exception;
	// ɾ������
	public int delStudent(String sid) throws Exception;
	// ��ȡ���޸�����
	public Student getModifyStudent(String sid) throws Exception;
	// �޸�����
	public int modifyStudent(Student student) throws Exception;
}
