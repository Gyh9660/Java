
<%@ page import = "java.sql.*" %>

<%

	Connection conn = null;
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	// MSSQL 드라이버 
	String url2 = "jdbc:sqlserver://localhost:1433;DatabaseName=myDB";
	
	Class.forName(driver);
	conn = DriverManager.getConnection (url2, "sa", "1234");

%>