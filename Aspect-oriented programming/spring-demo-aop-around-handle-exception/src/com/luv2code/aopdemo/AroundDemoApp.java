package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		// get the bean from the spring container
		TrafficFortuneService trafficFortune = 
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling Fortune");
		
		String data = trafficFortune.getFortune();
		
		System.out.println(data);
		
		System.out.println("Finished");
		// close the context
		context.close();
	}

}
