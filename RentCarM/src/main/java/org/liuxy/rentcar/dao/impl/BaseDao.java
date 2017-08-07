package org.liuxy.rentcar.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.liuxy.rentcar.entity.Page;
import org.liuxy.util.DBConfig;
import org.liuxy.util.DBManager;

public class BaseDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	/**
	 * @return the preparedStatement
	 */
	
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	
	
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
		
		// Context context = null;
		
		// Class.forName(driver);
		// this.connection = DriverManager.getConnection(URL, user, passwd);
		// context = new InitialContext();
		// DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/rentCar");
		// connection = dataSource.getConnection();
		connection = DBManager.getConn();
		
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public ResultSet dataQuery(String SQL, Object...parameters) {
		try {
			if (this.connection == null || this.connection.isClosed()) {
				this.connection = this.getConnection();
			}
			
			this.preparedStatement = this.connection.prepareStatement(SQL);
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
	
	public ResultSet dataQueryByCondition(String SQL, HashMap<String, List<String>> condition, HashMap<String, List<String>> section, Page<?> page, List<String> orderBy) {
		try {
			StringBuffer sqlB = new StringBuffer(SQL);
			
			List<String> parameters = null;
			
			if (condition != null && !condition.isEmpty()) {
				for (String conditionString : condition.keySet()) {
					parameters = condition.get(conditionString);
					
					sqlB.append(" and ( 1 = 0 ");
					for (int i = 0; i < parameters.size(); i++) {
						sqlB.append(" or " + conditionString + " = ? ");
					}
					sqlB.append(" ) ");
				}
			}
			
			if (section != null && !section.isEmpty()) {
				for (String sectionString : section.keySet()) {
					parameters = section.get(sectionString);
					if (Integer.parseInt(parameters.get(0)) != 0) {
						sqlB.append(" and " + sectionString + " >= ? ");
					}
					if (Integer.parseInt(parameters.get(1)) != 0) {
						sqlB.append(" and " + sectionString + " <= ? ");
					}
				}
			}
			
			if (orderBy != null && !orderBy.isEmpty()) {
				sqlB.append(" order by ");
				for (int i = 0; i < orderBy.size(); i++) {
					if (i == 0) {
						sqlB.append(orderBy.get(i));
					} else {
						sqlB.append( ", " + orderBy.get(i));
					}
				}
			}
			
			if (page != null && page.getCount() > 0) {
				sqlB.append(" limit ?, ? ");
			}
			
			System.out.println(sqlB.toString());
			
			if (this.connection == null || this.connection.isClosed()) {
				this.connection = this.getConnection();
			}
			
			this.preparedStatement = this.connection.prepareStatement(sqlB.toString());
			
			int j = 1;
			
			if (condition != null && !condition.isEmpty()) {
				for (String conditionString : condition.keySet()) {
					parameters = condition.get(conditionString);
					for (int i = 0; i < parameters.size(); i++) {
						this.preparedStatement.setObject(j, parameters.get(i));
						j++;
					}
				}
			}
			
			if (section != null && !section.isEmpty()) {
				for (String sectionString : section.keySet()) {
					parameters = section.get(sectionString);
					if (Integer.parseInt(parameters.get(0)) != 0) {
						this.preparedStatement.setObject(j, Double.parseDouble(parameters.get(0)));
						j++;
					}
					if (Integer.parseInt(parameters.get(1)) != 0) {
						this.preparedStatement.setObject(j, Double.parseDouble(parameters.get(1)));
						j++;
					}
				}
			}
			
			if (page != null && page.getCount() > 0) {
				this.preparedStatement.setObject(j, page.getBeginIndex());
				this.preparedStatement.setObject(j + 1, page.getPageSize());
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
			if (this.connection == null || this.connection.isClosed()) {
				this.connection = this.getConnection();
			}
			
			this.preparedStatement = this.connection.prepareStatement(SQL);
			for (int i = 0, j = 0; i < parameters.length; i++) {
				if (parameters[i] != null) {
					j = j + 1;
					this.preparedStatement.setObject((j), parameters[i]);
				}
			}
			rowNumber = this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowNumber;
	}
	
	public void commitData() {
		try {
			this.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
	}
	
	public void rollbackData() {
		try {
			this.connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
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
