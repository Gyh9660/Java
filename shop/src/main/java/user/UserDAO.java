package user;

import org.apache.commons.codec.binary.Base64;

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
			byte[] encodedBytes = Base64.encodeBase64(Pass.getBytes());
			String encodedText = new String(encodedBytes);
			
			String sql = "insert into user01 values(?,?,?,?,?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, User.getU_id());
			psmt.setString(2, encodedText);
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

				byte[] decoderBytes = Base64.decodeBase64(dbpass);
				String decodedTxt = new String(decoderBytes);
				
				if(Pass.equals(decodedTxt)) {
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
	
	//회원정보 DB에서 가져오는 메소드
	public UserDTO getUser (String u_id, String pass) {
		UserDTO user = null;
		
		try {
			String Pass = pass;
			
			String sql = "select * from user01 where u_id =?";
			psmt= con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs=psmt.executeQuery();
			
			if(rs.next()) { //해당 아이디가 DB에 존재
				String dbpass = rs.getString("pass"); //DB의 패스워드
				
				byte[] decoderBytes = Base64.decodeBase64(dbpass);
				String decodedTxt = new String(decoderBytes);
				
				if (Pass.equals(decodedTxt)) {
					//DB의 pass와 폼에서 넘어온 pass가 같을때
					//DB에서 select한 레코드를 DTO에
					//Setter주입해서 값을 반환
					
					user = new UserDTO();
					
					user.setU_id(rs.getString("u_id"));
					user.setPass(rs.getString("pass"));
					user.setU_name(rs.getString("u_name"));
					user.setPhone(rs.getString("phone"));
					user.setEmail(rs.getString("email"));
					user.setZip_code(rs.getString("zip_code"));
					user.setAddress(rs.getString("address"));
					user.setU_date(rs.getTimestamp("u_date"));
					
				}else {
					//DB의 pass와 폼에서 넘어온 Pass가 다를떄
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 읽어 오는중 예외 발생");
		}finally {
			
		}
		
		return user; //user :dto에 setter주입후 리턴
	}
	
	//회원 정보 수정처리 : 수정페이지에서 수정한 내용을 DB에 저장 메소드
	
	
	
}
