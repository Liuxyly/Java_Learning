package org.liuxy.rentcar.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.liuxy.util.DBConfig;

public class BaseDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
//	private String URL = "jdbc:mysql://localhost:3306/myschool?useUnicode=true&characterEncoding=utf-8&useSSL=false";
//	private String user = "root";
//	private String passwd = "3.1415926";
//	private String driver = "com.mysql.jdbc.Driver";
	
	private String URL = DBConfig.getInstance().getProperty("URL");
	private String user = DBConfig.getInstance().getProperty("user");
	private String passwd = DBConfig.getInstance().getProperty("passwd");
	private String driver = DBConfig.getInstance().getProperty("driver");
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(URL, user, passwd);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.connection;
	}
	
	public ResultSet dataQuery(String SQL, Object...parameters) {
		try {
			this.preparedStatement = this.getConnection().prepareStatement(SQL);
			for (int i = 0, j = 0; i < parameters.length; i++) {
				if (parameters[i] != null) {
					j = j + 1;
					this.preparedStatement.setObject(j, parameters[i]);
				}
			}
			this.resultSet = this.preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.resultSet;
	}
	
	public int dataUpdate(String SQL, Object...parameters) {
		int rowNumber = 0;
		try {
			this.preparedStatement = this.getConnection().prepareStatement(SQL);
			for (int i = 0, j = 0; i < parameters.length; i++) {
				if (parameters[i] != null) {
					j = j + 1;
					this.preparedStatement.setObject((j), parameters[i]);
				}
			}
			int i = 0;
			for (Object object : parameters) {
				this.preparedStatement.setObject((i + 1), object);
			}
			
			rowNumber = this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.closeAll();
		return rowNumber;
	}
	/**
	 * 按照顺序关闭资源 
	 * 
	 */
	public void closeAll() {
		try {
			if (this.resultSet != null) {
				this.resultSet.close();
			}
			if (this.preparedStatement != null) {
				this.preparedStatement.close();
			}
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
