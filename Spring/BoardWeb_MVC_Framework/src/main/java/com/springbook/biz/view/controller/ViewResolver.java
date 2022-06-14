package com.springbook.biz.view.controller;

public class ViewResolver {
	//Controller에서 리턴받은값 (view페이지/확장자뺴고줌)을	확장자를 완성해서 처리

	public String prefix; //리턴 받아오는 이름 앞에 처리할 변수
	public String suffix; //리턴 받아오는 이름 뒤에 처리할 변수
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix){
		this.suffix = suffix;
	}
	
	public String getView (String viewName) { //뷰 페이지이름을 완성해서 돌려줌
		return prefix + viewName + suffix;
	}
	
}
