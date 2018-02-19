package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SkiCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Ski 10km today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
