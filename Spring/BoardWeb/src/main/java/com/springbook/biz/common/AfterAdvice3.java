package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice3 {
	//1. 포인트컷
		//외부 포인트컷 사용하기
	
	
	
	//2. 어드바이스 설정
	
	@After("PointCutCommon.getPointCut()")
	public void afterLog() {
		System.out.println("[ 사 후 처 리 OO] 비 지 니 스 로 직 수 행 후 작 동");
	}
}
