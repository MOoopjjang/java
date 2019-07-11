package com.mooop.def.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mooop.def.dao.UserInfo;
import com.mooop.def.model.UserParamVo;


@Transactional
@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private UserInfo userInfo;

	@Override
	public List<Map<String, Object>> getAllUserInfo() throws Exception{
		return userInfo.getAllUserInfo();
	}

	
	/**
	 *   Cache를 적용한다.
	 *    - config/ehcache.xml
	 *    
	 *    <cache name="userCache"
     *      eternal="false"
     *      timeToIdleSeconds="10"
     *      timeToLiveSeconds="10"
     *      overflowToDisk="false"
     *      diskPersistent="false"
     *      diskExpiryThreadIntervalSeconds="120"
     *      memoryStoreEvictionPolicy="LRU">
     *      
	 */
	@Cacheable(value = "userInfoCache"  , key = "#name+#age")
	@Override
	public Map<String, Object> getUserInfo(String name, int age) throws Exception {
		UserParamVo param = new UserParamVo();
		param.setName(name);
		param.setAge(age);
		return userInfo.getUserInfo(param);
	}

	/**
	 *   Cache를 적용한다.
	 *    - userInfoCache에서 삭제된 사용자 정보를 제거한다
	 *    
	 *   Transaction 적용  
     *      
	 */
	@Transactional( propagation = Propagation.REQUIRED)
	@CacheEvict(value = "userInfoCache" , key = "#name+#age")
	@Override
	public void deleteUserInfo(String name, int age) throws Exception {
		UserParamVo param = new UserParamVo();
		param.setName(name);
		param.setAge(age);
		userInfo.deleteUserInfo(param);
	}

}
