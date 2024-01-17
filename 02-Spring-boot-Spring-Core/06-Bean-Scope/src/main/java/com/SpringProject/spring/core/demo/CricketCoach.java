package com.SpringProject.spring.core.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements coach {
	
	public CricketCoach() {
		System.out.println("In Constructor : "+getClass().getSimpleName());
	}
	@Override
	public String getDailyworkout(){
		return "practice 15 page a days";
	}
}
