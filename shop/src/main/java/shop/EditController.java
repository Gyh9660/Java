package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.QnaDAO;
import qna.QnaDTO;
import utils.JSFunction;

@WebServlet("/shop/edit.do")
public class EditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시물 정보 불러오기 (1. 조회수 증가, 2. 게시물 정보 가져오기)
				QnaDAO qdao = new QnaDAO();
				
				int q_id = Integer.parseInt(req.getParameter("q_id"));
				System.out.println(q_id); 
				
				//게시물의 자세한 정보 값 가져오기
				QnaDTO qdto = qdao.selectView(q_id);
				
				qdao.close(); //객체 반납
				
				//DataBase의 content 컬럼의 \r\n을 <== <<ENTER>>을 "<br />태그로 변환
				qdto.setContent(qdto.getContent().replaceAll("\r\n", "<br>"));
				
				//게시물 (dto) 객체를 view페이지로 전달하기 위한 변수 저장
				req.setAttribute("qdto", qdto);
				req.getRequestDispatcher("/shop/qnaedit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post 요청시 처리
				String q_id = (req.getParameter("q_id"));
				String u_id = req.getParameter("u_id");
				String subject = req.getParameter("subject");
				String content = req.getParameter("content");
				
				
				// DTO에 넘겨받은 변수값을 저장 (Client Form ===> DTO ===> DAO에 전달)
				QnaDTO qdto = new QnaDTO();
				qdto.setQ_id(Integer.parseInt(q_id));
				qdto.setU_id(u_id);
				qdto.setSubject(subject);
				qdto.setContent(content);
				
				QnaDAO qdao = new QnaDAO();
				int result = qdao.updateQna(qdto); //result가 1이라면 업데이트 성공 ,0이면 실패
				
				qdao.close();
				if (result==1) { //성공
					resp.sendRedirect("../shop/view.do?q_id="+q_id);
				}else { //실패
					JSFunction.alertLocation(resp, "수정 실패","../shop/view.do?q_id="+q_id );
					
					
				}
	}

}
