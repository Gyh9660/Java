<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA</title>
<style>
a {
	text-decoration: none;
}
</style>
<script>
function check(){                 
	   alert("로그인 후 이용이 가능합니다.");                       
	   return false;
}
</script>
</head>
<body>
	
	<%@ include file="header.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h2 style="text-align: center;">문의 게시판</h2>
	<br>
	<br>
	<br>
	<!-- 검색 폼 -->
	<hr style="width: 80%;height: 5px; background-color: black;">
	<br>
	<form method="get">
		<table  style="width:80%;background-color: skyblue;">
			<tr>
				<td align="center"><select name="searchField">
						<option value="subject">제목</option>
						<option value="content">내용</option>
						<option value="u_id">작성자</option>
				</select> <input type="text" name="searchWord" /> <input type="submit"
					value="검색하기" /></td>
			</tr>
		</table>
	</form>

	<!-- 목록 테이블 -->
	<table border="1" style="width:80%;background-color: white;">
		<tr>
			<th width="10%">번호</th>
			<th width="*">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
		<c:choose>
			<c:when test="${ not empty boardLists }">
				<c:forEach items="${ boardLists }" var="row" varStatus="loop">
					<tr align="center">
						<td>
							${ map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index)}
						</td>
						<c:choose>
						<c:when test="${row.step >0 }">
						<td align="left">
							<a href="../shop/view.do?q_id=${ row.q_id }">&nbsp;&nbsp;==>&nbsp;&nbsp;${ row.subject }</a>
						</td>
						</c:when>
						<c:when test="${row.step ==0 }">
						<td align="left">
							<a href="../shop/view.do?q_id=${ row.q_id }">&nbsp;&nbsp;${ row.subject }</a>
						</td>
						</c:when>
						</c:choose>
						<td>${ row.u_id }</td>
						<td>${ row.readcount }</td>
						<td>${ row.inputdate }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
				</tr>
				
			</c:otherwise>
		</c:choose>
	</table>

	<!-- 하단 메뉴(바로가기, 글쓰기) -->
	<c:choose>
		<c:when test="${ empty u_id }">
			<table  style="width:80%;background-color: skyblue;">
			<tr align="center">
				<td style="font-size: 20px">${ map.pagingImg }</td>
				<td width="100"><button type="button" onclick="check()">글쓰기</button></td>
			</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table  style="width:80%;background-color: skyblue;">
				<tr align="center">
					<td style="font-size: 20px;">${ map.pagingImg }</td>
					<td width="100"><button type="button" onclick="location.href='../shop/write.do';">글쓰기</button></td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	<%@ include file="footer.jsp"%>
</body>
</html>