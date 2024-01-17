package com.SpringProject.spring.core.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SpringProject.spring.core.demo.SwimCoach;
import com.SpringProject.spring.core.demo.coach;

@Configuration
public class SportConfig {

	@Bean
	public coach SwimCoach() {
		return new SwimCoach();
	}

}
