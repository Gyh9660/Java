package ex01;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/write.do")
public class MemberServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get 방식
				
				
		req.getRequestDispatcher("/member/Write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post방식
		req.setCharacterEncoding("UTF-8");
		MemberDTO dto = new MemberDTO();
		dto.setId(req.getParameter("id"));
		dto.setPwd(req.getParameter("pwd"));
		dto.setName(req.getParameter("name"));
		dto.setEmail(req.getParameter("email"));
		dto.setJoinDate(req.getParameter("joinDate"));
		
		
		
		MemberDAO dao = new MemberDAO();
		System.out.println(req.getParameter("joinDate"));
		int result = dao.insertWrite(dto);
		
		dao.close();
		
		if (result ==1) {
			resp.sendRedirect("../member/list.do");
		}
		
		if (result ==0) {
			resp.sendRedirect("../member/write.do");
		}
		
	}

	
}

