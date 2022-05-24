package ex1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import common.DBConnPool;


public class MemberDAO extends DBConnPool {
		//DB connection 객체를 상속해서 쓰면 중복코드를 방지할수 있다. 
	
	public MemberDAO() {
		super();	//부모 클래스의 기본 생성자 호출 (con 객체가 생성됨)
	}
	
	//List.jsp 출력을 위한 select : 출력 레코드가 많다.
		//레코드 1개를 DTO에 저장
		//DTO를 List에 저장 : Vector (멀티쓰레드), ArrayList(싱글쓰레드)
	public List<MemberDTO> listMember(){
		
		List<MemberDTO> listMember = new ArrayList<MemberDTO>();
		MemberDTO dto = new MemberDTO();
		
		
		String query = "SELECT * FROM t_member2" ;
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
				//rs는 DB에서 select한 결과값(레코드셋)을 저장하고 있다.
			
			//rs에 저장된 레코드 셋을 DTO에 저장후 List안에 add시켜줌
			
			while (rs.next()) {
				dto = new MemberDTO();
				//rs의 값을 변수에 담은후 DTO에 추가
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString(3);
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				//DTO에 Setter 주입
				
				dto.setId(id);
				dto.setPwd(pwd);
				dto.setName(name);
				dto.setEmail(email);
				dto.setJoinDate(joinDate);
				
				listMember.add(dto);
			
			}
		}catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return listMember;
	}
	
	//Insert.jsp db에 insert
	//매개 변수로 dto를 받는다.
	
	public int addMember (MemberDTO dto) {
		int result = 0; //insert 성고 여부를 확인 하는 변수
		try {
			String query = "INSERT INTO t_member2 ( "
					+ " id,pwd,name,email) "
					+ " VALUES ( ?,?,?,? )";
			
			System.out.println("Insert : " +query);
			//DTO의 넘어오는 변수의 값들을 getter로 호출해서 변수에 할당
			String id = dto.getId();
			String pwd = dto.getPwd();
			String name = dto.getName();
			String email = dto.getEmail();
			
			//psmt 객체 생성
			psmt = con.prepareStatement(query);
			//?에 값을 할당
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			psmt.setString(3, name);
			psmt.setString(4, email);
			//psmt실행
			result=psmt.executeUpdate(); //insert,update,delete인 경우
				//result : 1 <== insert 성공/ 0 <== 실패
			System.out.println("insert 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("INSERT중 예외발생");
		
		}
		return result;
	}
	
	
	
	//delete.jsp db에서 delete
		//매개변수로 primary key 컬럼의 변수값을 받아서 처리
	public int delMember(String id) {
		
		int result = 0;
		
		try {
			String query = "DELETE t_member2 WHERE id = ?";
			psmt=con.prepareStatement(query);
			psmt.setString(1, id);
			
			result = psmt.executeUpdate();
			
			
		}catch (Exception e) {
			System.out.println("delete시 예외 발생");
			e.printStackTrace();
		
		}
		return result;
		
	}
	
	
}
