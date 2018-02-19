package com.luv2code.spring.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkiCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;
	
	public SkiCoach() {
		
		System.out.println(">> SkiCoach: Inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Ski 10km today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
