<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<SCRIPT language="javascript">                              
function check(){                                         
 with(document.msgwrite){                      
  if(subject.value.length == 0){                  
   alert("������ �Է��� �ּ���!!");                       
   subject.focus();                           
   return false;                             
  }                                         
  if(name.value.length == 0){                   
   alert("�̸��� �Է��� �ּ���!!");                  
   name.focus();                              
   return false;                                  
  }                                         
  if(password.value.length == 0){              
   alert("��й�ȣ�� �Է��� �ּ���!!");              
   password.focus();                            
   return false;                               
  }                                        
  if(content.value.length == 0){                    
   alert("������ �Է����ּ���!!");                   
   content.focus();                         
   return false;                           
  }                                        
  document.msgwrite.submit();                       
 }                                          
}                                            
</SCRIPT>                                    
<link href="filegb.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<P>
	<form name ="msgwite" method ="post" action ="freeboard_save.jsp">
	<div align = "center">
	<table style= "width:60%;" border = "1" border-collapse = "collapse">
		<tr>
			<td  colspan="2" bgcolor="#1F4F8F" height ="1"></td>
		</tr>
		<tr>
			<td colspan= "2" bgcolor="#DFEDFF" height= "20" class ="notice">&nbsp;&nbsp;<font size="2">���� ����</font></td>
		</tr>
		<tr>
			<td colspan="2" bgcolor="#1F4F8F" height="1"></td>
		</tr>
		<tr>
			<td width ="124" height="30" align="center" bgcolor="#f4f4f4">�̸�</td>
			<td width ="494" style="padding:0 0 0 10"><input type= text name= name class="input_style1"></td>
		</tr>
		<tr>
		
		</tr>
	</table>
	</div>
	
	</form>
</body>
</html>