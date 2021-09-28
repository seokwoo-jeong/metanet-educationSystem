package com.metanet.educationSystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import com.metanet.educationSystem.controller.login.CommenceEntryPoint;
import com.metanet.educationSystem.controller.login.ForbiddenErrorHandler;
import com.metanet.educationSystem.controller.login.LoginFailHandler;
import com.metanet.educationSystem.controller.login.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CommenceEntryPoint unauthorizedHandler;
	@Autowired
	private ForbiddenErrorHandler forbiddenErrorHandler;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/dist/**", "/css/**", "/font-awesome/**", "/fonts/**", "/img/**",
				"/js/**","/favicon.ico", "/error","/incl/**","/plugins/**");
	}


	protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/checkLogin", "/").permitAll()
	        .antMatchers("/admin/**").hasAuthority("2")
	        .antMatchers("/noticeInsert").hasAnyAuthority("2","1")
	        .antMatchers("/professor/**").hasAuthority("1")
	        .antMatchers("/student/**").hasAuthority("0")
		.and().formLogin()
			.loginPage("/checkLogin").loginProcessingUrl("/doLogin")
			.usernameParameter("memberNO")
			.passwordParameter("memberPassword")
			.successHandler(new LoginSuccessHandler())
			.failureHandler(new LoginFailHandler())
		.and().logout()
			.logoutUrl("/doLogout")
			.logoutSuccessUrl("/")
		.and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		.accessDeniedHandler(forbiddenErrorHandler)
		.and().csrf().disable();
	}
	
	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	
//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("���� Configure");		
//        auth.userDetailsService(loginService).passwordEncoder(loginService.passwordEncoder());
//        System.out.println(auth);
//    }

}