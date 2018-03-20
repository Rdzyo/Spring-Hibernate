package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.excludeGetterAndSetter()")
	public void beforeAccountAdvice() {
		System.out.println("\n=========>>> Executing @Before advice on method");
	}
		
}
