package sec01.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.RequiresStatement;

@WebServlet("/first04")	//dispatcher 를 사용한 페이지 이동
public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//GET방식
		System.out.println("요청 확인");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
	//	resp.sendRedirect("second"); //서블릿을 요청시 다른 서블릿으로 이동
	
	//	resp.sendRedirect("index.jsp"); //서블릿을 요청시 jsp 페이지로 이동
		
	//	resp.addHeader("Refresh", "5;url=second02");
		
	//	resp.addHeader("Refresh", "5;url=index.jsp");

	/*	
		out.print("<script type = 'text/javascript'>");
		out.print("location.href = 'second03';");
		out.print("</script>");
	*/
	
	/*	
		out.print("<script type = 'text/javascript'>");
		out.print("location.href = 'index.jsp';");
		out.print("</script>");
	*/
		
		//URL주소가 바뀌지 않는다. 
		//(클라이언트에서 재요청하는게 아니라 서블릿에서 이동 (서버에서 처리하기떄문에))
		//서버에서 다른페이지로 이동후 주소를 던져주기 때문?
	//	RequestDispatcher dis = req.getRequestDispatcher("second04");
	//	dis.forward(req, resp);
	
		RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
		dis.forward(req, resp);
	}
	
}
