package com.SpringProject.spring.core.demo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements coach {

	public TennisCoach() {
		System.out.println("In Constructor : "+getClass().getSimpleName());
	}

	@Override
	public String getDailyworkout() {
		return "Tennis is best game to play with Friends ";
	}
}
