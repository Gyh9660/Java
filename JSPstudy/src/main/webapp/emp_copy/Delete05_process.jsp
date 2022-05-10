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
		//String ename = request.getParameter("ename");
		//String job = request.getParameter("job");
		//String manager = request.getParameter("manager");
		//String hiredate = request.getParameter("hiredate");
		//String salary = request.getParameter("salary");
		//String commission = request.getParameter("commission");
		//String dno = request.getParameter("dno");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try{
			sql ="select eno from emp_copy where eno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				String reno = rs.getString("eno");
				
				if(eno.equals(reno)){
					pstmt.close();
					sql = "delete emp_copy where eno = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, eno);
					pstmt.executeUpdate();
					
					out.println("테이블에서 해당 사원번호 : "+ eno +"가 잘 삭제 되었습니다.");
				}else{
					out.println("eno 가 일치 하지 않습니다.");
				}
			}else{
				out.println("해당 사원번호가 존재하지 않습니다.");
			}
		}catch(Exception ex){
			out.println(ex.getMessage());
		}finally{
			if (pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
		}


	%>
</body>
</html>