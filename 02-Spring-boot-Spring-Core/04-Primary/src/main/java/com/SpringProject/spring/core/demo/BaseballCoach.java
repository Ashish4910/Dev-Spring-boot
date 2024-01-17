package com.SpringProject.spring.core.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements coach {
	@Override
	public String getDailyworkout() {
		return "practice baseball 30 min a day";
	}
}
