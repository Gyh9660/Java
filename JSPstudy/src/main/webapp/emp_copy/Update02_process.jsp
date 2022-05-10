<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="dbconn_mssql.jsp" %>
		<%
		request.setCharacterEncoding("UTF-8");
		String eno = request.getParameter("eno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String manager = request.getParameter("manager");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String commission = request.getParameter("commission");
		String dno = request.getParameter("dno");
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try{
			sql = "SELECT eno from emp_copy where eno = "+eno;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				String reno = rs.getString("eno");
				
				if(eno.equals(reno)){
					sql = "update emp_copy set ename = '"+ename+"', job = '"+job+"' , manager = "+manager+", hiredate = '"+hiredate+"', salary = "+salary+", commission = "+commission+" , dno = "+dno+" where eno = "+eno;
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					out.println("테이블의 내용이 잘 수정되었습니다.");
				}else{
					out.println("사원번호가 일치하지 않습니다.");
				}
			}else{
				out.println(eno + "해당 eno가 DB에 존재하지 않습니다.");
			}
			
		}catch(Exception ex){
			out.println(ex.getMessage());
		}finally{
			if (rs != null)	
				rs.close();
			if (stmt != null)
				stmt.cancel();
			if (conn != null)
				conn.close();
		}
		
		%>
</body>
</html>