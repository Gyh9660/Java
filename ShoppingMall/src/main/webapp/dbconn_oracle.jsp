
<%@ page import = "java.sql.*" %>

<%

	Connection conn = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url3 = "jdbc:oracle:thin:@localhost:1521:XE";
	
	Class.forName(driver);
	conn = DriverManager.getConnection (url3, "hr2", "1234");

%>