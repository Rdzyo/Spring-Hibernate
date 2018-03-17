package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMember() {
		
		System.out.println(getClass() + ": ADDING MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public boolean goToSleep() {
		System.out.println(getClass() + ": Going to sleep");
		return true;
	}
}
