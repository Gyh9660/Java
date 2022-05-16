<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*, java.util.*, java.text.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file ="dbconn_oracle.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//변수저장
		String na = request.getParameter("name");
		String em = request.getParameter("email");
		String sub = request.getParameter("subject");
		String cont = request.getParameter("content");
		String da = "to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')";
		
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
		String sql = null;
		Statement st = null;
		//ResultSet rs = null;
		
		int cnt = 0;
		
		try {
			sql = "insert into guestboard (name,email,inputdate,subject,content) values ('"+na+"','"+em+"',"+da+",'"+sub+"','"+cont+"')";
			st = conn.createStatement();
		
			cnt = st.executeUpdate(sql);
			
			
			if (cnt >0){
				out.println("데이터가 성공적으로 입력 되었습니다.");
			}else {
				out.println("데이터가 입력되지 않았습니다.");
			}
			
		}catch (Exception ex){
			out.println (ex.getMessage());
		}finally{
			//if (rs!=null)
				//rs.close();
			if (st!=null)
				st.close();
			if (conn!=null)
				conn.close();
		}
	%>	


<jsp:forward page ="blog_show.jsp" />
</body>
</html>