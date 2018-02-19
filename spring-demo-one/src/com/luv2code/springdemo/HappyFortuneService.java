package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	private String[] randomFortune = {"Today is your lucky day!", "May the luck be with you, always", "It's time to get lucky!"};
	
	private Random rand = new Random();
	
	@Override
	public String getFortune() {
		int index = rand.nextInt(randomFortune.length);
		String theFortune = randomFortune[index];
		return theFortune;
	}

}
