package com.mooop.def.config;

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
	
	@Value("${mysql.driverClassName}")
	private String driverClassName;
	
	@Value("${mysql.username}")
	private String username;
	
	@Value("${mysql.password}")
	private String password;
	
	
	@Bean(name = "dataSource"  , destroyMethod = "postDeregister")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		/* Connection count */
		dataSource.setInitialSize(10);
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(10);
		
		
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(false);
		dataSource.setValidationQuery("SELECT 1 FROM DUAL");
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(6*1000);
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxOpenPreparedStatements(10);
		dataSource.setRemoveAbandonedOnBorrow(true);
		dataSource.setRemoveAbandonedTimeout(60);
		
		return dataSource;
	}
	

}
