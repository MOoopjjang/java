package com.mooop.m;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer , WebMvcRegistrations{
	
//	@Autowired
//	SomeFilter someFilter;
//	
//	@Bean
//	public FilterRegistrationBean<OncePerRequestFilter> filter(){
//		FilterRegistrationBean frb = new FilterRegistrationBean();
//		frb.setFilter(someFilter);
//		frb.setUrlPatterns(Arrays.asList("/main/test"));
//		return frb;
//	}

}
