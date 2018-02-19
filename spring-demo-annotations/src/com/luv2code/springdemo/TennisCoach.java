package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// default constructor
	public TennisCoach() {
		System.out.println(">>Tennis Coach: Inside default constructor");
	}
	
	// define init method
	@PostConstruct
	public void doMyStuffOnStart() {
		System.out.println(">> Tennis Coach: Inside my doMyStuffOnStart()");
	}
	
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">> Tennis Coach: iniside my doMyCleanUpStuff()");
	}
	// define destroy method
	
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">>Tennis Coach: Inside setFortuneService() method");
		fortuneService = theFortuneService;
	}*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
