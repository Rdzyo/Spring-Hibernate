package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forGetterMethods() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forSetterMethods() {}
	
	@Pointcut("forDaoPackage() && !(forGetterMethods() || forSetterMethods())")
	private void excludeGetterAndSetter() {}
	
	@Before("excludeGetterAndSetter()")
	public void beforeAccountAdvice() {
		System.out.println("\n=========>>> Executing @Before advice on method");
	}
	
	@Before("excludeGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=========>>> Performing API analytics");
	}
}
