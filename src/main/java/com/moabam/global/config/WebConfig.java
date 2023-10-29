package com.moabam.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";
	private static final String ALLOW_ORIGIN_PATTERN = "[a-z]+\\.moabam.com";
	private static final String ALLOW_LOCAL_HOST = "http://localhost:3000";

	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOriginPatterns(ALLOW_ORIGIN_PATTERN, ALLOW_LOCAL_HOST)
			.allowedMethods(ALLOWED_METHOD_NAMES.split(","))
			.allowedHeaders("*")
			.allowCredentials(true)
			.maxAge(3600);
	}
}