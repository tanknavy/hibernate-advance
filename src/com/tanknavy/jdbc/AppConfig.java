package com.tanknavy.jdbc;

import com.typesafe.config.Config;

public class AppConfig {
	
	private final String jdbcUrl;
	private final String user;
	private final String password;
	private final String topic;
	
	public AppConfig(Config config) {
		
		//super();
		this.topic = config.getString("kafka.topic");
		this.jdbcUrl = config.getString("jdbc.url");
		this.user = config.getString("jdbc.user");
		this.password = config.getString("jdbc.pass");

	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getTopic() {
		return topic;
	}
	
	
	
	
	
}
