package com.project.student.utils;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


//import com.study.jdbc.dao.impl.JDBCUtils;

public class JDBCUtils {
	/**
	 * ��ȡ������Ϣ
	 */
	private static String jdbc_url;
	private static String jdbc_user;
	private static String jdbc_password;
	private static String jdbc_driver;
	
	/**
	 * ��ȡ�ļ��е�����
	 */
	static {
		// ����һ������
		Properties properties = new Properties();
		// ��ȡsrc·���µ�jdbc.properties�е�������Ϣ
		ClassLoader classLoader = JDBCUtils.class.getClassLoader();
		// ָ���ļ�
		URL url = classLoader.getResource("jdbc.properties");
		String path = url.getPath();
		// �����ļ�����ȡ����
		try {
			properties.load(new FileReader(path));
			// ��ȡ���ݲ���ֵ
			jdbc_url = properties.getProperty("jdbc_url");
			jdbc_user = properties.getProperty("jdbc_user");
			jdbc_password = properties.getProperty("jdbc_password");
			jdbc_driver = properties.getProperty("jdbc_driver");
			Class.forName(jdbc_driver);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ������Դ�Ķ���
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_password);
	}
	
	/**
	 * �ͷ���Դ
	 * @param connection ���Ӷ���
	 * @param statement  ִ�ж���
	 * @param resultSet  �������
	 * @throws SQLException
	 */
	public static void getClose(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if(resultSet != null) {
			// �رս����
			resultSet.close();
		}
		if(statement != null) {
			// �ر�SQL����
			statement.close();
		}
		if(connection != null) {
			// �ر����Ӷ���
			connection.close();
		}
	}
	
	
	/**
	 * 
	 * @param connection  ���Ӷ���
	 * @param preSta	     Ԥ�������    
	 * @param resultSet   �������       int
	 * @throws SQLException
	 */
	public static void getClose1(Connection connection, PreparedStatement preSta, ResultSet resultSet) throws SQLException {
		if(resultSet != null) {
			// �رս����
			resultSet.close();
		}
		if(preSta != null) {
			// �ر�SQL����
			preSta.close();
		}
		if(connection != null) {
			// �ر����Ӷ���
			connection.close();
		}
	}
	
	/**
	 * 
	 * @param connection   ���Ӷ���
	 * @param statement	   Ԥ�������1
	 * @param statement1   Ԥ�������2
	 * @throws SQLException
	 */
	public static void getClose2(Connection connection, PreparedStatement statement, PreparedStatement statement1) throws SQLException {
		if(statement1 != null) {
			// �رս����
			statement1.close();
		}
		if(statement != null) {
			// �ر�SQL����
			statement.close();
		}
		if(connection != null) {
			// �ر����Ӷ���
			connection.close();
		}
	}
}
