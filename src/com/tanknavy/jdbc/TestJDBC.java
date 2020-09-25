package com.tanknavy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.typesafe.config.ConfigFactory;


public class TestJDBC {

	public static void main(String[] args) {
		
		//����resource�������src������ܱ�ɨ�赽
		AppConfig appConfig = new AppConfig(ConfigFactory.load("resources/application.conf"));
		//AppConfig appConfig = new AppConfig(ConfigFactory.load("application"));
		//Properties properties = new Properties();
		
		/* Ӳ����
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		//String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=PST";
		String user = "hbstudent";
		String pass = "hbstudent";
		*/
		//��Ĭ�������ļ�application.conf��ȡ,����ļ����Զ���packageͬһ��
		
		//String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&amp;serverTimezone=UTC";
		String jdbcUrl = appConfig.getJdbcUrl();
		String user = appConfig.getUser();
		String pass = appConfig.getPassword();
		
		//String topic = appConfig.getTopic();
		System.out.println(ClassLoader.getSystemResource("../resources/test.conf"));
		
		
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection sucessful!!!");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
