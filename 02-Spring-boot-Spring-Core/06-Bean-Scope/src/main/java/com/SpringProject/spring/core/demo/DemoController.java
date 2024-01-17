package com.SpringProject.spring.core.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private coach mycoach;
	private coach anotherCoach;

	public DemoController(@Qualifier("cricketCoach") coach theCoach, @Qualifier("cricketCoach") coach theanotherCoach) {
		mycoach = theCoach;
		anotherCoach = theanotherCoach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyworkout() {
		return mycoach.getDailyworkout();
	}

	@GetMapping("/check")
	public String workout() {
		return "Check successfully here is the result :- " + (mycoach == anotherCoach);
	}
}
