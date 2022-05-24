package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second0004")	//dispatcher 를 사용한 페이지 이동
public class SecondServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get 방식 요청
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		//setAttribute는 Dispatcher로 넘겨여야만 값이 전달되고 나온다.
		
		String address = (String)req.getAttribute("address");
		String email = (String)req.getAttribute("email");
		
		out.print("<html><body>");
		out.print("RequestDispatcher를 이용한 redirect 실습입니다.(RequestDispatcher)<br><br>");
		out.print("주소 : " + address + "<br><br>");
		out.print("메일주소 : " + email + "<br><br>");
		out.print("</body></html>");
		
		
	}
}
