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
	
	
	//insert ȸ�����Խ� DB�� �����Է�
	
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
				
				if(Pass.equals(dbpass)) {
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
	
	
	
}
