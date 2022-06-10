<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="../css/reg.css"/>
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="reg.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
 <%@ include file = "header.jsp" %>     
 <section>
        <form method="post" action="" name = "frm" id ="frm">
            <div class="container">
            <div class="insert">
                <table>
                    <caption><h2>회원가입</h2></caption>
                    <tr>
                        <th class="col1">이름</th>
                        <td class="col2"><input type="text" name="u_name" maxlength="5" id ="u_name" autofocus></td>
                    </tr>
                    <tr>
                        <th class="col1">아이디</th>
                        <td class="col2">
                            <input type="text" name="u_id" maxlength="10" id="u_id" onkeyup="idCorrect()">
                            <input class="but1" type="button" value="중복확인" id = "checkId">
                        </td>
                    </tr>
                    <tr>
                        <th class="col1">비밀번호</th>
                        <td class="col2">
                            <input type="password" name="pass" maxlength="16" id="pass" >
                            <p>※비밀번호는 <span class="num">문자, 숫자, 특수문자의 조합6 ~ 16자리</span>로 입력이 가능합니다.</p>
                        </td>
                    </tr>
                    <tr>
                        <th class="col1">비밀번호 확인</th>
                        <td class="col2"><input type="password" name="repass" maxlength="16" id="repass" ></td>
                    </tr>
                    <tr>
                        <th class="col1">휴대전화</th>
                        <td class="col2">
                            <select name="phone" id ="phone">
                                <option value="basic" selected>---</option>
                                <option value="010">010</option>
                                <option value="011">011</option>
                                <option value="016">017</option>
                                <option value="017">017</option>
                            </select>
                            <span class="a">-</span>
                            <input type="text" name="phone2" maxlength="4" id ="phone2">
                            <span class="a">-</span>
                            <input type="text" name="phone3" maxlength="4" id ="phone3">
                        </td>
                    </tr>
                    <tr>
                        <th class="col1">이메일</th>
                        <td class="col2">
                            <input type="text" name="mailid" id = "mailid">
                            <span class="a">@</span>
                            <input name="email" type="text" id = "email">
                            <select name="select_email" onChange="selectEmail(this)" id ="select_email">
       							<option value="1" selected>직접입력</option>
						        <option value="naver.com">naver.com</option>
						        <option value="gmail.com">gmail.com</option>
						        <option value="hanmail.com">hanmail.com</option>
						    </select>

                            
                        </td>
                    </tr>
                    <tr>
                        <th class="col1">주소</th>
                        <td class="col2">
                            <div>
                                <input type="text" id="sample6_postcode" placeholder="우편번호" readonly >
                                <input class="but3" type="button" value="우편번호 찾기"onclick="sample6_execDaumPostcode()">
                            </div>
                            <div>
                                <input type="text" id="address" placeholder="주소" readonly style ="width: 300px">
                            </div>
                            <div>
                                <input type="text" id="sample6_detailAddress" placeholder="상세주소" style ="width: 300px">
                            </div>   
                            <div>
                                <input type="text" id="sample6_extraAddress" placeholder="참고항목" readonly>
                            </div>   
                        </td>
                    </tr>
                </table>
        </div>
        <br>
        <div class="create">
            <input class="but4" type="button" value="이전" onclick="history.back()">
            <input class="but5" type="button" value="회원가입" id = "process">
        </div>
        </div>
        </form>
    </section>
    <%@ include file = "footer.jsp" %> 
</body>
</html>