package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.QnaDAO;
import qna.QnaDTO;
import utils.JSFunction;

@WebServlet("/shop/delete.do")
public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get 요청시 처리
		
		//System.out.println("PassController 정상작동");
		//String mode = req.getParameter("mode");
		//System.out.println("mode 변수의 값 : " + mode);
		
		
		//mode :edit <== 글수정 ,delete<= 글삭제
		int q_id = Integer.parseInt(req.getParameter("q_id"));
		
			QnaDAO qdao = new QnaDAO();
			//삭제
				qdao = new QnaDAO();
				QnaDTO qdto = qdao.selectView(q_id);
				qdao.deleteQna(q_id); //게시물 삭제
				qdao.close();
				
				// 게시물 삭제시 첨부 파일도 같이 삭제 <<나중에 추가할 부분 >>
				
				// 삭제 이후 페이지 이동 (Java Script) :JSFunction.java
				JSFunction.alertLocation(resp, "삭제되었습니다.", "../shop/list.do");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post 요청시 처리
		String q_id = (req.getParameter("q_id"));
		System.out.println(q_id);
		String u_id = req.getParameter("u_id");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		
		// DTO에 넘겨받은 변수값을 저장 (Client Form ===> DTO ===> DAO에 전달)
		QnaDTO qdto = new QnaDTO();
		qdto.setQ_id(Integer.parseInt(q_id));
		qdto.setU_id(u_id);
		qdto.setSubject(req.getParameter("qnatype")+subject);
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
