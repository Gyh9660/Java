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
		qdto.setSubject(req.getParameter("subject"));
		qdto.setContent(req.getParameter("content"));
		
			
			
		
		/* int로바꿔서 리턴해서 해주던가..?
		 * 일단 넣을떼 제목에 분류 를넣어서 [무슨 문의] 제목 이런식으로 나오게
		//DTO에 객체를 DAO의 insert 메소드를 호출해서 DB에 저장
		QnaDAO qdao = new QnaDAO();
		
		int result = qdao.insertQna(qdto);
		
		//객체 종료 메소드 호출 (rs, stmt, psmt, con 모두 종료)
		qdao.close();
	
		//글쓰기 성공일때 이동할 페이지
		if (result == 1) { //글쓰기 성공일때 리스트페이지로 이동
			response.sendRedirect("../mvcboard/list.do");
		}
		
		
		//글쓰기 실패일때 이동할 페이지
		if (result == 0 ) { //글쓰기 실패 일때 다시 글쓰기 페이지로 이동
			response.sendRedirect("../mvcboard/write.do");
		}
		 */
	
	}

	
}
