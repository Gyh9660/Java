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

@WebServlet("/first04")	//dispatcher �� ����� ������ �̵�
public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//GET���
		System.out.println("��û Ȯ��");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
	//	resp.sendRedirect("second"); //������ ��û�� �ٸ� �������� �̵�
	
	//	resp.sendRedirect("index.jsp"); //������ ��û�� jsp �������� �̵�
		
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
		
		//URL�ּҰ� �ٲ��� �ʴ´�. 
		//(Ŭ���̾�Ʈ���� ���û�ϴ°� �ƴ϶� �������� �̵� (�������� ó���ϱ⋚����))
		//�������� �ٸ��������� �̵��� �ּҸ� �����ֱ� ����?
	//	RequestDispatcher dis = req.getRequestDispatcher("second04");
	//	dis.forward(req, resp);
	
		RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
		dis.forward(req, resp);
	}
	
}
