<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB의 내용을 가져와서 출력하기 MSSQL</title>
</head>
<body>
	
	<%@ include file = "dbconn_mssql.jsp" %>
	<table width = "800" border = "1">
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>업무</th>
			<th>상사번호</th>
			<th>입사일</th>
			<th>월급</th>
			<th>수당</th>
			<th>부서번호</th>
		</tr>
		
		<%
		ResultSet rs = null;
		Statement stmt = null;
		
		try{
			String sql = "SELECT * FROM emp_copy";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String eno = rs.getString("eno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String manager = rs.getString("manager");
				String hiredate = rs.getString("hiredate");
				String salary = rs.getString("salary");
				String commission = rs.getString("commission");
				String dno = rs.getString("dno");
				
			%>
			<tr>
				<td><%= eno %></td>
				<td><%= ename %></td>
				<td><%= job %></td>
				<td><%= manager %></td>
				<td><%= hiredate %></td>
				<td><%= salary %></td>
				<td><%= commission %></td>
				<td><%= dno %></td>
			</tr>
			<%	
			}
			
		}catch(Exception ex){
			out.println("테이블 호출하는데 실패 했습니다.");
			out.println(ex.getMessage());
		}finally{
			if (rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		
		
		%>
	
	</table>



</body>
</html>