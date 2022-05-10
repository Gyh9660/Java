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
<%@ include file="dbconn_oracle.jsp" %>

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
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try{
			sql ="select eno from emp_copy where eno = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				String reno = rs.getString("eno");
				
				if(eno.equals(reno)){
					sql = "update emp_copy set ename = ? , job = ? , manager = ? , hiredate = ? , salary = ? , commission = ? , dno = ? where eno = ? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ename);
					pstmt.setString(2, job);
					pstmt.setString(3, manager);
					pstmt.setString(4, hiredate);
					pstmt.setString(5, salary);
					pstmt.setString(6, commission);
					pstmt.setString(7, dno);
					pstmt.setString(8, eno);
					
					pstmt.executeUpdate();
				
					out.println("테이블의 내용이 잘 수정되었습니다.");
				}else { 
					out.println("사원번호가 일치 하지 않습니다.");
				}
			}else { 
				out.println(eno + "해당 eno가 DB에 존재하지 않습니다.");
			}
			
		}catch(Exception ex){
			out.println(ex.getMessage());
		}finally{
			if (rs != null)	
				rs.close();
			if (pstmt != null)
				pstmt.cancel();
			if (conn != null)
				conn.close();
		}
	
	
	
	%>
	
</body>
</html>