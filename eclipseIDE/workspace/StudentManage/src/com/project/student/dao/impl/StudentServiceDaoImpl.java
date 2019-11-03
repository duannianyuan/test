package com.project.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.student.dao.StudentServiceDao;
import com.project.student.pojo.Student;
import com.project.student.utils.JDBCUtils;

public class StudentServiceDaoImpl implements StudentServiceDao {
	/**
	 * 添加数据
	 */
	@Override
	public int addStudentDao(Student student) throws Exception {
		// TODO Auto-generated method stub
		// 创建user
		// 创建数据库连接对象
		Connection connection = null;
		// 获取预编译对象
		PreparedStatement preSta = null;
		// 接受数据
		int result = 0;
		// 创建sql语句对象
		String sql = "insert into student values(null,?,?,?,?)";
		try {
			connection = JDBCUtils.getConnection();
			preSta = connection.prepareStatement(sql);
			// 给预编译进行赋值		
			preSta.setString(1, student.getSname());
			preSta.setString(2, student.getSage());
			preSta.setString(3, student.getSsex());
			preSta.setString(4, student.getSphone());
			result = preSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.getClose1(connection, preSta, null);
		}
		return result;
	}
	
	/**
	 * 查询数据
	 */
	@Override
	public List<Student> selectStudentDao(Student student) throws Exception {
		// TODO Auto-generated method stub
		// 创建数据库连接对象
		Connection connection = null;
		// 获取预编译对象
		PreparedStatement preSta = null;
		//
		ResultSet res = null;
		ArrayList<Student> array = new ArrayList<Student>();
		// 创建sql语句对象
		StringBuffer sql = new StringBuffer("select * from student where 1=1");
		try {
			connection = JDBCUtils.getConnection();
			// 给预编译进行赋值		
			if(student.getSname()!=null && !"".equals(student.getSname())) {
				sql.append(" and sname like ?");
			}
			preSta = connection.prepareStatement(sql.toString());
			if(student.getSname()!=null && !"".equals(student.getSname())) {
				// 
				preSta.setString(1, "%"+student.getSname()+"%");
			}
			res = preSta.executeQuery();
			while(res.next()) {
				Student stu = new Student();
				stu.setSid(res.getInt("sid"));
				stu.setSname(res.getString("sname"));
				stu.setSage(res.getString("sage"));
				stu.setSsex(res.getString("ssex"));
				stu.setSphone(res.getString("sphone"));
				array.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.getClose1(connection, preSta, null);
		}
		return array;
	}

	/**
	 * 删除数据
	 */
	@Override
	public int delStudentDao(String sid) throws Exception {
		// TODO Auto-generated method stub
		// 创建数据库连接对象
		Connection connection = null;
		// 获取预编译对象
		PreparedStatement preSta = null;
		//
		int i = 0;
		// 创建sql语句对象
		StringBuffer sql = new StringBuffer("DELETE FROM student where sid=?");
		try {
			connection = JDBCUtils.getConnection();
			preSta = connection.prepareStatement(sql.toString());
			preSta.setInt(1, Integer.parseInt(sid));
			i = preSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.getClose1(connection, preSta, null);
		}
		return i;
	}

	/**
	 * 获取待修改数据
	 */
	@Override
	public Student getModifyStudentDao(String sid) throws Exception {
		// TODO Auto-generated method stub
		// 创建数据库连接对象
		Connection connection = null;
		// 获取预编译对象
		PreparedStatement preSta = null;
		//
		ResultSet res = null;
		Student stu = new Student();
		// 创建sql语句对象
		StringBuffer sql = new StringBuffer("select * from student where 1=1 and sid=?");
		try {
			connection = JDBCUtils.getConnection();
			// 给预编译进行赋值		
			preSta = connection.prepareStatement(sql.toString());		
			preSta.setInt(1, Integer.parseInt(sid));
			res = preSta.executeQuery();
			while(res.next()) {
				stu.setSid(res.getInt("sid"));
				stu.setSname(res.getString("sname"));
				stu.setSage(res.getString("sage"));
				stu.setSsex(res.getString("ssex"));
				stu.setSphone(res.getString("sphone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.getClose1(connection, preSta, null);
		}
		return stu;
	}

	/**
	 * 修改数据
	 */
	@Override
	public int modifyStudentDao(Student student) throws Exception {
		// TODO Auto-generated method stub
		// 创建数据库连接对象
		Connection connection = null;
		// 获取预编译对象
		PreparedStatement preSta = null;
		//
		int i = 0;
		// 创建sql语句对象
		StringBuffer sql = new StringBuffer("update student set sname=?,sage=?,ssex=?,sphone=? where sid=?");
		try {
			connection = JDBCUtils.getConnection();
			preSta = connection.prepareStatement(sql.toString());
			preSta.setString(1, student.getSname());
			preSta.setString(2, student.getSage());
			preSta.setString(3, student.getSsex());
			preSta.setString(4, student.getSphone());
			preSta.setInt(5, student.getSid());
			i = preSta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtils.getClose1(connection, preSta, null);
		}
		return i;
	}
}
