package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// create an array of strings

	private String[] randomFortune = {
			"Today is your lucky day!", 
			"May the luck be with you, always", 
			"Good luck!"
	};
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(randomFortune.length);
		return randomFortune[index];
	}

}
