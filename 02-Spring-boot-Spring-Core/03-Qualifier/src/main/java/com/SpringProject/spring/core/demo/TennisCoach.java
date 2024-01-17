package com.SpringProject.spring.core.demo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach  implements coach{
	@Override
public String getDailyworkout() {
	return "Tennis is best game to play with Friends ";
}
}
