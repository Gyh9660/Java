package com.springbook.biz.common;

public class AfterThrowingAdvice {
	//예외가 발생되었을때 작동되는 Advice
	public void exceptionLog() {
		System.out.println(" [  예 외  처 리 ]  -  비 즈 니 스  로 직  처 리 중  예 외  발 생 ");
	}
}
