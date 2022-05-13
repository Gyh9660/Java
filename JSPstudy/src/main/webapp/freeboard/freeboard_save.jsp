<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import = "java.sql.*, java.util.*, java.text.*" %>    
<% request.setCharacterEncoding("UTF-8"); %> <!-- g한글 처리 -->
<%@ include file="dbconn_oracle.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>폼의 값을 받아서 DataBase에 값을 넣어주는 파일</title>
</head>
<body>
<%
	//폼에서 넘긴 변수를 받아서 저장.
	String na = request.getParameter("name");
	String em = request.getParameter("email");
	String sub = request.getParameter("subject");
	String cont = request.getParameter("content");
	String pw = request.getParameter("password");
	
	int id = 1; 	//db의 id컬럼에 저장할 값
	//
	int pos = 0;
	if(cont.length()==1){
		cont = cont + " " ;
	}
	
	//textarea내에 ' 가 들어가면 db에 insert, update시 문제 발생(작동안함)
	
	//이부분은 String으로 값이 들어가는 모든 컬럼에 다 각각 처리해줘야함. 
	//아래부분은 현재 cont부분만 처리했음
	while ((pos = cont.indexOf("\'",pos)) != -1){ // -1 값이 존재하지 않을때
		String left = cont.substring(0,pos);
			//out.println ("pos : "+pos+"<p>");
			//out.println ("left : "+left+"<p>");
		
		String right = cont.substring(pos, cont.length());
			//out.println ("right : "+right+"<p>");
	
		cont = left + "\'" + right;
		pos +=2;
	}
	//if(true) return;
	
	//오늘의 날짜 처리
	java.util.Date yymmdd = new java.util.Date();
	SimpleDateFormat myformat = new SimpleDateFormat ("yy-MM-d h:mm a");
	String ymd = myformat.format(yymmdd);
	
	String sql = null;
	Statement st = null;
	ResultSet rs = null;
	int cnt = 0; // Insert가 잘 되었는지 그렇지 않은지 확인 하는 변수
	
	try{
		//값을 저장하기 전에 최신 글번호(max(id))를 가져 와서 + 1를 적용한다.
		//conn (Connection) : auto commit; 이 작동 된다.
			//commit을 명시 하지 않아도 insert, update, delete , 자동 커밋이 된다.
			
			
		st = conn.createStatement();
		sql = "select max(id) from freeboard";
		rs = st.executeQuery(sql);
		
		if(!rs.next()){ //rs의 값이 비어 있을때 
			id = 1;
		}else {			//rs의 값이 존재 할때
			id = rs.getInt(1) + 1;	//최대값 + 1
		}
		
		
		sql = "insert into freeboard (id,name,password,email,subject, ";
		sql = sql + "content, inputdate, masterid, readcount, replaynum, step) ";
		sql = sql + "values ("+id+",'"+ na+"','"+ pw+"','"+ em ;
		sql = sql + "','" + sub +"','" + cont + "','"+ ymd + "'," + id + "," ;
		sql = sql + "0,0,0)";
			
		cnt = st.executeUpdate(sql); //cnt > 0 : Insert 성공
		//out.println(sql);
		//if(true) return;
		
		if (cnt >0){
			out.println("데이터가 성공적으로 입력 되었습니다.");
		}else {
			out.println("데이터가 입력되지 않았습니다.");
		}
		
		
	}catch(Exception ex){
		out.println (ex.getMessage());
	}finally{
		if (rs!=null)
			rs.close();
		if (st!=null)
			st.close();
		if (conn!=null)
			conn.close();
	}
	
%>

<jsp:forward page ="freeboard_list.jsp" />

<!-- 페이지 이동

	jsp : forward :				서버단에서 페이지를 이동해서 클라이언트로 전송,
								클라이언트의 기존의 URL정보가 바뀌지 않음(기존의 위치에서
								페이지 정보만 바꿔줌)
								ex) 열린 페이지는 list페이지 이지만 URL은 
								이동한페이지인 list가 아닌 기존URL인 save로나타남
								
	response.sendRedirect : 	클라이언트에서 페이지를 재요청으로 페이지 이동
								이동하는 페이지로 URL정보가 바뀜
								페이지자체를 새로 열어달라고 클라이언트가 서버에 재요청
								하고 그페이지를 전송시켜줌
								ex ) 열린 페이지도 list페이지가 열리고 URL도 
								rsave가 아닌 list페이지의 URL이 나타남 

 -->



</body>
</html>