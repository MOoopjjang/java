package com.mooop.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mooop.sec.service.AuthenticationUserDetailService;
import com.mooop.sec.service.SecAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private SecAuthenticationProvider secAuthenticationProvider;
	
	@Autowired
	private AuthenticationUserDetailService authenticationUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
								.antMatchers("/login/**").permitAll()
								.antMatchers("/logout/**").permitAll()
								.antMatchers("/db/**").permitAll()
								.antMatchers("/admin/**").hasRole("ADMIN")
								.antMatchers("/main/**").access("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')")
								.antMatchers("/**").permitAll()
								.and().csrf();
		
		http.formLogin().loginPage("/login")
						.usernameParameter("username")
						.passwordParameter("password")
						.loginProcessingUrl("/loginproc")
						.defaultSuccessUrl("/main")
						.failureUrl("/loginfail")
						.and()
						.logout()
						.logoutSuccessUrl("/login")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID");
		
	}
	
	
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.authenticationProvider(secAuthenticationProvider);
	  auth.authenticationProvider(daoAuthenticationProvider());
  }
  
  
  @Bean(name="passwordEncoder")
  public BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
  }
  
  @Bean(name="daoAuthenticationProvider")
  public DaoAuthenticationProvider daoAuthenticationProvider() {
	  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	  provider.setPasswordEncoder(passwordEncoder());
	  provider.setUserDetailsService(authenticationUserDetailService);
	  provider.setHideUserNotFoundExceptions(false);
	return provider;
	  
  }
  
  
}
