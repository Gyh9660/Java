let status = true;

//회원가입 버튼클릭
$(document).ready(function(){
			
	$("#register").click(function(){
		
		$("#main_auth").load("registerForm02.jsp");
	});
	
	
	
		//[로그인]버튼을 클릭하면 자동실행	
	//입력한 아이디와 비밀번호를 갖고 loginPro.jsp 페이지 실행
	$("#login").click(function(){
		checkIt();//입력폼에 입력한 상황 체크
		if(status){
		  //입력된 사용자의 아이디와 비밀번호를 얻어냄
		  var query = {u_id : $("#u_id").val(), // 변수명(id) : 값 ($("#id").val())을 query에 담음
				       u_pass:$("#u_pass").val()};
		  
		  $.ajax({
		     type: "POST",
		     url: "loginPro02.jsp",
		     data: query,
		     success: function(data){
		    	 if(data == 1)//로그인 성공
		    		 $("#main_auth").load("loginForm02.jsp");	
		    	 else if(data == 0){//비밀번호 틀림
		    	  	 alert("비밀번호가 맞지 않습니다.");
		    	  	 $("#u_pass").val("");
		    	  	 $("#u_pass").focus();
		    	 }else if(data == -1){//아이디 틀림
		    		 alert("아이디가 맞지 않습니다.");
		    		// $("#id").val("");
		    		 $("#u_pass").val("");
		    	  	 $("#u_id").focus();
		    	 }
		     }
		  });
		}
	});
	
	/*-- 인증된 사용자 영역을 처리하는 버튼들 ---*/
	//[회원 정보 변경]버튼을 클릭하면 자동실행
	$("#update").click(function(){//[회원정보수정]버튼 클릭
		//회원정보를 수정 및 회원 탈퇴를 위한 modify.jsp 페이지 요청
		$("#main_auth").load("modify02.jsp");
	});
	
	//[로그아웃]버튼을 클릭하면 자동실행
	//logout.jsp페이지를 생행
	$("#logout").click(function(){//[회원정보수정]버튼 클릭
		$.ajax({
		   type: "POST",
		   url: "logout02.jsp",
		   success: function(data){
		      $("#main_auth").load("loginForm02.jsp");
		   }
		});
	});
	
	
});


//인증되지 않은 사용자 영역에서 사용하는 입력 폼의 입력값 유무 확인
function checkIt(){
	status = true;
	if(!$.trim($("#u_id").val())){
		alert("아이디를 입력하세요.");
		$("#u_id").focus();
		status = false;
		return false;
	}
	
	if(!$.trim($("#u_pass").val())){
		alert("비밀번호를 입력하세요.");
		$("#u_pass").focus();
		status = false;
		return false;
	}
}