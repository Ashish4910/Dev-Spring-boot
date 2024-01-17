package com.SpringProject.spring.core.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements coach {

	public BaseballCoach() {
		System.out.println("In Constructor : " + getClass().getSimpleName());
	}

	@Override
	public String getDailyworkout() {
		return "practice baseball 30 min a day";
	}
}
