/*
package com.shana.assignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String PasswordEncoder = "1234%%%";

	
	 @Override
	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		 auth
		 .inMemoryAuthentication()
		 .withUser("admin")
		 .password("shana")
		 .roles("")
		 
		 .and()
		 .withUser("shana")
		 .password(PasswordEncoder)
		 .roles("")
		 
		 .and()
		 .withUser("shana")
		 .password(PasswordEncoder)
		 .roles("");
		 
	 }
	 
	 @Override
	  public void configure(HttpSecurity http) throws Exception {
		 
		 http
		 .authorizeRequests()
		 .antMatchers("home.html")
		 .permitAll()
		 
		 .antMatchers("/get")
		 .authenticated()
		 
		 .antMatchers("/api/admin")
		 .hasRole("ADMIN");
		 
		 
	 }

}
*/
