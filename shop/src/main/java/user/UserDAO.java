package user;

import common.DBConnPool;

public class UserDAO extends DBConnPool{

	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getDao() {
		return dao;
	}
	
	private UserDAO() {
		super();
	}
	
	
	//insert 회원가입시 DB에 정보입력
	
	public void insertUser (UserDTO User) {
		
		try {
			String Pass = User.getPass();
			
			String sql = "insert into user01 values(?,?,?,?,?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, User.getU_id());
			psmt.setString(2, User.getPass());
			psmt.setString(3, User.getU_name());
			psmt.setString(4, User.getPhone());
			psmt.setString(5, User.getEmail());
			psmt.setString(6, User.getZip_code());
			psmt.setString(7, User.getAddress());
			psmt.setTimestamp(8, User.getU_date());
			
			psmt.executeUpdate();
			
			System.out.println("회원 정보 DB입력 성공");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert중 예외발생");
		}finally {
			
		}
	}
	// 로그인처리, 뷰페이지에서 넘겨받은 아이디와 패스워드를 DB를확인하고 사용자 인증처리
	public int userCheck(String u_id, String pass) {
		int x= -1; //아이디가 없을때 실패
		
		try {
			
			String Pass = pass;
			
			String sql = "select pass from user01 where u_id = ?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) { //아이디 존재하면
				String dbpass = rs.getString("pass"); //DB에서 가져온 비밀번호
				
				if(Pass.equals(dbpass)) {
					x =1; //DB에서 가져온 비밀번호와 뷰페이지에서 넘어온 비밀번호가 같으면
				}else {
					x= 0; //아이디는 같지만 비밀번호가 일치하지 않으면
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(" 아이디와 패스워드 인증 시 예외 발생");
		}finally {
			
		}
		
		return x;
	}
	
	
	//회원가입시 아이디 중복체크
	
	public int confimId (String u_id) {
		int x =-1; // 아이디없음, 중복된 아이디가 아니다.
				   // x = 1 > 중복된 아이디가 있다.
		try {
			
			String sql = "select u_id from user01 where u_id = ?";
			
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
