package com.sangavee.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/*public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest().authenticated()
			.and().httpBasic();
	}
	
	Login form
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest().authenticated()
			.and().formLogin()
			.and().httpBasic();
	}
	*/

	
	public void configure(HttpSecurity http) throws Exception {  
        http  
            .authorizeRequests()  
            .antMatchers( "/public/**").permitAll()  
            .anyRequest().authenticated()  
                .and()  
            .formLogin()  
                .loginPage("/login.html")  
                .failureUrl("/login-error.html")  
                .permitAll();  
    }
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("user1")
			.password("{noop}pass")
			.roles("user");
	}
	
}
