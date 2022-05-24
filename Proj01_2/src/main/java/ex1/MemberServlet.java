package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get 방식요청을 doHandle로 보낸다.
		doHandle(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 방식요청을 doHandle로 보낸다.
		doHandle(req,resp);
		
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get과 Post 모두의 요청처리 
		
		System.out.println("MemberServlet Controller 잘 작동됨.");
		
		req.setCharacterEncoding("UTF-8"); //한글 깨짐방지처리
		resp.setContentType("text/html;charset=UTF-8"); // 브라우저에 출력할때 html출력
		
		//DAO 객체 생성 : DAO의 메소드 호출을 위한 객체 생성
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		//출력 페이지 없이 바로 html로 출력 (out객체를 생성)
		//클라이언트의 웹브라우저에 HTML의 출력을 보낸다.
		
		PrintWriter out = resp.getWriter();
		
		//Client의 Form에서 넘긴 변수 값을 받는다.
			//command = "addMember" 일 경우 : DB에 값을 insert 한다.
		String command = req.getParameter("command");
		//form에서 Post방식으로 hidden으로 
		//링크로 Get 방식으로 넘어올수도 있다.
		if (command != null && command.equals("addMember")) {
			//DB에 값을 Insert
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			
			System.out.println(id + " " + pwd + " " + name + " "+ email);
			//DTO Setter에 값을 주입
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setName(name);
			dto.setEmail(email);
			
			int result = dao.addMember(dto); //DB에 값을 Insert
			//dao.close(); //객체 종료 (자원 반납)
			
			if (result == 1) {
				System.out.println("insert 성공2");
				//resp.sendRedirect("./member.do");
			}else if (result == 0){
				System.out.println("insert 실패2");
			}
			
		}else if (command != null && command.equals("delMember")) {
			//DB에 값을 Delete
			String id = req.getParameter("id"); //Get방식으로
			int result = dao.delMember(id);
			//dao.close(); // 객체 사용 종료
			
			if(result == 1) {
				System.out.println("삭제 성공");
				//resp.sendRedirect("./member.do");
			}else if (result ==0) {
				System.out.println("삭제 실패");
			}
		}
		
		// DB의 t_member2 테이블의 값을 모두 가져와서 출력
		//listMember는 DB의 select한 결과를 DTO(레코드)에 담고 listMember에 DTO가 저장이되어있다. 
		List<MemberDTO> listMember = dao.listMember();
		
		out.print("<html><body>");
		out.print("<table border = '1'> <tr align = 'center' bgcolor = 'lightgreen'>");
		out.print("<td>아이디 </td><td> 비밀번호 </td> <td> 이름 </td> <td> 이메일 </td> <td> 가입일 </td> <td>삭제</td></tr>");
		
		//두번째 tr에서 루프 돌리면서 db에 listMembe에서 DTO를 꺼내서 getterㄹ 출력
	
		for (int i = 0; i <listMember.size(); i++) {
			dto = (MemberDTO) listMember.get(i);//listMember 에 저장된 각방의 dto 객체를 끄집어 낸다.
			//dto에 저장된 필드와 값을 getter를 사용해서 변수에 할당
			
			String id = dto.getId();
			String pwd = dto.getPwd();
			String name = dto.getName();
			String email = dto.getEmail();
			Date joinDate = dto.getJoinDate();
			
			out.print("<tr><td>"+id+"</td> <td>"+pwd+"</td> <td>"+name+"</td> <td>"+email+"</td> <td>"+joinDate+"</td><td>"+"<a href ='./member.do?command=delMember&&id="+id+"'> 삭제 </a></td></tr>");
			//System.out.println(listMember.get(i));
			//System.out.println(i);
		}
		
		
		out.print("</table>");
		
		out.print("</body></html>");
		out.print("<a href = './memberForm.jsp'> 새 회원등록 하기 </a>");
		dao.close(); //객체 종료 (자원 반납)
		
		
		
	}

	
}

