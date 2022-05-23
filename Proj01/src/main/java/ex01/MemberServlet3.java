package ex01;

import java.awt.datatransfer.Clipboard;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/member/delete.do")
public class MemberServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get
		req.getRequestDispatcher("/member/Delete.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post 
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		boolean confirmed = dao.confirmPassword(pwd,id);
		dao.close();
		System.out.println(id);
		System.out.println(pwd);
		if (confirmed) {
			dao = new MemberDAO();
			MemberDTO dto = dao.selectView(id);
			int result = dao.deletePost(id);
			dao.close();
		}
		resp.sendRedirect("../member/list.do");
	}

	
}

