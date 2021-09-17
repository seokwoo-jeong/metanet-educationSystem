package com.metanet.educationSystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.metanet.educationSystem.service.login.LoginService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 허용되어야 할 경로들
		web.ignoring().antMatchers("/resources/**", "/dist/**", "/css/**", "/font-awesome/**", "/fonts/**", "/img/**",
				"/js/**","/favicon.ico", "/error");
	}

	@Autowired
	LoginService loginService;
	
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/checkLogin", "/doLogin").permitAll()
//            .antMatchers("/admin/**").hasRole("ADMIN")
//            .antMatchers("/student/**").hasRole("STUDENT")
//            .antMatchers("/professor/**").hasRole("PROFESSOR")
//            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/checkLogin").loginProcessingUrl("/doLogin")
				.usernameParameter("memberNO")
				.passwordParameter("memberPassword")
				.defaultSuccessUrl("/LoginSuccess")
				.failureUrl("/LoginFail")
				.and().httpBasic();
	}
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("인증");
        auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
        System.out.println(auth);
        System.out.println("인증완료");
    }

}