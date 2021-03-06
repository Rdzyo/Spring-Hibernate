package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger =
				Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	
	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		// get the bean from the spring container
		TrafficFortuneService trafficFortune = 
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling Fortune");
		
		String data = trafficFortune.getFortune();
		
		myLogger.info(data);
		
		myLogger.info("Finished");
		// close the context
		context.close();
	}

}
