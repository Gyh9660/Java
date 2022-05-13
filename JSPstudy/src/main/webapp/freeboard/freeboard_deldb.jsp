<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file = "dbconn_oracle.jsp" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href = "filegb.css" rel = "stylesheet" type ="text/css">
<title>글 삭제 (실제 DataBase에 삭제를 처리하는 페이지)</title>
</head>
<body>
	<a href = "freeboard_list.jsp?go=<%= request.getParameter("page")%>">[게시판 목록으로 이동]</a>
	<p><p>
	<%
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;		//delete가 잘되었는지 확인 하는 변수
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		try{
			sql = "select * from freeboard where id = ?"; //DB의 비밀번호와 폼으로 넘겨온 비밀번호 확인
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
			
			if (!(rs.next())){
				out.println ("해당 내용은 존재하지 않습니다, ");
				
			}else {
				//존재하는 경우는 Password를 확인후 맞으면 삭제
				
				String pwd = rs.getString("password");
				int re = rs.getInt("replaynum");
				if (pwd.equals(request.getParameter("password"))){
					if(re == 0){
						sql = "delete freeboard where masterid in (select masterid from freeboard where id = ?)";
						// replaynum 문제해결 해야함  if로 0이면 다삭제 else 자기와 같은것만 삭제
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, id);
						cnt = pstmt.executeUpdate();						
					}else if (re != 0){
						sql = "delete freeboard where masterid in (select masterid from freeboard where id = ?) and replaynum = ?";
						// replaynum 문제해결 해야함  if로 0이면 다삭제 else 자기와 같은것만 삭제
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, id);
						pstmt.setInt(2, re);
						cnt = pstmt.executeUpdate();
					}
					
					if(cnt>0){
						out.println("잘 삭제 되었습니다.");
					}else {
						out.println (" 해당 내용은 삭제되지 않앗습니다.");
					}
					
				}else {
					out.println ("비밀 번호가 틀렸습니다.");
				}
				
				
			}
			
			
			
			
		}catch(Exception ex){
			out.println(ex);
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		
	%>
	
	
	

</body>
</html>