package com.ljk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LjkDeviceCallCenterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(LjkDeviceCallCenterApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(LjkDeviceCallCenterApplication.class);
	}
}
