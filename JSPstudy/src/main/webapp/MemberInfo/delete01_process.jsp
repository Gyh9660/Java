<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼에서 넘겨 받은 값을 DB에서 삭제 </title>
</head>
<body>

<%@ include file = "dbconn_oracle.jsp" %>

<%
	request.setCharacterEncoding("UTF-8"); //폼에서 넘긴 한글처리하기 위해서
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");

	Statement stmt = null;	//Statement 객체 : SQL쿼리 구문을 담아서 실행하는 객체
	ResultSet rs = null;
	String sql = null; //전역 변수
	
	try{
		//레코드 삭제 , 폼에서 넘긴 ID, Passwd와 DB의 ID와 Passwd가 일치할때 레코즈 제거, id(primary key)
		sql = "select id, pass from mbTbl where id = '" + id + "'";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
	
		if (rs.next()){ //ID가 존재할때
			//rs의 결과 레코드를 변수에 할당.
			String rId = rs.getString("id");
			String rPass = rs.getString("pass");
			
			//패스워드가 일치하는지 확인
			if (passwd.equals(rPass)){ //폼의 password와 DB의 password가 일치할때
				sql = "delete mbTbl where id = '"+id+"'";
				stmt.executeUpdate(sql);
				
				out.println("테이블에서 해당 아이디 : "+ id +"가 잘 삭제 되었습니다.");
				//out.println(sql);
			}else{
				out.println("패스워드가 일치 하지 않습니다.");
			}
			
		}else { //ID가 존재하지 않을때
			out.println ("해당 아이디는 존재하지 않습니다.");
		}
		
		
		//out.println(sql);
		
						
	}catch(Exception ex){
		out.println(ex.getMessage());

	}finally{
		if (stmt != null)
			stmt.close();
		if(conn != null)
			conn.close();
		if(rs != null)
			rs.close();
	}
	
%>

</body>
</html>