package logon;

import common.DBConnPool;
import work.crypt.BCrypt;
import work.crypt.SHA256;

public class LogonDBBean  extends DBConnPool{	
	//DAO : 실제 DB를 select, insert,delete,update
	
	//LogonDBBean 전역 객체 생성 < -- 한개의 객체만 생성 해서 공유 (싱글톤 패턴)
		//외부의 다른 클래스에서 new 키를 사용하면 여러개의 객체를 생성할 수 있다.
		//특중 클래스는 여러개의 객체를 생성하지 못하도록 하고 단 하나의 객체만 생성해서 사용해야 될 경우
			//(회사)
	
		//싱글톤 패턴 : 외부에서 여러개의 객체를 생성하지 못하고 하나의 객체만 공유 해서 사용하도록 함.
			//0. 객체 생성자는 private로 셋팅을 먼저한다.
			//1. private static 으로 객체생성, 
			//2. 생성된 객체를 메소드로 객체를 전달.
	private static LogonDBBean instance = new LogonDBBean();
	
	//LogonDBBean 객체를 리턴하는 메소드
		//메소드를 사용해서만 객체를 생성 할 수 있따.
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	//기본 생성자 : private : 외부에서 객체 생성이 불가능
		// 부모 클래스의 기본 생성자 호출
	private LogonDBBean( ) {super();};
	
	//회원가입 처리하는 메소드들( registerPro.jsp) 에서 넘어오는 값을 DB에 저장 (insert)
	
	public void insertMember (LogonDataBean Member) {
		
		
//		SHA256 sha = SHA256.getInsatnce();
		
		try {
			//Form에서 넘겨받은 Password를 DB에 저장할때 암호화
				//orgPass : Form에서 넘겨 받은 password
			
			String orgPass = Member.getPasswd();
//			String shaPass =sha.Sha256Encrypt(orgPass.getBytes());
				//hash password
//			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
				//bcPass : 암호화된 암호
			
			System.out.println("암호화 되지 않은 패스워드 : " + orgPass);
//			System.out.println("암호화 된 패스워드 : " + bcPass);
		
			String sql = "insert into member01 values(?,?,?,?,?,?)";
			
			psmt = con.prepareStatement(sql); 
			psmt.setString(1, Member.getId());
			//psmt.setString(2, bcPass); //암호화된 password 저장
			psmt.setString(2, Member.getPasswd());
			psmt.setString(3, Member.getName());
			psmt.setTimestamp(4, Member.getReg_date());
			psmt.setString(5, Member.getAddress());
			psmt.setString(6, Member.getTel());
			
			psmt.executeUpdate();
			
			System.out.println("회원정보 DB입력 성공");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원정보 DB입력시 예외 발생");
		}finally {
			//instance.close();
		}
	}
	
