<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src ="<c:url value="/resources/css/NewFile.css"/>">
</script>
</head>
<body>

<div class="container" onclick="onclick">
  <div class="top"></div>
  <div class="bottom"></div>
  <div class="center">
    <h2>Please Sign In</h2>
    <input type="email" placeholder="email"/>
    <input type="password" placeholder="password"/>
    <h2>&nbsp;</h2>
  </div>
</div>
</body>
</html>