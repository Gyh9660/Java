package shop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.QnaDAO;
import qna.QnaDTO;


@WebServlet("/shop/write.do")
public class WriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/shop/qnawrite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QnaDTO qdto = new QnaDTO();
		qdto.setU_id(req.getParameter("u_id"));
		qdto.setSubject(req.getParameter("qnatype")+req.getParameter("subject"));
		qdto.setContent(req.getParameter("content"));
		
		QnaDAO qdao = new QnaDAO();
			
		qdao.insertQna(qdto);	
		qdao.close();
		resp.sendRedirect("../shop/list.do");

	}

	
}
