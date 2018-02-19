package com.luv2code.springdemo;

public class SkiCoach implements Coach {

private FortuneService fortuneService;
	
	
	public SkiCoach(FortuneService fortuneService) {
		//super();
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Ski through giant slalom twice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it " + fortuneService.getFortune();
	}

}
