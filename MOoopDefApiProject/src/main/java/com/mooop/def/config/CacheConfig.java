package com.mooop.def.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


/**
 * 
 * EHCache Config 파일
 * 
 * @author MOoop
 *
 */
@Configuration
@EnableCaching
public class CacheConfig {
	
	
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
		bean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
		bean.setShared(true);
		return bean;
	}
	
	
	@Bean
	public EhCacheCacheManager ehCacheManager(EhCacheManagerFactoryBean fb) {
		EhCacheCacheManager manager = new EhCacheCacheManager();
		manager.setCacheManager(fb.getObject());
		return manager;
	}

}
