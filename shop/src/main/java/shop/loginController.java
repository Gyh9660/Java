package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.JSFunction;

@WebServlet("/shop/login.do")
public class loginController extends HttpServlet{


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String u_id =(String)session.getAttribute("u_id");
		
		if(u_id == null || u_id.equals("")) {
			
			req.getRequestDispatcher("/shop/login.jsp").forward(req, resp);
			

		}else {
			
			session.invalidate();
			JSFunction.alertLocation(resp, "로그아웃 되었습니다.", "../shop/main.jsp");
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	}

	
}
