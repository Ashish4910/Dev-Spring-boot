package com.SpringProject.spring.core.demo;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements coach {

	@Override
	public String getDailyworkout() {

		return "Track for some mile";
	}

}
