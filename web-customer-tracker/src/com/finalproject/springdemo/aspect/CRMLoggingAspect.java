package com.finalproject.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	//setup pointcut declarations
	@Pointcut("execution (* com.finalproject.springdemo.controller.*.*(..))")
	private void pCControllerPackage(){}
	@Pointcut("execution (* com.finalproject.springdemo.service.*.*(..))")
	private void pCServicePackage(){}
	@Pointcut("execution (* com.finalproject.springdemo.dao.*.*(..))")
	private void pCDaoPackage(){}
	@Pointcut("pCControllerPackage() || pCServicePackage() || pCDaoPackage()")
	private void pCForLoggin(){}
	
	//add @before advice
	@Before("pCForLoggin()")
	public void beforeLoggin (JoinPoint theJoinPoint){
		
		//display method
		String whereAmI = theJoinPoint.getSignature().toShortString();
		myLogger.info("Running @Before advice, calling method: "+ whereAmI);
		
		//diplay arguments
		Object[] args = theJoinPoint.getArgs();
		
		for (Object a : args)
			myLogger.info("Argument: "+ a);
		
		
	}
	//add @afterReturning advice
	@AfterReturning(pointcut="pCForLoggin()",
					returning="result")
	public void afterLoggin(JoinPoint theJoinPoint, Object result){
		
		//diplay method 
		String whereAmI = theJoinPoint.getSignature().toShortString();
		myLogger.info("Running @AfterReturning advice, calling method: "+ whereAmI);
		// display the data returned
		myLogger.info("the result:" + result);
	}
}
