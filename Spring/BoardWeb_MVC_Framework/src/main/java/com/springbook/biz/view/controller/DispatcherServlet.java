package com.springbook.biz.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//DispatcherServlt의 MVC M2의 단점.
	//하나의 컨트롤러(Controller)에서 클라이언트(Client)의 모든 요청을 처리하고 있다.
	//구문이 엄청 복잡해지고 내용의 수정,반복~?
	//테이블이 늘어나거나 부하가 Controller의 부하가 굉장히 많이 발생
	//구문이 광징히 길어지고 복잡해진다. 해당 메소드를 찾기도 힘들다.

//Controller의 부하를 분산 처리 하는 것이 MVC 프레임워크, Spring MVC


//@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping; // 객체 변수 선언
	private ViewResolver viewResolver; // 개겣 변수 선언
	
	//HttpServlet 클래스의 init() 메소드 재정의, :톰캣 서버 시작될때 init 메소드가 호출됨
		//init()메소드는 초기값을 설정을 하는 메소드
	
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("톰캣 서비스 시작시 호출");
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
	
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에서 Get 방식으로 들어오는 모든 요청을 process 메소드에서 처리하도록 던져준다
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에서 Get 방식으로 들어오는 모든 요청을 process 메소드에서 처리하도록 던져준다

		request.setCharacterEncoding("EUC-KR");
		process(request,response);
		
	}

	private void process (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//1. 클라이언트의 요청 path 정보를 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")); 
			//path : 클라이언트 요청 ( *.do) ..login.do, logout.do .....
		System.out.println(path);
		
		//2. HandlerMapping을 통해서 path에 해당하는 Controller를 검색 함
		
			//ctrl는 클라이언트 요청 정보에 대한 Controller 객체를 리턴 받아옴
		Controller ctrl = handlerMapping.getController(path);
		
		
		//3. 검색된 Controller를 실행. 리턴 값으로 뷰페이지를 리턴받아옴
			//viewName : view 페이지가 들어있다.
		String viewName = ctrl.handlerRequest(request, response);
	
		//4. 뷰 페이지 이름을 완성 해서 처리
		String view = null;
		if (!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		}else {
			view = viewName; //login.do , logout.do
		}
		
		
		
		//5. 검색된 뷰페이지로 이동
		response.sendRedirect(view);
	}
	
	
	
	
}
