package config;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DataBaseConfig {
	
	private Properties prop = null;
	
	private String mybatis_config_path = null;
	
	private SqlSession mFactorySession = null;
	
	public DataBaseConfig() {
		try {
			mybatis_config_path = "config/mybatis-config.xml";
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Singleton Instance
	 * @return
	 */
	public static DataBaseConfig getInstnace() {
		return LazyHolder.INSTANCE;
	}
	
	
	
	private SqlSessionFactory sqlSessionFactory() throws Exception{
		InputStream inputStream = Resources.getResourceAsStream(mybatis_config_path);
		SqlSessionFactory bean = new SqlSessionFactoryBuilder().build(inputStream);
		return bean;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public SqlSession openSqlSession() throws Exception{
		if(mFactorySession == null){
			SqlSessionFactory factory = sqlSessionFactory();
			mFactorySession = factory.openSession();
		}
		return mFactorySession;
	}
	
	
	/**
	 * Session을 close한다
	 */
	public void closeSqlSession(){
		if(mFactorySession != null){
			mFactorySession.close();
		}
		mFactorySession = null;
	}
	
	
	
	
	/**
	 * 
	 * @author mooopjjang
	 *
	 */
	private static class LazyHolder{
		private static final DataBaseConfig INSTANCE = new DataBaseConfig();
	}

}
