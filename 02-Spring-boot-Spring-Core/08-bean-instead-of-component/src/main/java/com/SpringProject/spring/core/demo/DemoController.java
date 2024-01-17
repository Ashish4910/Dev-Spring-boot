package com.SpringProject.spring.core.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private coach mycoach;

	public DemoController(@Qualifier("SwimCoach") coach theCoach) {
		mycoach = theCoach;
		System.out.println("In Constructor : " + getClass().getSimpleName());
	}

	@GetMapping("/dailyworkout")
	public String getDailyworkout() {
		return mycoach.getDailyworkout();
	}

}
