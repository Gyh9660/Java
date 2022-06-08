package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

	//비지니스 로직 실행전, 실행후 작동
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("[Before] : 비지니스 로직 실행 전 처리");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[After] : 비지니스 로직 실행 후 처리");
		
		return returnObj;
	}
}
