<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel='stylesheet' type='text/css' media='screen' href='../css/main.css'>
    <!-- fond-awesome.css 추가 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.css">
</head>
</head>
<body>
 <%@ include file = "header.jsp" %>            
    <section>
        <div class="bodywrap">
            <div class="slider">
                <input type="radio" name="slide" id="slide1" checked>
                <input type="radio" name="slide" id="slide2">
                <input type="radio" name="slide" id="slide3">
                <input type="radio" name="slide" id="slide4">
                <ul id="imgholder" class="imgs">
                    <li><a href="#"><img src="../img/s1.png"></a></li>
                    <li><a href="#"><img src="../img/s2.jpg"></a></li>
                    <li><a href="#"><img src="../img/s3.png"></a></li>
                    <li><a href="#"><img src="../img/s4_1280.jpg"></a></li>
                </ul>
                <div class="bullets">
                    <label for="slide1">&nbsp;</label>
                    <label for="slide2">&nbsp;</label>
                    <label for="slide3">&nbsp;</label>
                    <label for="slide4">&nbsp;</label>
                </div>
            </div>
            <div class="contents">
                <div class="otherwrap">
                    <div class="bannername"><h3>Best Game</h3> </div>
                    <div class="banner">
                        <a href="#">
                            <img src="../img/제목 없음3.jpg" alt="상품이미지1">
                        </a>
                        <pre>             [Nintendo Switch]
                            <a href="#"><h4>말랑말랑 두뇌학원</h4></a>
                                              2022.03.20
                                                 20000원
                        </pre>
                    </div>
                    
                    <div class="banner2">
                        <a href="#">
                            <img src="../img/제목 없음4.jpg" alt="상품이미지2">
                        </a>
                        <pre>             [Nintendo Switch]
                            <a href="#"><h4>링피트 어드벤처</h4></a>
                                              2022.03.20
                                                 20000원
                            </pre>
                    </div>
                    <div class="banner3">
                        <a href="#">
                            <img src="../img/모여봐요_동물의_숲_한국어_아트.jpg" alt="상품이미지3">
                        </a>
                        <pre>             [Nintendo Switch]
                            <a href="#"><h4>모여봐요 동물의숲</h4></a>
                                              2022.03.20
                                                 20000원
                            </pre>
                    </div>
                </div>
                <div class="otherwrap2">
                    <div class="twobannername"><h3>Switch & 주변기기</h3></div>
                    <div class="sbanner">
                        <a href="#">
                            <img src="../img/1000082025_main_018.jpg" alt="두번째 배너">
                        </a>
                        <pre>             [Nintendo Switch]
                            <a href="#"><h4>닌텐도 스위치 라이트 그레이</h4></a>
                                              2022.03.20
                                                 20000원
                    </div>
                    <div class="sbanner2">
                        <a href="#">
                            <img src="../img/1000163260_main_039.jpg" alt="두번째 배너2">
                        </a>
                        <pre>             [Nintendo Switch]
                            <a href="#"><h4>닌텐도 스위치 네온블루(HAD)</h4></a>
                                              2022.03.20
                                                 20000원
                    </div>
                    <div class="sbanner3">
                        <a href="#">
                            <img src="../img/8844_Main.jpg" alt="두번째 배너3">
                        </a>
                        <pre>             [Nintendo Switch]
                            <a href="#"><h4>스위치 조이콘(L) 네온그린/(R) 네온핑크</h4></a>
                                              2022.03.20
                                                 20000원
                    </div>
                </div>
            </div>
        </div>
    </section>  
    <%@ include file = "footer.jsp" %>                
</body>
</html>