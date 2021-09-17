package com.metanet.educationSystem.configuration;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import com.metanet.educationSystem.controller.LoginFailHandler;
import com.metanet.educationSystem.controller.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 허용되어야 할 경로들
		web.ignoring().antMatchers("/resources/**", "/dist/**", "/css/**", "/font-awesome/**", "/fonts/**", "/img/**",
				"/js/**","/favicon.ico", "/error");
	}


	protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/checkLogin", "/").permitAll()
	        .antMatchers("/admin/**").hasAuthority("2")
	        .antMatchers("/professor/**").hasAuthority("1")
	        .antMatchers("/student/**").hasAuthority("0")
			.anyRequest().authenticated()
		.and().formLogin()
			.loginPage("/checkLogin").loginProcessingUrl("/doLogin")
			.usernameParameter("memberNO")
			.passwordParameter("memberPassword")
			.successHandler(new LoginSuccessHandler())
			.failureHandler(new LoginFailHandler())
			.failureForwardUrl("/loginFail")
		.and().logout()
			.logoutUrl("/doLogout")
			.logoutSuccessUrl("/").
		and()
		.exceptionHandling()
		.accessDeniedPage("/error.jsp");
	}
	
	
	// 해싱 패스워드
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	
//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("인증 Configure");		
//        auth.userDetailsService(loginService).passwordEncoder(loginService.passwordEncoder());
//        System.out.println(auth);
//    }

}