package com.SpringProject.spring.core.demo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements coach {
	
	public CricketCoach() {
		System.out.println("In Constructor : "+getClass().getSimpleName());
	}
	@Override
	public String getDailyworkout(){
		return "practice 15 page a days";
	}
}
