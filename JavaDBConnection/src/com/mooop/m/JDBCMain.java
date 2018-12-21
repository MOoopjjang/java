package com.mooop.m;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mooop.svc.AuthService;
import com.mooop.svc.AuthServiceImpl;

import config.DataBaseConfig;


/**
 * Java Client Application에서 MYSQL 연동
 *  - java + Mybatis + MySQL
 * 
 * @ref http://www.mybatis.org/mybatis-3/ko/getting-started.html
 * @author mooopjjang
 *
 */
public class JDBCMain {
	
	private static void tSelectOne(AuthService service , String userid) throws Exception{
		Map<String , Object> r = service.getUserAuthInfo(userid);
		Iterator<String> iter = r.keySet().iterator();
		
		while(iter.hasNext()){
			String key = iter.next();
			String v = (String)r.get(key);
			System.out.println("k : "+key+" , v : "+v);
		}
	}
	
	
	private static void tSelectAll(AuthService service) throws Exception{
		List<Map<String , Object>> rl = service.getAllUserAuthInfo();
		for(Map<String , Object> m:rl){
			System.out.println("==========================================");
			Iterator<String> iter = m.keySet().iterator();
			
			while(iter.hasNext()){
				String key = iter.next();
				String v = (String)m.get(key);
				System.out.println("k : "+key+" , v : "+v);
			}
		}
	}
	
	
	private static void tInsertOne(AuthService service) throws Exception{
		Map<String , Object> insertM = new HashMap<String , Object>();
		insertM.put("userid", "abc");
		insertM.put("password", "1111");
		insertM.put("role", "USER");
		service.insertUserInfo(insertM);
	}
	
	
	private static void tDeleteOne(AuthService service , String userid) throws Exception{
		service.deleteUserInfo(userid);
	}
	
	
	
	private static void testDBConnection(){
		SqlSession session = null;
		AuthServiceImpl authService = null;
		try{
			session = DataBaseConfig.getInstnace().openSqlSession();
			authService = new AuthServiceImpl(session);
			
			tSelectOne(authService , "bhkim");
			
			tSelectAll(authService);		
			
			tInsertOne(authService);
			
			tDeleteOne(authService , "abc");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseConfig.getInstnace().closeSqlSession();
		}
	}

	public static void main(String[] args) {
	
		testDBConnection();

	}

}
