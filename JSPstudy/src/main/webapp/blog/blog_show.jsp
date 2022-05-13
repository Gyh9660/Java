<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "java.sql.*, java.util.*, java.text.*" %>    
<% request.setCharacterEncoding("UTF-8"); %> <!-- g한글 처리 -->
<%@ include file = "dbconn_oracle.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컬럼의 특정 레코드를 읽는 페이지</title>
</head>
<body>
<div align ="center">

<%
	Vector name=new Vector(); 	//DB의 Name 값만 저장하는 벡터
	Vector inputdate=new Vector();
	Vector email=new Vector();
	Vector subject=new Vector();
	Vector content=new Vector();	//
	
	// 페이징 처리 시작 부분
		int where=1;

	 	int totalgroup=0;	//출력할 페이징의 그룹핑의 최대 갯수, 마지막 페이지 링크 (전체 db의값 가져와서 합해서)
	 	int maxpages=2;	//최대 페이지 갯수 (화면에 출력될 페이지 갯수)
	 	int startpage=1;	//처음, 시작 페이지
	 	int endpage=startpage+maxpages-1; //마지막 페이지
	 	int wheregroup=1;	//현재 위치하는 그룹
	
	
	// go : 해당 페이지 번호로 이동
	// freeboard_list.jsp?go=3
	// gogroup : 출력할 페이지의 그룹핑
	// freeboard_list.jsp?gogroup=2 () (maxpage가 5일때 6,7,8,9,10)
	
	
	//go변수가넘어왔을때 (go 변수 => 페이지 번호)를 넘겨 받아서 wheregroup, startpage, endpage 정보의 값을 알아낸다.
	if (request.getParameter("go") != null) { //go 변수의 값을 가지고 있을때
	 where = Integer.parseInt(request.getParameter("go")); //현재 페이지 번호를 담은 변수
	 wheregroup = (where-1)/maxpages + 1; //현재 위치한 페이지의 그룹
	 startpage=(wheregroup-1) * maxpages+1;  
	 endpage=startpage+maxpages-1; 
	 
	 //gogroup변수가 넘어왔을때 (gogroup변수를 넘겨 받아서) startpage, endpage, where(페이지그룹의 첫번째페이지) 정보의 값을 알아낸다.
	} else if (request.getParameter("gogroup") != null) { //gogroup변수의 값을 가지고 올때
	 wheregroup = Integer.parseInt(request.getParameter("gogroup"));
	 startpage=(wheregroup-1) * maxpages+1;  
	 where = startpage ; 
	 endpage=startpage+maxpages-1; 
	}
	
	
	  int nextgroup=wheregroup+1;		//다음 그룹 : 현재 위치한 그룹 + 1
	  int priorgroup= wheregroup-1;		//이전 그룹 : 현재 위치한 그룹 - 1

	  int nextpage=where+1;		//다음 페이지 : 현재 위치한 페이지 + 1
	  int priorpage = where-1;	//이전 페이지 : 현재 위치한 페이지 - 1
	  int startrow=0;			// 하나의 page에서 Select한 레코드 시작 번호	
	  int endrow=0;				// 하나의 page에서 Select한 렉코드 마지막 번호
	  int maxrows=2; //출력할 레코드수 
	  int totalrows=0;	//총 레코드 갯수
	  int totalpages=0; //총 페이지 갯수
	
	// out.println("====== maxpage : 3 일때 ==========" + "<p>");
	// out.println("현재 페이지 : " + where + "<p>");
	// out.println("현재 페이지 그룹: " + wheregroup + "<p>");
	// out.println("시작 페이지 : " + startpage + "<p>");
	// out.println("앤드 페이지 : " + endpage + "<p>");
	//if (true) return;
	
	
	
	// 페이징 처리 마지막 부분
	
	String na = request.getParameter("name");
	
	String em = null;  
	String sql = null;
	Statement st =null;
	ResultSet rs = null;
	
	try{
		st = conn.createStatement();
		sql = "select * from guestboard order by inputdate desc";
		rs = st.executeQuery(sql);
		
		if(!(rs.next())){
			out.println("글이 없습니다.");
		}else{
			do {
				   //DataBase의 값을 가져와서 각각의 vector에 저장
			    name.addElement(rs.getString("name"));
			    email.addElement(rs.getString("email"));
			    inputdate.addElement(rs.getString("inputdate"));
			    subject.addElement(rs.getString("subject"));	
			    content.addElement(rs.getString("content"));
			   }while(rs.next());
			   
			   totalrows = name.size(); // name vector에 저장된 값의 갯수 - 총 레코드 수
			   totalpages = (totalrows-1)/maxrows +1;
			   startrow = (where-1) * maxrows;		//현재 페이지에서 시작 레코드 번호
			   endrow = startrow+maxrows-1  ;	
			if (endrow >= totalrows) //마지막 row가 총row보다 큰경우
				    endrow=totalrows-1;
				  
				   totalgroup = (totalpages-1)/maxpages +1; 
			if (endpage > totalpages) 
				endpage=totalpages;	
			
			for(int j=startrow;j<=endrow;j++) {
			    String temp=(String)email.elementAt(j); 
			    if ((temp == null) || (temp.equals("")) )  
			     em= (String)email.elementAt(j); 		
			    else
			     em = "<A href=mailto:" + temp + ">" + email.elementAt(j) + "</A>";
		
			out.println("<table width='600' cellspacing='0' cellpadding='2' align='center'>");
		    out.println("<tr>");
		    out.println("<td height='22'>&nbsp;</td></tr>");
		    out.println("<tr align='center'>");
		    out.println("<td height='1' bgcolor='#1F4F8F'></td>");
		    out.println("</tr>");
		    out.println("<tr align='center' bgcolor='#DFEDFF'>");
		    out.println("<td class='button' bgcolor='#DFEDFF'>"); 
		    out.println("<div align='left'><font size='2'>"+subject.elementAt(j) + "</div> </td>");
		    out.println("</tr>");
		    out.println("<tr align='center' bgcolor='#FFFFFF'>");
		    out.println("<td align='center' bgcolor='#F4F4F4'>"); 
		    out.println("<table width='100%' border='0' cellpadding='0' cellspacing='4' height='1'>");
		    out.println("<tr bgcolor='#F4F4F4'>");
		    out.println("<td width='13%' height='7'></td>");
		    out.println("<td width='40%' height='7'>글쓴이 : "+ name.elementAt(j) +"</td>");
		    out.println("<td width='36%' height='7'>e-mail :"+em+"</td>");
		    out.println("<td width='11%' height='7'></td>");
		    out.println("</tr>");
		    out.println("<tr bgcolor='#F4F4F4'>");
		    out.println("<td width='13%'></td>");
		    out.println("<td width='51%'>작성일 : " + inputdate.elementAt(j) + "</td>");
		    out.println("<td width='25%'></td>");
		    out.println("<td width='11%'></td>");
		    out.println("</tr>");
		    out.println("</table>");
		    out.println("</td>");
		    out.println("</tr>");
		    out.println("<tr align='center'>");
		    out.println("<td bgcolor='#1F4F8F' height='1'></td>");
		    out.println("</tr>");
		    out.println("<tr align='center'>");
		    out.println("<td style='padding:10 0 0 0'>");
		    out.println("<div align='left'><br>");
		    out.println("<font size='3' color='#333333'><PRE>"+content.elementAt(j) + "</PRE></div>");
		    out.println("<br>");
		    out.println("</td>");
		    out.println("</tr>");
		    out.println("<tr align='center'>");
		    out.println("<td class='button' height='1'></td>");
		    out.println("</tr>");
		    out.println("<tr align='center'>");
		    out.println("<td bgcolor='#1F4F8F' height='1'></td>");
		    out.println("</tr>");
		    out.println("<br>");
		    out.println("<br>");
		    out.println("</table>");
			}
   
  }
	}catch(Exception ex){
		out.println (ex.getMessage());
	}finally{
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();
	}

	  out.print("<br>");
	 if (wheregroup > 1) { //현재 나의 그룹이 1 초과일때는 링크 설정
	  out.println("[<A href=blog_show.jsp?gogroup=1>처음</A>]"); 
	  out.println("[<A href=blog_show.jsp?gogroup="+priorgroup +">이전</A>]");
	 } else { // 현재 나의 그릅이 1 이하일때는 링크제거
	  out.println("[처음]") ;
	  out.println("[이전]") ;
	 }
	 
	 
	 if (name.size() !=0) { 
	  for(int jj=startpage; jj<=endpage; jj++) {
	   if (jj==where) 
	    out.println("["+jj+"]") ;
	   else
	    out.println("[<A href=blog_show.jsp?go="+jj+">" + jj + "</A>]") ;
	   } 
	  }
	  if (wheregroup < totalgroup) {
	   out.println("[<A href=blog_show.jsp?gogroup="+ nextgroup+ ">다음</A>]");
	   out.println("[<A href=blog_show.jsp?gogroup="+ totalgroup + ">마지막</A>]");
	  } else {
	   out.println("[다음]");
	   out.println("[마지막]");
	  }
	  out.println ("전체 글수 :"+totalrows);
	  
	  
	  

%>

</div>
<TABLE align= center border=0 width=600 cellpadding=0 cellspacing=0>
<tr>
<TD align=right  width="200" valign=bottom><A href="blog_write.jsp"><img src="image/write.gif" border="0"></A></TD>
</tr>
</TABLE>
</body>
</html>