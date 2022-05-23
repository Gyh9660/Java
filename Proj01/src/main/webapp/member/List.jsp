<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h2> 게시판 List</h2>
	
	<table border = "1" style ="width:90%">
		<tr>
            <th width="15%">ID</th>
            <th width="15%">PWD</th>
            <th width="10%">NAME</th>
            <th width="20%">EMAIL</th>
            <th width="40%">JOIN DATE</th>
        </tr>
<c:choose>    
    <c:when test="${ empty boardLists }">  <!-- 게시물이 없을 때 -->
        <tr>
            <td colspan="6" align="center">
                등록된 정보가 없습니다.
            </td>
        </tr>
    </c:when>
    <c:otherwise>  <!-- 게시물이 있을 때 -->
        <c:forEach items="${ boardLists }" var="row" varStatus="loop">    
        <tr align="center">
            <td>${ row.id }</td> 
            <td>${ row.pwd }</td>
            <td>${ row.name }</td>
            <td>${ row.email }</td>
            <td>${ row.joinDate }</td>
        </tr>
        </c:forEach>        
    </c:otherwise>    
</c:choose>
	</table>
	<table style ="width:90%">
        <tr align="right">
            <td width="200px"><button style ="width:100px" type="button"
                onclick="location.href='../member/write.do';">글쓰기</button>
                <button style ="width:100px" type="button" onclick ="location.href='../member/delete.do';">
            삭제하기</button>
                </td>
        </tr>
    </table>
	
	
	
	
</body>
</html>