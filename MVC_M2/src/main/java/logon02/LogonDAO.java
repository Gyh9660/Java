package logon02;

import common.DBConnPool;

public class LogonDAO extends DBConnPool{
	
	private static LogonDAO dao = new LogonDAO();
	
	public static LogonDAO getDao() {
		return dao;
	}
	
	private LogonDAO() {
		super();
	}
	
	//insert 회원가입시 DB에 정보입력
	
	public void insertMember02 (LogonDTO Member02) {
		
		try {
			
			String pass = Member02.getU_pass();
			
			String sql = "insert into member02 values(?,?,?,?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Member02.getU_id());
			psmt.setString(2, Member02.getU_pass());
			psmt.setString(3, Member02.getU_name());
			psmt.setTimestamp(4, Member02.getR_date());
			psmt.setString(5, Member02.getU_address());
			psmt.setString(6, Member02.getU_tel());
			psmt.setString(7, Member02.getU_birthday());
			
			psmt.executeUpdate();
			
			System.out.println("회원 정보 DB입력 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(" 회원 정보 DB입력시 예외 발생");
			
			System.out.println(Member02.getU_id());
			System.out.println(Member02.getU_pass());
			System.out.println(Member02.getU_name());
			System.out.println(Member02.getR_date());
			System.out.println(Member02.getU_address());
			System.out.println(Member02.getU_tel());
			System.out.println(Member02.getU_birthday());
		
		}finally {
			
		}
	}
	
	// 로그인처리, 뷰페이지에서 넘겨받은 아이디와 패스워드를 DB를확인하고 사용자 인증처리
	
	public int userCheck(String u_id, String u_pass) {
		int x = -1; //아이디가 없을시 실패
		
		try {
			
			String pass = u_pass;
			
			String sql = "select u_pass from member02 where u_id = ?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) { //아이디가 존재하면
				String dbpass = rs.getString("u_pass"); //DB에서 가져온 비밀번호
				
				if(pass.equals(dbpass)) { //db에서 가져온 비밀번호와 뷰페이지에서 넘어온 비밀번호가 같으면
					x = 1;
				}else {
					x = 0; //패스워드가 일치하지 않으면
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("아이디와 패스워드 인증 시 예외 발생");
		
		}finally {
			
		} 
		
		return x;
	}
	
	//회원가입시 아이디 중복체크
	
	public int confirmId (String u_id) {
		int x = -1; //아이디가 없다 => 중복된 아이디가 아니다
		
		try {
			
			String sql = "select u_id from member02 where u_id = ?";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				x = 1;
			}else {
				x = -1;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("아이디 중복체크중 예외발생"); 
	
		}finally {
			
		}
		return x;
	}
	
	
	
}
