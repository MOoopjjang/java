package com.mooop.sec.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:application.yml")
public class DatabaseConfig {
	
	@Value("${mysql.url}")
	private String url;
	@Value("${mysql.username}")
	private String username;
	@Value("${mysql.password}")
	private String password;
	@Value("${mysql.driverClassName}")
	private String driverClassName;
	
	
	
	@Bean(name="dataSource", destroyMethod="postDeregister")
	public DataSource dataSource() {
		
		BasicDataSource datasource = new BasicDataSource();
		
		datasource.setDriverClassName(driverClassName);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setUrl(url);
		
		return datasource;
		
	}

}
