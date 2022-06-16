package com.springbook.biz.view.controller;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	//기능별의 Controller를 통합:
	
	//1. 글 등록 : insertBoard Controller 통합
	@RequestMapping(value="/insertBoard.do") //클라이언트 요청
	public String insertBoard(BoardVO vo,BoardDAO boardDAO){
		System.out.println("글 등록 처리- Spring MVC 어노테이션 작동  Controller 통합");
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do"; //Forward 방식으로 뷰 페이지 전송
	}
	
	//2. 글 수정 : updateBoard Controller 통합
	@RequestMapping(value ="/updateBoard.do")
	public String updateBoadr(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 수정 처리 Spring MVC 어노테이션  Controller 통합");
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getSeq());
		
		boardDAO.updateBoard(vo);
		
		return "redirect:getBoardList.do";
		

	}
	
	//3. 글 삭제 : deleteBoard Controller 통합
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 삭제 처리 Spring MVC 어노테이션  Controller 통합");
		
		boardDAO.deleteBoard(vo);
		
		return "redirect:getBoardList.do"; 
	}
	//검색 조건 목록 성정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("이름", "NAME");
		conditionMap.put("날짜", "REGDATE");
		
		return conditionMap;
	}
	
		//searchConditionMap() 메소드는 @ModelAttribute 어노테이션이 있기
			//getBoardList메소드보다 먼저 실행이된다.
	
	//4. 글 목록 검색 : getBoardList Controller 통합
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(
			@RequestParam (value="searchCondition", defaultValue="TITLE",required=false)
			String condition,
			@RequestParam(value="searchKeyword", defaultValue ="",required=false)
			String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model,
			HttpServletRequest req) {
		System.out.println("글 목록 검색 처리 -- Spring MVC 호출 annotation  Controller 통합");
		
		System.out.println("검색 조건 "+condition);
		System.out.println("검색 단어 "+keyword);
		
		String condition2 = req.getParameter("searchCondition");
		String keyword2 = req.getParameter("searchKeyword");
		
		System.out.println("검색 조건 "+condition2);
		System.out.println("검색 단어 "+keyword2);
		
		model.addAttribute("boardList",boardDAO.getBoardList(vo));
		
		return "getBoardList.jsp";
		
	}
	
	//5. 글 상세 검색 : getBoard Conteroller 통합
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 조회 처리 --  스프링 어노테이션 처리  Controller 통합");
		
		System.out.println("VO로 자동으로 넘어오는 값"+vo.getSeq());
		
		model.addAttribute("board",boardDAO.getBoard(vo));

		return "getBoard.jsp";
		
		//ModelAndView : Model (뷰페이지로 변수의 값을 넘길떄) + view (뷰페이지를 저장)
		//Model 	   : Model (뷰페이지로 변수의 값을 넘길떄)
	}
	
	/*@ModelAttribute :
		1. Command 객체로 전송되는 객체이름을 다른이름으로 변경해서 사용 할때
		2. View에서 사용할 데이터를 설정하는 용도로 사용됨.
			@ModelAttribute가 설정된 메소드는 @RequestMapping 어노테이션이
			성정된 메소드 보다 먼저 호출됨.
			@ModelAttribute 메소드 실행 결과로 리턴되는 객체는 자동으로 Model에 저장이된다.
			@ModelAttribute 메소드 실행 결과로 리턴되는 객체를 View 페이지에서
			사용 할 수 없다.
			
	
	*/
}
