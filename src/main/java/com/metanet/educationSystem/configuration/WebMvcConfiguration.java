package com.metanet.educationSystem.configuration;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

public class WebMvcConfiguration implements WebMvcConfigurer{

	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("UTF-8"); //encoding UTF-8
		commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024); // 5MB restrict
		return commonsMultipartResolver;
	}
}
