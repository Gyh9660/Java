package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.QnaDAO;
import qna.QnaDTO;

@WebServlet("/shop/rwrite.do")
public class RwriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mid = req.getParameter("mid");
		String rnum= req.getParameter("rnum");
		String step = req.getParameter("step");
		
		System.out.println("==================");
		System.out.println(req.getParameter("q_id"));
		System.out.println("==================");
		//int q_id = Integer.parseInt(req.getParameter("q_id"));
		
		req.setAttribute("mid",mid);
		req.setAttribute("step",step);
		req.setAttribute("rnum",rnum);
		req.setAttribute("q_id", req.getParameter("q_id"));
		
		req.getRequestDispatcher("/shop/qnarwrite.jsp").forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mid = Integer.parseInt(req.getParameter("mid"));
		int rnum= Integer.parseInt(req.getParameter("rnum"));
		int step = Integer.parseInt(req.getParameter("step"));

		QnaDTO qdto = new QnaDTO();
		qdto.setU_id(req.getParameter("u_id"));
		qdto.setSubject(req.getParameter("subject"));
		qdto.setContent(req.getParameter("content"));
		qdto.setMasterid(mid);
		qdto.setReplaynum(rnum);
		qdto.setStep(step);
		qdto.setQ_id(Integer.parseInt(req.getParameter("q_id")));
		QnaDAO qdao = new QnaDAO();
			
		qdao.insertRwrite(qdto);	
		qdao.close();
		resp.sendRedirect("../shop/list.do");
	
	}

	
}
