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
	 * 获取连接信息
	 */
	private static String jdbc_url;
	private static String jdbc_user;
	private static String jdbc_password;
	private static String jdbc_driver;
	
	/**
	 * 读取文件中的数据
	 */
	static {
		// 创建一个集合
		Properties properties = new Properties();
		// 获取src路径下的jdbc.properties中的数据信息
		ClassLoader classLoader = JDBCUtils.class.getClassLoader();
		// 指定文件
		URL url = classLoader.getResource("jdbc.properties");
		String path = url.getPath();
		// 加载文件并获取数据
		try {
			properties.load(new FileReader(path));
			// 获取数据并赋值
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
	 * 获取连接资源的对象
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_password);
	}
	
	/**
	 * 释放资源
	 * @param connection 连接对象
	 * @param statement  执行对象
	 * @param resultSet  结果对象
	 * @throws SQLException
	 */
	public static void getClose(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if(resultSet != null) {
			// 关闭结果集
			resultSet.close();
		}
		if(statement != null) {
			// 关闭SQL对象
			statement.close();
		}
		if(connection != null) {
			// 关闭连接对象
			connection.close();
		}
	}
	
	
	/**
	 * 
	 * @param connection  连接对象
	 * @param preSta	     预编译对象    
	 * @param resultSet   结果对象       int
	 * @throws SQLException
	 */
	public static void getClose1(Connection connection, PreparedStatement preSta, ResultSet resultSet) throws SQLException {
		if(resultSet != null) {
			// 关闭结果集
			resultSet.close();
		}
		if(preSta != null) {
			// 关闭SQL对象
			preSta.close();
		}
		if(connection != null) {
			// 关闭连接对象
			connection.close();
		}
	}
	
	/**
	 * 
	 * @param connection   连接对象
	 * @param statement	   预编译对象1
	 * @param statement1   预编译对象2
	 * @throws SQLException
	 */
	public static void getClose2(Connection connection, PreparedStatement statement, PreparedStatement statement1) throws SQLException {
		if(statement1 != null) {
			// 关闭结果集
			statement1.close();
		}
		if(statement != null) {
			// 关闭SQL对象
			statement.close();
		}
		if(connection != null) {
			// 关闭连接对象
			connection.close();
		}
	}
}
