package qna;

import java.sql.Connection;

import common.DBConnPool;

public class QnaDAO extends DBConnPool{

	private static QnaDAO qdao = new QnaDAO();
	
	public static QnaDAO getQdao() {
		return qdao;
	}
	
	private QnaDAO() {
		super();
	}
	
	//insert
	
	public void insertQna (QnaDTO Qna) {
		try {
			String sql = "insert into qnaboard values(seq_qna_num.nextval,?,?,?,?,?,?,?,?";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Qna.getU_id());
			psmt.setString(2, Qna.getSubject());
			psmt.setString(3, Qna.getContent());
			psmt.setTimestamp(4, Qna.getInputdate());
			psmt.setInt(5, Qna.getReadcount());
			psmt.setInt(6, Qna.getMasterid());
			psmt.setInt(7, Qna.getReplaynum());
			psmt.setInt(8, Qna.getStep());
			
			psmt.executeUpdate();
			
			System.out.println("qna 등록 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("qna insert중 예외발생");
		}finally {
			
		}
	}
	
	//delete
	public int deleteQna(QnaDTO Qna) { //idx안하고 DTO로받아도 되는지?
		int result = 0;
		try {
			
			String sql = "DELETE qnaboard WHERE q_id =?";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, Qna.getQ_id());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete 중 예외 발생");
		}finally {
			
		}
		return result;
	}
	//update
	public int updateQna(QnaDTO Qna) {
		int result =0;
		try {
			String sql ="update qnaboard"
					+ "set subject = ? , content = ? "
					+ " where q_id = ? and u_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Qna.getSubject());
			psmt.setString(2, Qna.getContent());
			psmt.setInt(3, Qna.getQ_id());
			psmt.setString(4, Qna.getU_id());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("update중 예외발생");
		}
		
		return result;
	}
	
	
	//select(list)
	
	//select(상세보기)
	
}
