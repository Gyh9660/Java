<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품</title>
<style>
a {
	text-decoration: none;
}
</style>
<script>
function view(temp) {
	if (temp.length >0) { 
 		url = "/shop/Uploads/" + temp;
		window.open(url, "win", "height=350,width=450,toolbar=0,menubar=0,scrollbars=1,resizable=1,status=0");
	}
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

	<h2 style="text-align: center;">
		<a href="../shop/plist.do?searchField=p_type&searchWord=${map.get('searchWord')}">${map.get("searchWord") }</a>
	</h2>
	
	<br>
	<br>
	<br>
	<!-- 검색 폼 -->
	<hr style="width: 100%; height: 5px; background-color: black;">
	<br>
	<br>
	<form method="get">
		<table  style="width:100%;background-color: skyblue;">
			<tr>
				<td align="center"><select name="searchField">
						<option value="p_name">제목</option>
				</select> <input type="text" name="searchWord" /> <input type="submit"
					value="검색하기" /></td>
			</tr>
		</table>
	</form>
	<div style="width: 100%;">
		<ul style="float: cneter;">
			<li style="float: left; margin: 10px"><a href="../shop/plist.do?searchField=p_type&searchWord=Switch 하드웨어">하드웨어</a></li>
			<li style="float: left; margin: 10px"><a href="../shop/plist.do?searchField=p_type&searchWord=Switch 소프트웨어">소프트웨어</a></li>
			<li style="float: left; margin: 10px"><a href="../shop/plist.do?searchField=p_type&searchWord=Switch 주변기기">주변기기</a></li>
		</ul>
	</div>
	<br>
	<br>
	<br>
	<c:choose>
		<c:when test="${ not empty boardLists }">
			<c:forEach items="${ boardLists }" var="row" varStatus="loop">
				<section>
					<div class="contents">
						<div class="otherwrap">
							<ul>
								<li>
									<div class="sale"
										style="background-color: #F8F8FF; width: 28%; float: left; margin-left: 5%; margin-top: 5%;
										 margin-bottom: 5%;">
										<a href="JavaScript:view(&quot;${row.image}&quot;)"> <img
											border=0 width=100% height=300
											src="${pageContext.request.contextPath }/Uploads/${row.image}" />
										</a>

										<pre style="text-align: center">${row.p_type }<a
												href="#"><h4>${row.p_name }</h4></a>${row.p_date }
가격: ${row.price }원</pre>
									</div>
								</li>
							</ul>

						</div>
					</div>
				</section>

			</c:forEach>
		</c:when>
		<c:otherwise>
			<br>
			<br>
			<br>
			<br>
			<br>
			<div>
				<h1 style="text-align: center">등록된 게시물이 없습니다.</h1>
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
		</c:otherwise>
	</c:choose>

	<!-- 하단 메뉴(바로가기, 글쓰기) -->
	<table style="width: 100%; background-color: skyblue;">
		<tr align="center">
			<td style="font-size: 20px;">${ map.pagingImg }</td>
		</tr>
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>