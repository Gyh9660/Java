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
	
	
	//insert ȸ�����Խ� DB�� �����Է�
	
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
			
			System.out.println("ȸ�� ���� DB�Է� ����");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert�� ���ܹ߻�");
		}finally {
			
		}
	}
	// �α���ó��, ������������ �Ѱܹ��� ���̵�� �н����带 DB��Ȯ���ϰ� ����� ����ó��
	public int userCheck(String u_id, String pass) {
		int x= -1; //���̵� ������ ����
		
		try {
			
			String Pass = pass;
			
			String sql = "select pass from user01 where u_id = ?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) { //���̵� �����ϸ�
				String dbpass = rs.getString("pass"); //DB���� ������ ��й�ȣ

				byte[] decoderBytes = Base64.decodeBase64(dbpass);
				String decodedTxt = new String(decoderBytes);
				
				if(Pass.equals(decodedTxt)) {
					x =1; //DB���� ������ ��й�ȣ�� ������������ �Ѿ�� ��й�ȣ�� ������
				}else {
					x= 0; //���̵�� ������ ��й�ȣ�� ��ġ���� ������
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(" ���̵�� �н����� ���� �� ���� �߻�");
		}finally {
			
		}
		
		return x;
	}
	
	
	//ȸ�����Խ� ���̵� �ߺ�üũ
	
	public int confimId (String u_id) {
		int x =-1; // ���̵����, �ߺ��� ���̵� �ƴϴ�.
				   // x = 1 > �ߺ��� ���̵� �ִ�.
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
			System.out.println("���̵� �ߺ�üũ�� ���ܹ߻�");
			
		}finally {
			
		}
		
		
		return x;
	}
	
	//ȸ������ DB���� �������� �޼ҵ�
	public UserDTO getUser (String u_id, String pass) {
		UserDTO user = null;
		
		try {
			String Pass = pass;
			
			String sql = "select * from user01 where u_id =?";
			psmt= con.prepareStatement(sql);
			psmt.setString(1, u_id);
			rs=psmt.executeQuery();
			
			if(rs.next()) { //�ش� ���̵� DB�� ����
				String dbpass = rs.getString("pass"); //DB�� �н�����
				
				byte[] decoderBytes = Base64.decodeBase64(dbpass);
				String decodedTxt = new String(decoderBytes);
				
				if (Pass.equals(decodedTxt)) {
					//DB�� pass�� ������ �Ѿ�� pass�� ������
					//DB���� select�� ���ڵ带 DTO��
					//Setter�����ؼ� ���� ��ȯ
					
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
					//DB�� pass�� ������ �Ѿ�� Pass�� �ٸ���
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ȸ������ �о� ������ ���� �߻�");
		}finally {
			
		}
		
		return user; //user :dto�� setter������ ����
	}
	
	//ȸ�� ���� ����ó�� : �������������� ������ ������ DB�� ���� �޼ҵ�
	
	
	
}
