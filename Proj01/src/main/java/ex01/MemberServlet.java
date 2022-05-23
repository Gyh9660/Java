package ex01;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list.do")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get 방식
		
		MemberDAO dao = new MemberDAO();
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<MemberDTO> boardLists = dao.selectListPage(map);
		dao.close();
		
		 req.setAttribute("boardLists", boardLists);
		 req.setAttribute("map", map);				
		 req.getRequestDispatcher("/member/List.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 
		
		
	}

	
}

