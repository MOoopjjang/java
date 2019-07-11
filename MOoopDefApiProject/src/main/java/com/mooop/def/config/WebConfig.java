package com.mooop.def.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mooop.def.interceptor.LoggingInterceptor;


/**
 * 
 * 
 * 
 * @author MOoop
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	
	/**
	 *  Interceptor 설정
	 *   - 등록한 순서대로 적용된다.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggingInterceptor()).addPathPatterns("/member/**");
	}
	
	
	/**
	 * logging Interceptor 반환
	 * @return
	 */
	@Bean
	public HandlerInterceptor loggingInterceptor() {
		return new LoggingInterceptor();
	}
	
	
	
	/**
	 *  Worker Thread Pool 설정
	 *  
	 * @return
	 */
	@Bean(name = "syncThreadPoolTaskExecutor")
	public ThreadPoolTaskExecutor poolTaskExecutor() {
		ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();
		tpte.setCorePoolSize(2);
		tpte.setMaxPoolSize(10);
		tpte.setQueueCapacity(20);
		tpte.setThreadNamePrefix("syncThreadPoolTaskExecutor=>");
		tpte.initialize();
		return tpte;
	}
	
	
}
