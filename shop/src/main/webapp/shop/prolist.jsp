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
//http://localhost:9494
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
	 <div class="switch"><h1><a href="#">Switch</a></h1>
            <ul class="sw">
                <li><a href="#">하드웨어</a></li>
                <li><a href="#">소프트웨어</a></li>
                <li><a href="#">주변기기</a></li>
            </ul>
            <p><button class="b">판매자추천순</button> | <button class="b">인기도순</button> | <button class="b">평점높은순</button> | <button class="b">최신등록순</button></p>
        </div>
		<c:choose>
			<c:when test="${ not empty boardLists }">
				<c:forEach items="${ boardLists }" var="row" varStatus="loop">
				 <section>
			        <div class="contents">
			            <div class="otherwrap">
			                <ul>
			                	<li>
					                <div class="sale">
					                    <a href="JavaScript:view(&quot;${row.image}&quot;)">
					                        <img border=0 width=70 height=70 src="C:\Users\K\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\shop\Uploads\"${row.image}/>
					                    </a>
					                    <pre>             [Nintendo Switch]
					                        <a href="#"><h4>말랑말랑 두뇌학원</h4></a>
					                                          2022.03.20 "C:\Users\K\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\shop\Uploads\"${row.image}
					                                             20000원
					                    </pre>
					                </div>
			                	</li>
			                </ul>
			                
			            </div>
			        </div>
			    </section>	
								
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
				</tr>
				
			</c:otherwise>
		</c:choose>

	<!-- 하단 메뉴(바로가기, 글쓰기) -->
			<table  style="width:80%;background-color: skyblue;">
				<tr align="center">
					<td style="font-size: 20px;">${ map.pagingImg }</td>
					<td width="100"><button type="button" onclick="location.href='../shop/write.do';">글쓰기</button></td>
				</tr>
			</table>
	<%@ include file="footer.jsp"%>
</body>
</html>