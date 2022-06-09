package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice2 {

	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
			//처리하는 메소드 이름을 알아올 수 있다.
		Object[] args = jp.getArgs();
			//메소드 호출에 어떤 값들을 사용했는지 알 수 있다.
			//메소드의 매개변수에 등록된 정보
		
		System.out.println("[사전 처리] " + method + "() - 메소드 정보 ");
		System.out.println("[사전 처리] ARGS 정보 - " + args[0].toString() );
		
	}
}
