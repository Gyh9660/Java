package shop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import fileupload.FileUtil;
import pro.ProDAO;
import pro.ProDTO;
import utils.JSFunction;

@WebServlet("/shop/pwrite.do")
public class ProWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/shop/prowrite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");
		System.out.println(saveDirectory);
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if (mr == null) { //객체 생성 실패 (1MB 이상의 용량의 파일  정송시)
			JSFunction.alertLocation(resp, "첨부 용량이 초과 되었습니다.", "../shop/pwrite.do");
			
			return;
		}
		ProDTO pdto = new ProDTO();
		pdto.setP_name(mr.getParameter("p_name"));
		pdto.setP_type(mr.getParameter("type"));
		pdto.setPrice(Integer.parseInt(mr.getParameter("price"))); 
		pdto.setStock(Integer.parseInt(mr.getParameter("stock")));
		
		String fileName = mr.getFilesystemName("image");
		System.out.println(fileName);
		if (fileName != null) { //첨부 파일이 비어 있지 않다면
			
			
			//새로운 파일이름으로 변경해서 서버에 저장함.  (서버에 해당 파일이름이 존재할 경우가 있으므로)
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			
			//확장자만 잘라서 저장
			String ext = fileName.substring(fileName.lastIndexOf("."));
			
			//서버에 저장할 파일이름 생성
			String newFileName = now + ext;
				
				// 파일명 변경	
				File oldFile = new File(saveDirectory + File.separator + fileName);
				File newFile = new File(saveDirectory + File.separator + newFileName);
				
				oldFile.renameTo(newFile);
				
				//DTO에 Settor 주입 (조건 : 파일을 업로드 한 경우에만)
				pdto.setImage(newFileName); // 서버에 저장될  파윌이름
				
				
			}	
		
			//DTO에 객체를 DAO의 insert 메소드를 호출해서 DB에 저장
				ProDAO pdao = new ProDAO();
				
				int result = pdao.insertWrite(pdto);
				
				//객체 종료 메소드 호출 (rs, stmt, psmt, con 모두 종료)
				pdao.close();
			
				//글쓰기 성공일때 이동할 페이지
				if (result == 1) { //글쓰기 성공일때 이동
					resp.sendRedirect("../shop/plist.do");
				}
				
				
				//글쓰기 실패일때 이동할 페이지
				if (result == 0 ) { //글쓰기 실패 일때 다시 글쓰기 페이지로 이동
					resp.sendRedirect("../shop/pwrite.do");
					
				}
				
			    
	}

}
