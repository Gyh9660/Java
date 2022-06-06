package user;

import java.util.Base64.Decoder;

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
			System.out.println(User.getU_id());
			System.out.println(User.getPass());
			System.out.println(User.getU_name());
			System.out.println(User.getPhone());
			System.out.println(User.getEmail());
			System.out.println(User.getZip_code());
			System.out.println(User.getAddress());
			System.out.println(User.getU_date());
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
	public int updateUser(UserDTO user) {
		int x =-1; // -1 : (id가 db에 없음), 0 : 아이디 o 비밀번호 x, 1 :아이디,비번 일치
		
		try {
			String Pass = user.getPass();
			
			String sql = "select pass from user01 where id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user.getU_id());
			rs =psmt.executeQuery();
			
			if(rs.next()) {
				//폼에서 넘긴 패스워드와 DB에서 가져온 패스워드가 일치하는지 확인후 처리
				String dbpass = rs.getString("pass");
				
				byte[] decoderBytes = Base64.decodeBase64(dbpass);
				String decodedTxt = new String(decoderBytes);
				
				if(Pass.equals(decodedTxt)) { //두 패스워드가 일치할떄
					
					sql = "update user01 set u_name = ?, address = ? , phone = ? "
							+ "where u_id = ?";
					psmt = con.prepareCall(sql);
					psmt.setString(1, user.getU_name());
					psmt.setString(2, user.getAddress());
					psmt.setString(1, user.getPhone());
					psmt.setString(1, user.getU_id());
					
					psmt.executeUpdate();
					x=1; //update 성공시 x에 1할당
					
							
				}else {
					x=0; //id는 존재하고 패스워드 일치 x
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 정보 수정시 예외 발생");
		}finally {
			
		}
		return x;
	}
	
	//회원 탈퇴 처리
	public int deleteUser(String u_id, String pass) {
		int x = -1; //탈퇴실패 ,1 : 탈퇴성공
		
		try {
			String Pass = pass;
			
			String sql = "select pass from user01 where u_id = ?";
			psmt =con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs=psmt.executeQuery();
			
			if(rs.next()) { //id가 db에 존재 (id일치)
				String dbpass = rs.getString("pass");
				byte[] decoderBytes = Base64.decodeBase64(dbpass);
				String decodedTxt = new String(decoderBytes);
				
				if(Pass.equals(decodedTxt)) { //id와 pass가 일치하면 delete
					sql = "delete user01 where u_id = ?";
					psmt = con.prepareStatement(sql);
					psmt.setString(1, u_id);
					psmt.executeUpdate();
					
					x=1; // delete성공 (아이디 비번일치)
					
				}else{
					x=0; //id는 존재하지만 패스워드 일치 x
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("탈퇴처리중 예외발생");
		}finally {
			
		}
		
		return x; //성공시 x =1, 실패시 -1
	}
}
