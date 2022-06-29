package com.mybatis.join.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {

	@Autowired
	private MybatisDAO mybatisDAO;
	
	@RequestMapping("joinList.do")
	public String selectList(JoinVO vo, Model model) {
		System.out.println("컨트롤러 호출 서옹 joinList.do"); 
		List<JoinVO> joinList = mybatisDAO.selectListJoin(vo);
		
		System.out.println("mybatis를 통한 list객체저장 성공");
		JoinVO joinVO = joinList.get(0);
		JoinVO joinVO1 = joinList.get(1);
		JoinVO joinVO2 = joinList.get(2);
		
		String a = joinVO.toString();
		System.out.println(a);
		System.out.println(joinVO1.toString());
		System.out.println(joinVO2.toString());
		
		model.addAttribute("joinList",joinList);
		
		return "joinList.jsp";
	}
	
}
