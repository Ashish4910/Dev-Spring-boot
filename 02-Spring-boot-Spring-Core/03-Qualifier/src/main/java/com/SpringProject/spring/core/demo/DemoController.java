package com.SpringProject.spring.core.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private coach mycoach;

	public DemoController(@Qualifier("tennisCoach") coach theCoach) {
		mycoach = theCoach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyworkout() {
		return mycoach.getDailyworkout();
	}
}
