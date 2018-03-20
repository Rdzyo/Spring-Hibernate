package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		// call the bussiness method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		// call the accountDAO getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
		// close the context
		context.close();
	}

}
