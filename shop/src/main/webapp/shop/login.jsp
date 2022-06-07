<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="../css/login.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.css">
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="login.js"></script>

<%
String u_id ="";
try{
	//id세션 속성의 값을 얻어내서 id변수에 저장
	//인증된 사용자의 경우  id세션 속성의 값 null또는 공백이 아님
	u_id = (String)session.getAttribute("u_id");
%>

<%if(u_id == null || u_id.equals("")){ //인증되지 않은 사용자 영역%>
  <section class="login">
        <h1>로그인</h1>
            <fieldset>
                <p>
                    <input type="text" class="form2" id="u_id" name="u_id" required placeholder="아이디">
                </p>
                <p>
                    <input type="password"class="form2" id="pass" name="pass" required placeholder="비밀번호">
                </p>
                <p>
                    <button type = "button" id="login">로그인</button>
                </p>
            </fieldset>
        <div class="memberLink">
            <button id="register" class="register" type ="button" onclick="hrefLink()" style ="font-size: 20px">회원가입</button>
            <a href="#" class="find">아이디/비밀번호 찾기</a>
        </div>
    </section>
<%}}catch(Exception e){e.printStackTrace();}%>
