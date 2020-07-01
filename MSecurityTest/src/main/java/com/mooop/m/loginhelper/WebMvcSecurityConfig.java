package com.mooop.m.loginhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.mooop.m.SomeFilter;

@Configuration
@EnableWebSecurity
public class WebMvcSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	SecAuthenticationProvider secAuthenticationProvider;
	
	@Autowired
	SomeFilter someFilter;
	
	boolean isSecurity = true;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if(!isSecurity) {
			http.csrf().disable().authorizeRequests().anyRequest().permitAll()
			.and()
			.cors().disable()
			.headers().frameOptions().sameOrigin();

		}else {
			http.headers().frameOptions().sameOrigin()
			.and()
			.authorizeRequests()
					.antMatchers("/main/**").hasRole("USER")
					.anyRequest().permitAll()
					.and().csrf().disable()
					.addFilterBefore(someFilter, BasicAuthenticationFilter.class)
					;
		
		
		http.formLogin().loginPage("/login")
						.usernameParameter("username")
						.passwordParameter("password")
						.loginProcessingUrl("/j_spring_security_check")
						.defaultSuccessUrl("/main/")
						.failureUrl("/loginfail")
						.and()
						.logout()
						.logoutUrl("/logout")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID");
		}
		
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(secAuthenticationProvider);
	}

}