	//로그인 처리 (loginPro.jsp) : 폼에서 넘겨받은 아이디와 패스워드를 DB를 확인하고
		//사용자 인증처리, DB의 정보를 수정할때 , DB의 정보를 삭제 할때,
			//사용자 인증(MemberCheck.jsp)에서 사용하는 메소드
	public int userCheck(String id, String passwd) {
		int x = -1; 	//x = -1 : Id가 존재하지 않는다.
						//x = 0 : id는 존재하지만 패스워드가 일치하지 않을떄
						//x = 1 : 인증 성공,

		
		//복호화 : 암호화된  Password를 암호를 해독하여 Password로 변환
//		SHA256 sha = SHA256.getInsatnce();
		
		try {
			String orgPass = passwd; //폼에서 넘겨오는 변수
//			String shaPass = sha.getSha256(orgPass.getBytes());
			
			String sql = "select passwd from member01 where id = ?";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) { //아이디가 존재하면 
				String dbpasswd = rs.getString("passwd"); //DB에서 가져온 패스워드
//				if(BCrypt.checkpw(shaPass, dbpasswd)) {
				if(orgPass.equals(dbpasswd)) {
					x = 1; //폼에서 넘겨온 패스워드와 DB에서 가져온 패스워드가 일치할 때 x에 1할당
				}else {
					x = 0; //패스워드가 일치하지 않을때
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("아이읻와 패스워드 인증 실패 예외 발생");
		}finally {
			//instance.close(); //객체 사용 종료. rs, stmt,psmt, con
		}
		
		
		
		return x;
	
	
	}
	
	//아이디 중복 체크 (confirmId.jsp) : 아이디 중복을 확인하는 메소드
	public int confirmId (String id) {
		
		int x = -1;	 //x = -1 일때 : 같은 ID가 DB에 존재하지 않는다.
					 //x = 1 일때 : 같은 ID가 DB에 존재한다.(중복)
		try {
			String sql = "select id from member01 where id = ?";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if ( rs.next()) { //id가 DB에 존재하는경우
				System.out.println(id+"존재하는 ID입니다.");
				x = 1;
			}else { //존재하지 않는 경우
				x = -1;
				System.out.println(id+"존재하지 않는 ID입니다.");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ID 중복 체크 중 예외 발생");
		}finally {
			//instance.close();
		}
		return x;
	}
	
	//회원정보 수정 (modifyForm.jsp) : DB에서 회원정보의 값을 가져오는 메소드
	
	public LogonDataBean getMember (String id, String passwd) {
		LogonDataBean member = null;
//		SHA256 sha = SHA256.getInsatnce();
		
		try {
			String orgPass = passwd;
//			String shaPass = sha.getSha256(orgPass.getBytes());
			
			String sql = "select * from member01 where id = ?";
			psmt= con.prepareStatement(sql);
			psmt.setString(1, id);
			rs= psmt.executeQuery();
			
			if(rs.next()) { //해당 아이디가 DB에 존재한다.
				String dbpasswd = rs.getString("passwd"); //DB의 패스워드를 변수에 할당
//				if (BCrypt.checkpw(shaPass, dbpasswd)) {
				if (orgPass.equals(dbpasswd)) {
					//DB의 passwd와 폼에서 넘겨온 Pass가 같을때
						//DB에서 select 한 레코드를 DTO(LogonDataBean)에
						//Setter주입해서 값을 반환
					
					//member 객체 생성 후 DB의 rs에 저장된값을 setter주입후 리턴
					member = new LogonDataBean();
					
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setReg_date(rs.getTimestamp("reg_date"));
					member.setAddress(rs.getString("address"));
					member.setTel(rs.getString("tel"));
			
				
				}else {
					//DB의 passwd와 폼에서 넘겨온 Pass가 다를때
					
				}
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 정보 읽어 오는 중 예외 발생");
		
		}finally {
			
			//instance.close();
		} 
		
		
		return member; //member (LogonDataBean) : DTO에 Setter 주입후 리턴
	}
	
	//수정페이지에서 수정한 내용을 DB에 저장하는 메소드
	//회원 정보 수정처리 : (modifyPro.jsp)에서 회원정보를 수정을 처리하는 메소드
	public int updateMember(LogonDataBean member) {
		int x = -1; //x =-1 : update 실패시 (id가 db에없는 경우)
					//x = 0 : 아이디는 존재하고 비밀번호가 맞지 않을때
					//x = 1 : update 성공 ( 아이디와 passwd가 일치)
				
		//ID와 Passwd를 확인 후 update 진행		
				
//		SHA256 sha = SHA256.getInsatnce(); //객체 활성화
		
		try {
			//암호화
			String orgPass = member.getPasswd();
//			String shaPass = sha.getSha256(orgPass.getBytes());
			
			String sql = "select passwd from member01 where id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member.getId());
			rs = psmt.executeQuery();
			
			if(rs.next()) { //해당 아이디가 DB에 존재한다.
				//폼에서 넘긴 패스워드와 DB에서 가져온 패스워드가 일치하는지 확인후 처리
				String dbpasswd = rs.getString("passwd");
//				if (BCrypt.checkpw(shaPass, dbpasswd)) {//두 패스워드가 일치할때
				if (orgPass.equals(dbpasswd)) {//두 패스워드가 일치할때
					//DTO (member)에서 들어온 값을 DB에 Insert
					sql = "update member01 set name = ?, address = ?, tel = ? "
							+ " where id = ? ";
					psmt = con.prepareStatement(sql);
					psmt.setString(1, member.getName());
					psmt.setString(2, member.getAddress());
					psmt.setString(3, member.getTel());
					psmt.setString(4, member.getId());
					
					psmt.executeUpdate();
					x=1; //update 성공시 x변수에 1을 할당
					
				}else {
					x =0; //id는 존재하고 패스워드가 일치하지 않을떄
				}
			
				
				
				
			}else { //해당 아이디가 DB에 존재한다.
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 정보 수정시 예외 발생");
		}finally {
		//	instance.close();
		}
		
		
		return x;
	}
	//회원 탈퇴 처리 (deletePro.jsp )에서 회원정보 삭제 메소드
	public int deleteMember(String id, String passwd) {
		int x = -1;	//x= -1 : 회원 탈퇴 실패
					//x = 1 : 회원 탈퇴 성공
		
//		SHA256 sha = SHA256.getInsatnce(); //객체를 호출해서 변수에 할당.
		
		try {
			String orgPass = passwd;
//			String shaPass = sha.getSha256(orgPass.getBytes());
			
			String sql = "select passwd from member01 where id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			
			if(rs.next()) { //id가 DB에 존재
				String dbpasswd = rs.getString("passwd");
//				if (BCrypt.checkpw(shaPass, dbpasswd)) { //id와 pw가 모두 일치하는 경우 delete
				if (orgPass.equals(dbpasswd)) { //id와 pw가 모두 일치하는 경우 delete
					sql = "delete member01 where id = ?";
					psmt = con.prepareStatement(sql);
					psmt.setString(1, id);
					psmt.executeUpdate();
					
					x=1; //delete 성공시 (아이디와 패스워드가 모두 일치할떄)
				}else {
					x=0; //id는 존재하고 패스워드가 일치하지 않을때
				}
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 탈퇴중 에외 발생");
		}finally {
		//	instance.close();
		}
		
		return x; //성공시 x = 1, 실패시 -1
	}

}
