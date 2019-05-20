package com.mooop.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.mooop.sec.security.TokenAuthenticationProvider;
import com.mooop.sec.security.UsernamePasswordTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private TokenAuthenticationProvider tokenAuthenticationProvider;
	
	
	/**
	 * 인증필터 설정
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests()
			.antMatchers("/login/**").permitAll()
			.antMatchers("/logout/**").permitAll()
			.antMatchers("/db/**").permitAll()
			.antMatchers("/admin/test/**").permitAll()
			.antMatchers("/admin/registery/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").access("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')")
			.antMatchers("/default/**").access("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER') or hasRole('GUEST')")
			.antMatchers("/main/**").permitAll()
			.antMatchers("/**").permitAll()
			.and().csrf();

		
		http.logout()
					.logoutSuccessUrl("/login")
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID");
		
		/**
		 * Custom Filter 적용
		 * 
		 *  - Login 기능을 Spring Securit에서 제공하는 UsernamePasswordAuthenticationFilter 대신에
		 *    Custom한 UsernamePasswordTokenAuthenticationFilter를 사용한다.
		 *    
		 */
		http.addFilterAt(usernamePasswordTokenAuthenticationFilter()
				, UsernamePasswordTokenAuthenticationFilter.class);
		
	}
	
	/**
	 * AuthenticationManager 설정
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(tokenAuthenticationProvider);
	}
	
	/**
	 * Custom Filter를 Bean으로 생성
	 * @return
	 */
	@Bean
	public UsernamePasswordTokenAuthenticationFilter usernamePasswordTokenAuthenticationFilter() throws Exception {
		UsernamePasswordTokenAuthenticationFilter filter =  new UsernamePasswordTokenAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		
		/**
		 * login진행 IF지정.
		 * 
		 * */
		filter.setFilterProcessesUrl("/loginproc");
		filter.setUsernameParameter("username");
		filter.setPasswordParameter("password");
		filter.afterPropertiesSet();
		
		return filter;
		
		
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
