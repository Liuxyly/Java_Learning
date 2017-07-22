package org.liuxy.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DBConfig {
	private static DBConfig dbConfig;
	private Properties properties = new Properties();
	
	private DBConfig() {
		
		String file = "db.properties";
		try ( InputStream is = DBConfig.class.getClassLoader().getResourceAsStream(file) ) {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	static public DBConfig getInstance(){
		if (dbConfig == null) {
			dbConfig = new DBConfig();
		}
		return dbConfig;
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public Date getDateByFormat(String dateStr, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			// 把dateStr转换为date类
			date = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			System.err.println("日期格式或者日期不正确");
			e.printStackTrace();
		}
		
		return date;
	}
	
}
