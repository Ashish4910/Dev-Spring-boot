package com.SpringProject.spring.core.demo;

import org.springframework.stereotype.Component;

@Component
public class Cricket implements coach {
	@Override
	public String getDailyworkout(){
		return "practice 15 page a days";
	}
}
