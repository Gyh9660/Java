<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*,java.util.*,java.text.*" %>

<% request.setCharacterEncoding("UTF-8"); %> <!-- Form에서 넘겨주는 한글을 처리 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form에서 넘겨 받은 값을 db에 insert 하는 페이지</title>
</head>
<body>
<%@ include file = "dbconn_oracle.jsp" %>	<!-- Connection 객체 -->
<%
	String na = request.getParameter("name");
	String em = request.getParameter("email");
	String sub = request.getParameter("subject");
	String cont = request.getParameter("content");
	String ymd = (new java.util.Date()).toLocaleString(); //현재 시스템의로 로케일(한국)
	cont =cont.replace("\r\n","<br>");
	cont =cont.replace(" ","&nbsp");
	
	int pos = 0;
	if (cont.length()==1){
		cont = cont + " ";
	}
	if (sub.length()==1){
		sub = sub + " ";
	}
	while ((pos = sub.indexOf("\'",pos)) != -1){ 
		String left = sub.substring(0,pos);
		String right = sub.substring(pos, sub.length());			
		sub = left + "\'" + right;
		pos +=2;
	}
	while ((pos = cont.indexOf("\'",pos)) != -1){ 
		String left = cont.substring(0,pos);
		String right = cont.substring(pos, cont.length());			
		cont = left + "\'" + right;
		pos +=2;
	}
	
	//폼에서 넘긴 변수가 잘 넘어오는지 확인
	
	/*
	out.println(na + "<p>");
	out.println(em + "<p>");
	out.println(sub + "<p>");
	out.println(cont + "<p>");
	out.println(ymd + "<p>");
	*/

	String sql = null;
	Statement st = null;	//Statment "
			//conn 객체에서 자동으로 커밋 구문이 적용되어 있음.
	int cnt = 0; //insert, update, delete가 잘 적용되었는지 확인
				 // cnt > 0 => insert, update, delete가 잘 적용
			
	try {
		sql = "insert into guestboard2 (name,email,inputdate,subject,content)";
		sql = sql+" values( '"+na+"','"+ em+"','"+ ymd;
		sql = sql+ "','"+sub+"','"+ cont+"')";
		
		st = conn.createStatement();	//st : statment 객체 활성화 (XE,hr2,1234)
		
		cnt = st.executeUpdate(sql); //insert, update, delete 문인 경우
		
		/*
		if (cnt >0){
			out.println("DB에 잘 insert 되었습니다.");
		}else{
			out.println("DB에 insert가 잘 되지 않았습니다.");
		}
		
		*/
		
		
	//	out.println(sql);
		
	//	if(true) return;
		
		
	}catch (Exception ex) {
		out.println(ex.getMessage());
	}finally{
		if(st != null)
			st.close();
		if(conn != null)
			conn.close();
		
	}

	
%>
<jsp:forward page = "dbgb_show.jsp"/>
</body>
</html>