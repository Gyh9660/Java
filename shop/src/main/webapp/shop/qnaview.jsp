<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery-1.11.0.min.js"></script>
<title>상세 정보 보기</title>
</head>
<script>
      function confirmModal() {
    	  var flag = confirm("글을 수정하시겠습니까?")
        if (flag == true) {
        	 
        	 window.location.href="../shop/edit.do?q_id=${param.q_id}"; 
        	/*
        	url = "../shop/pass.do?q_id=${param.q_id}";
        	data={
        			subject : $("input[name='subject']").val(),
        			content : $("input[name='content']").val(),
        	}
        	$.post(url,data,fuction(res){
        		
        	})
        	*/
        } else {
          console.log("취소.");
        }
      }
      function confirmModal2() {
    	  var flag2 = confirm("글을 삭제하시겠습니까?")
          if (flag2 == true) {
          	window.location.href="../shop/delete.do?q_id=${param.q_id}";
          } else {
            console.log("취소.");
          }
        }
      function confirmModal3() {
    	  var flag = confirm("답변을 작성하시겠습니까?")
        if (flag == true) {
        	 
        	 window.location.href="../shop/rwrite.do?q_id=${qdto.q_id}&mid=${qdto.masterid}&step=${qdto.step}&rnum=${qdto.replaynum}"; 
        } else {
          console.log("취소.");
        }
      }
</script>
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
	
	<hr style="width: 80%;height: 5px; background-color: black;">
	<br>
	<div style="width: 80%;height: 100px;font-size: 40px;">${qdto.subject }</div>
	
	<input type ="hidden" name ="subject" value="${qdto.subject }">
	<input type ="hidden" name ="content" value="${qdto.content }">
	<input type ="hidden" name ="q_id" value="${qdto.q_id }">
	<INPUT type="hidden" name="step" value="${qdto.step }">
   <INPUT type="hidden" name="mid" value="${qdto.masterid }">
   <INPUT type="hidden" name="rnum" value="${qdto.replaynum }">
	<table style="width:80%;border-collapse: collapse; background-color: white;"border="1">
	<!-- 게시글 정보 출력 -->
	<tr style="text-align: center;">
		<td style="width :15%">작성자</td><td style="width :15%"> ${qdto.u_id }</td>
		<td style="width :15%">작성일</td><td style="width :25%"> ${qdto.inputdate }</td>
		<td style="width :15%">조회수</td><td style="width :25%"> ${qdto.readcount }</td>
	</tr>

	<tr>
		<td style="text-align: center;">내용</td>
		<td colspan="7" height = "600"style="vertical-align: top;">${qdto.content }</td>
	</tr>
	
	<!-- 하단 메뉴 버튼 -->
	<c:choose>
		<c:when test="${u_id == qdto.u_id }">
			<tr>
				<td colspan="7" align ="center" style="height: 50px">
					<button type = "button" onclick ="confirmModal()">수정하기</button>
					<button type = "button" onclick ="confirmModal2()">삭제하기</button>
					<button type = "button" onclick ="location.href='../shop/list.do';">목록 바로가기</button>
				</td>
			</tr>
		</c:when>
		<c:when test="${u_id =='admin' }">
			<tr>
				<td colspan="7" align ="center" style="height: 50px">
					<button type = "button" onclick ="confirmModal3()">답변달기</button>
					<button type = "button" onclick ="confirmModal2()">삭제하기</button>
					<button type = "button" onclick ="location.href='../shop/list.do';">목록 바로가기</button>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="7" align ="center" style="height: 50px">
					<button type = "button" onclick ="location.href='../shop/list.do';">목록 바로가기</button>
				</td>
			</tr>
		</c:otherwise>
	</c:choose>
	
	
		
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>