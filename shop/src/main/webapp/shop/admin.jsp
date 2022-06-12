<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-1.11.0.min.js"></script>
</head>
<body>
<%@ include file = "header.jsp" %>   
 <br>
	<br>
	<br>
	<br>
	<br>
	<br> 
	<h2 style="text-align: center;">관리자 페이지</h2>
	<br>
	<br>
	<br> 
	<hr style="width: 80%;height: 5px; background-color: black;">
	<br>
	
	<div style="width: 80%;">
	<ul style="float: cneter;">
		<li style="float: left; margin: 10px"><a href = "../shop/pwrite.do">상품등록</a></li>
		<li style="float: left; margin: 10px"><a href = "#">회원관리</a></li>
		<li style="float: left; margin: 10px"><a href = "#">주문관리</a></li>
	</ul>
	</div>
		<c:forEach items="${ boardLists }" var="row" varStatus="loop">
			<tr align="center">
				<td>
					${ map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index)}
				</td>
				
				<td align="left">
					<a href="../shop/view.do?q_id=${ row.q_id }">&nbsp;&nbsp;${ row.subject }</a>
				</td>
				<td>${ row.u_id }</td>
				<td>${ row.readcount }</td>
				<td>${ row.inputdate }</td>
			</tr>
		</c:forEach>
	<table>
	<tr>
	<th rowspan=4>
	<a href =JavaScript:viwe("");></a>
	</th>
	</tr>
	</table>
<%@ include file = "footer.jsp" %> 
</body>
</html>