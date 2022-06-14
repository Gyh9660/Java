package qna;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class QnaDAO extends DBConnPool{

	private static QnaDAO qdao = new QnaDAO();
	
	public static QnaDAO getQdao() {
		return qdao;
	}
	
	public QnaDAO() {
		super();
	}
	
	/*
	psmt.setTimestamp(4, Qna.getInputdate());
	psmt.setInt(5, Qna.getReadcount());
	psmt.setInt(6, Qna.getMasterid());
	psmt.setInt(7, Qna.getReplaynum());
	psmt.setInt(8, Qna.getStep());
	*/
	//insert
	
	public void insertQna (QnaDTO Qna) {
		try {
			String sql = "insert into qnaboard (q_id,u_id,subject,content,masterid,replaynum,step) values(seq_qna_num.nextval,?,?,?,seq_qna_num.currval,?,?)";
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Qna.getU_id());
			psmt.setString(2, Qna.getSubject());
			psmt.setString(3, Qna.getContent());
			psmt.setInt(4, Qna.getReplaynum());
			psmt.setInt(5, Qna.getStep());
			psmt.executeUpdate();
			
			System.out.println("qna 등록 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("qna insert중 예외발생");
		}finally {
			
		}
	}
	
	//delete
	public int deleteQna(int q_id) { //idx안하고 DTO로받아도 되는지?
		int result = 0;
		try {
			
			String sql = "DELETE qnaboard WHERE q_id =?";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, q_id);
			
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
					+ " set content = ? "
					+ " where q_id = ? and u_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Qna.getContent());
			psmt.setInt(2, Qna.getQ_id());
			psmt.setString(3, Qna.getU_id());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("update중 예외발생");
		}
		
		return result;
	}
	
	
	//select(list)
	public int selectCount( Map<String, Object> map ) {
		int totalCount = 0; 
		String sql = "SELECT COUNT(*) FROM qnaboard";    //레코드의 총갯수 반환 ,  
			if (map.get("searchWord") != null) {			// 검색기능을 사용했을시 where 
				sql += " Where " + map.get("searchField") + " " + "like '%" + map.get("searchWord") + "%'"; 
			}
		try {
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(sql);
			rs.next(); 
			totalCount = rs.getInt(1); 
			
		} catch (Exception e) {
			System.out.println("게시물 카운트중 예외 발생");
			e.printStackTrace();
		}
					
		return totalCount; 
	}
	
	
	
	
	//검색 조건에 맞는 게시물 목록을 반환합니다.
		//DataBase에서 Select 한 결과 값을  DTO에 담아서 리턴 시켜줌.  
    public List<QnaDTO> selectListPage(Map<String,Object> map) {
        List<QnaDTO> board = new Vector<QnaDTO>();
        String sql = " "
                     + "SELECT * FROM ( "
                     + "    SELECT Tb.*, ROWNUM rNum FROM ( "
                     + "        SELECT * FROM qnaboard ";

        if (map.get("searchWord") != null)
        {
            sql += " WHERE " + map.get("searchField")
                   + " LIKE '%" + map.get("searchWord") + "%' ";
        }

        sql += "        ORDER BY masterid DESC, replaynum, step, q_id"
               + "    ) Tb "
               + " ) "
               + " WHERE rNum BETWEEN ? AND ?";
        
        //System.out.println(sql); //콘솔에 전체쿼리를 출력

        try {
        	psmt = con.prepareStatement(sql);
            psmt.setString(1, map.get("start").toString());
            psmt.setString(2, map.get("end").toString());
            rs = psmt.executeQuery();
            
           //System.out.println(map.get("start"));
           // System.out.println( map.get("end"));
            
            while (rs.next()) {
                QnaDTO qdto = new QnaDTO();
                
                qdto.setQ_id(rs.getInt(1));
                qdto.setU_id(rs.getString(2));
                qdto.setSubject(rs.getString(3));
                qdto.setContent(rs.getString(4));
				qdto.setInputdate(rs.getTimestamp(5));
				qdto.setReadcount(rs.getInt(6));
				qdto.setMasterid(rs.getInt(7));
				qdto.setReplaynum(rs.getInt(8));
				qdto.setStep(rs.getInt(9));
              
                /*
                System.out.println("DB에서가져온값" + rs.getString(1));
                System.out.println("DB에서 가져온값" + rs.getString(2));
                
                System.out.println("=========================");
                System.out.println("DTO 에서 가져온값 " +dto.getIdx());
                System.out.println("DTO 에서 가져온값 " +dto.getName());
                */
                board.add(qdto);
            }
        }
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }
       // System.out.println(board);
        return board;
    }
	//select(상세보기)
	public QnaDTO selectView(int q_id) {
		QnaDTO qdto = new QnaDTO();
		String sql = "select * from qnaboard where q_id = ?";
		
		try {
			psmt= con.prepareStatement(sql);
			psmt.setInt(1, q_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				qdto.setQ_id(rs.getInt(1));
				qdto.setU_id(rs.getString(2));
				qdto.setSubject(rs.getString(3));
				qdto.setContent(rs.getString(4));
				qdto.setInputdate(rs.getTimestamp(5));
				qdto.setReadcount(rs.getInt(6));
				qdto.setMasterid(rs.getInt(7));
				qdto.setReplaynum(rs.getInt(8));
				qdto.setStep(rs.getInt(9));
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("상세보기중 예외 발생"); 
		}finally {
			
		}
		return qdto;
	}
	
	//주어진 일련 번호에 해당하는 게시물의 조회수를 1증가시킴.
    public void updateVisitCount(int q_id) {
    	String sql = "UPDATE qnaboard SET "
    			+ " readcount = readcount+1 "
    			+ " WHERE q_id = ? ";
    	
    	try {
    		psmt = con.prepareStatement(sql);
    		psmt.setInt(1, q_id);
    		psmt.executeUpdate();
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("게시물 조회수 증가시 예외 발생");
    	}
    	
    	
    }
    
    public void insertRwrite(QnaDTO qna) {
    	int mid = qna.getMasterid();
		int rnum= qna.getReplaynum();
		int step = qna.getStep() + 1;
		int q_id =qna.getQ_id();
		System.out.println(mid);
		System.out.println(rnum);
		System.out.println(step);
		System.out.println(q_id);
		if (step == 1) {
	    try {
	    	String sql = "select max(q_id) from  qnaboard";
	    	psmt =con.prepareStatement(sql);   
	    	rs = psmt.executeQuery();
	    	   if (!(rs.next())) 
	    	    q_id=1;
	    	   else {
	    	    q_id= rs.getInt(1) + 1 ;
	    	    rs.close();
	    	   }       
	    	 sql = "select max(replaynum) from qnaboard where masterid="+mid;
	    	
			psmt = con.prepareStatement(sql);
			rs= psmt.executeQuery();
			
			if (!(rs.next())) 
				rnum=1;
			else 
				rnum=rs.getInt(1)+1;
			sql = "insert into qnaboard (q_id,u_id,subject,content,masterid,replaynum,step) values(?,?,?,?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, q_id);
			psmt.setString(2, qna.getU_id());
			psmt.setString(3, qna.getSubject());
			psmt.setString(4, qna.getContent());
			psmt.setInt(5, mid);
			psmt.setInt(6, rnum);
			psmt.setInt(7, step);
			psmt.executeUpdate();
			
			System.out.println("qna 등록 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   } 
		
    }
    
}
