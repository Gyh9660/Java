package pro;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class ProDAO extends DBConnPool{

	private static ProDAO pdao = new ProDAO();
	
	public static ProDAO getPdao() {
		return pdao;
	}
	
	public ProDAO() {
		super();
	}
	
	//insert 
	public int insertWrite (ProDTO pdto) {
		int result = 0 ; 
		try {
			String sql = "INSERT INTO pro ( "
					+ " p_id,p_name, p_type, price, image,stock,review) "
					+ " VALUES ("
					+ " seq_pro_num.nextval, ?, ?, ?, ?, ?, ?)"; 
			
		psmt = con.prepareStatement(sql);  //PareparedStatement 객체 생성 
		
		psmt.setString(1, pdto.getP_name());
		psmt.setString(2, pdto.getP_type());
		psmt.setInt(3, pdto.getPrice());
		psmt.setString(4, pdto.getImage());
		psmt.setInt(5, pdto.getStock());
		psmt.setString(6, pdto.getReview());
		
		result = psmt.executeUpdate();  //insert가 성공일때 result > 0   //DB 에 값을 저장 
		
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품 입력중 예외 발생");
		}
			
		return result; 		// result : Insert 성공시 > 0 , 실패시 : 0 
	}
	//delete
	public int deletePost(int p_id) {
		int result = 0;
		try {
			String sql = "DELETE pro WHERE p_id =?";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, p_id);
			
			result = psmt.executeUpdate(); //result 가 0보다 크면 삭제성공, =0 : 삭제 실패
					
		}catch(Exception e) {
			System.out.println("delete시 예외 발생");
			e.printStackTrace();
		}
		
		
		return result;
	}
	//update
	public int updatePost (ProDTO qdto) {
		int result=0;
		
		try {
			String query = "UPDATE pro "
					+ " SET p_name = ? , p_type = ? , price = ?, image = ?, stock = ? "
					+ " WHERE p_id = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, qdto.getP_name());
			psmt.setString(2, qdto.getP_type());
			psmt.setInt(3, qdto.getPrice());
			psmt.setString(4, qdto.getImage());
			psmt.setInt(5, qdto.getStock());
			psmt.setInt(6, qdto.getP_id());
			
			result = psmt.executeUpdate();	//update 성공할때 result 변수값이 0보다 커진다.
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("상품 수정중 예외 발생");
		}
		
		
		
		return result; // result >0 : 수정성공 , result = 0 : 수정실패
	}
	
	
	
	//select
	//검색 조건에 맞는 게시물 개수를 반환합니다. 
		public int selectCount( Map<String, Object> map ) {
			int totalCount = 0; 
			String query = "SELECT COUNT(*) FROM pro";    //레코드의 총갯수 반환 ,  
				if (map.get("searchWord") != null) {			// 검색기능을 사용했을시 where 
					query += " Where " + map.get("searchField") + " " + "like '%" + map.get("searchWord") + "%'"; 
				}
			try {
				stmt = con.createStatement(); 
				rs = stmt.executeQuery(query);
				rs.next(); 
				totalCount = rs.getInt(1); 
				
			} catch (Exception e) {
				System.out.println("상품 카운트중 예외 발생");
				e.printStackTrace();
			}
						
			return totalCount; 
		}
	
		public List<ProDTO> selectListPage(Map<String,Object> map) {
	        List<ProDTO> board = new Vector<ProDTO>();
	        String query = " "
	                     + "SELECT * FROM ( "
	                     + "    SELECT Tb.*, ROWNUM rNum FROM ( "
	                     + "        SELECT * FROM pro ";

	        if (map.get("searchWord") != null)
	        {
	            query += " WHERE " + map.get("searchField")
	                   + " LIKE '%" + map.get("searchWord") + "%' ";
	        }

	        query += "        ORDER BY p_id DESC "
	               + "    ) Tb "
	               + " ) "
	               + " WHERE rNum BETWEEN ? AND ?";
	        
	        //System.out.println(query); //콘솔에 전체쿼리를 출력

	        try {
	            psmt = con.prepareStatement(query);
	            psmt.setString(1, map.get("start").toString());
	            psmt.setString(2, map.get("end").toString());
	            rs = psmt.executeQuery();

	            while (rs.next()) {
	                ProDTO pdto = new ProDTO();

	                pdto.setP_id(rs.getInt(1));
	                pdto.setP_name(rs.getString(2));
	                pdto.setP_type(rs.getString(3));
	                pdto.setP_date(rs.getTimestamp(4));
	                pdto.setPrice(rs.getInt(5));
	                pdto.setImage(rs.getString(6));
	                pdto.setStock(rs.getInt(7));
	                pdto.setReview(rs.getString(8));
	              
	                board.add(pdto);
	            }
	        }
	        catch (Exception e) {
	            System.out.println("상품 조회 중 예외 발생");
	            e.printStackTrace();
	        }
	        return board;
	    }
	
		public ProDTO selectView(int p_id) {
	    	ProDTO pdto = new ProDTO();
	    	String query = "SELECT * FROM pro WHERE p_id = ?";
	    	
	    	try {
	    		psmt = con.prepareStatement(query);
	    		psmt.setInt(1, p_id);
	    		rs = psmt.executeQuery();
	    		
	    		if(rs.next()) {
	    			pdto.setP_id(rs.getInt(1));
	                pdto.setP_name(rs.getString(2));
	                pdto.setP_type(rs.getString(3));
	                pdto.setP_date(rs.getTimestamp(4));
	                pdto.setPrice(rs.getInt(5));
	                pdto.setImage(rs.getString(6));
	                pdto.setStock(rs.getInt(7));
	                pdto.setReview(rs.getString(8));
	    		}
	    	}catch (Exception e) {
				System.out.println("상품 상세정보 출력중 예외 발생");
				e.printStackTrace();
			}
	    	
	    	return pdto;
	    }
		
		
		
}
