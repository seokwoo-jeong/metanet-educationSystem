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

	@Autowired
	LoginService loginService;
	
	

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 허용되어야 할 경로들
		web.ignoring().antMatchers("/resources/**", "/dist/**", "/css/**", "/font-awesome/**", "/fonts/**", "/img/**",
				"/js/**","/favicon.ico", "/error");
	}


	protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/checkLogin", "/","/doLogout").permitAll()
	        .antMatchers("/admin/**").hasRole("2")
	        .antMatchers("/professor/**").hasRole("1")
	        .antMatchers("/student/**").hasRole("0")
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
			.logoutSuccessUrl("/");
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