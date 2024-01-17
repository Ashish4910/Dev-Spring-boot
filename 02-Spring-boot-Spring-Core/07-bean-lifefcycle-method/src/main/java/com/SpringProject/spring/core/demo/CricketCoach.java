package com.SpringProject.spring.core.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component

public class CricketCoach implements coach {

	public CricketCoach() {
		System.out.println("In Constructor : " + getClass().getSimpleName());
	}

	@PostConstruct
	public void domystatupStuff() {
		System.out.println("do stuff " + getClass().getSimpleName());
	}

	@PreDestroy
	public void domyclean() {

		System.out.println("clean my stuff " + getClass().getSimpleName());
	}

	@Override
	public String getDailyworkout() {
		return "practice 15 page a days";
	}

}
