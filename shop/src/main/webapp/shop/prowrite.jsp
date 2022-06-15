<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2 style="text-align: center;">상품 등록</h2>
	<br>
	<br>
	<br> 
	<hr style="width: 80%;height: 5px; background-color: black;">
	<br>
<form name="writeFrm" method="post" enctype="multipart/form-data" action="../shop/pwrite.do" onsubmit="return validateForm(this)">
	
	<table  style ="width:80%;border-collapse: collapse; background-color: white;" border="1">
		<tr style="height: 15px"></tr>
		<tr style="border:none">
			<td style ="width:15%; text-align: center;border:none"> 상품명 </td>
			<td style="border:none"> <input type="text" name="p_name" style="width:20%;"></td>
		</tr>
		<tr style="height: 30px;border:none"></tr>
		<tr style="border:none">
			<td style ="width:15%; text-align: center;border:none"> 분류 </td>
			<td style="border:none" > <select name="type" style="width:20%;">
                <option value="Switch 하드웨어">Switch 하드웨어</option>
                <option value="Switch 소프트웨어">Switch 소프트웨어</option>
                <option value="Switch 주변기기">Switch 주변기기</option>
                <option value="3DS 하드웨어">3DS 하드웨어</option>
                <option value="3DS 소프트웨어">3DS 소프트웨어</option>
                <option value="3DS 주변기기">3DS 주변기기</option>
                <option value="액세서리 (switch)">액세서리 (Switch)</option>
                <option value="액세서리 (3ds)">액세서리 (3DS)</option>
                <option value="액세서리 (굿즈)">액세서리 (굿즈)</option>
            	</select>
			</td>
		</tr>
		<tr style="height: 30px;border:none"></tr>
		<tr style="border:none">
			<td style ="width:15%; text-align: center;border:none"> 가격 </td>
			<td style="border:none"> <input type="text" name="price" style="width:20%;" ></td>
		</tr>
		<tr style="height: 30px;border:none"></tr>
		<tr style="border:none">
			<td style ="width:15%; text-align: center;border:none"> 상품 이미지 </td>
			<td style="border:none"><input type="file" name="image" style="width:80%;"/></td>
		</tr>
		<tr style="height: 30px;border:none"></tr>
		<tr style="border:none">
			<td style ="width:15%; text-align: center;border:none"> 재고 </td>
			<td style="border:none"><input type="text" name="stock" style="width:20%;" > </td>
		</tr>
		<tr style="height: 30px;border:none"></tr>
		<tr style="border:none">
			<td colspan="2" align="center" style="border:none">
				<button type="submit"> 작성 완료 </button>
				<button type="reset"> RESET </button>
				<button type="button" onclick="history.back()" > 이전 페이지 </button>
			</td>
		</tr>
		<tr style="height: 15px"></tr>
	</table>

</form>
<%@ include file = "footer.jsp" %> 
</body>
</html>