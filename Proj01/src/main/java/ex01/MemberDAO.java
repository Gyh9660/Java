package ex01;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import common.DBConnPool;


public class MemberDAO extends DBConnPool {
	
	
	public MemberDAO() {
		super();	
	}
	
	//List.jsp 출력을 위한 select
	public List<MemberDTO> selectListPage(Map<String,Object> map){
		List<MemberDTO> board = new Vector<MemberDTO>();
		String query = "SELECT * FROM t_member" ;
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setId(rs.getString(1));
				dto.setPwd(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setJoinDate(rs.getString(5));
				
				board.add(dto);
					
				
			}
		}catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return board;
	}
	
	public MemberDTO selectView(String id) {
    	MemberDTO dto = new MemberDTO();
    	String query = "SELECT * FROM member WHERE id = ?";
    	
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, id);
    		rs = psmt.executeQuery();
    		
    		if(rs.next()) {
    			dto.setId(rs.getString(1));
    			dto.setPwd(rs.getString(2));
    			dto.setName(rs.getString(3));
    			dto.setEmail(rs.getString(4));
    			dto.setJoinDate(rs.getString(5));
    		}
    	}catch (Exception e) {
			System.out.println("게시물 상세정보 출력중 예외 발생");
			e.printStackTrace();
		}
    	
    	return dto;
    }
	
	
	
	//Insert.jsp db에 insert
	public int insertWrite (MemberDTO dto) {
		int result = 0;
		try {
			String query = "INSERT INTO t_member ( "
					+ " id,pwd,name,email) "
					+ " VALUES ( ?,?,?,? )";
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
		
			result = psmt.executeUpdate();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("INSERT중 예외발생");
		
		}
		
		return result;
	}
	
	
	
	//delete.jsp db에서 delete
	
	public int deletePost(String id) {
		int result =0;
		
		try {
			String query = "DELETE t_member WHERE id = ?";
			psmt=con.prepareStatement(query);
			psmt.setString(1, id);
			
			result = psmt.executeUpdate();
			
			
		}catch (Exception e) {
			System.out.println("delete시 예외 발생");
			e.printStackTrace();
		
		
		
		}
		
		return result;
		
	}
	
	public boolean confirmPassword(String pwd,String id) {
		boolean isCorr = true;
		try {
			String query = "SELECT count(*) FROM t_member WHERE pwd = ? and id = ? ";
			psmt = con.prepareStatement(query);
			psmt.setString(1, pwd);
			psmt.setString(2, id);
			rs = psmt.executeQuery();
			
			rs.next();
			if(rs.getInt(1)==0) {
				isCorr = false;
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("비밀번호 확인 시 예외 발생"); 
		}
		
		return isCorr;
	}
	
}
