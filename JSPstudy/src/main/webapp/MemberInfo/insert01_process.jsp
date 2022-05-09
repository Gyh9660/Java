<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼에서 넘겨 받은 값을 DB에 저장하는 파일</title>
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
	
	try{
		String sql = "INSERT INTO mbTbl (idx,id,pass,name,email) VALUES (seq_mbTbl_idx.nextval,'"+id+"','"+passwd+"','"+name+"','"+email+"')";
		
		stmt = conn.createStatement(); //connection 객체를 통해서 statement객체 생성
		stmt.executeUpdate(sql); 	//statement객체를 통해서 sql을 실행함
				//stmt.executeUpdate (sql) : sql<== insert,update,delete문이 온다.
				//stmt.excuteQuery(sqp) : sql <== select 문이 오면서 Resultset 객체로 변환
		
		out.println("테이블 삽입에 성공 했습니다.");
				
				
				
	}catch(Exception ex){
		out.println("mbTbl 테이블 삽입을 실패 했습니다.");
		out.println(ex.getMessage());
		
	}finally{
		if (stmt != null)
			stmt.close();
		if(conn != null)
			conn.close();
	}
	
	
%>
<p>
<p>
<p>
</body>
</html>