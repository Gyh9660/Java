package chap19.Ex03;

import java.io.UnsupportedEncodingException;

//EUCKR - 한국 표준, 한글 표현가능 전체중 표기 가능한것만 구성되어 있음, 약 11,000 --->2200만 표기, 8000자는 표기안됨
	//영문 : 1byte	<=== UTF-8로 처리 (영어일떄)
	//한글 : 2byte
	//웹페이지로 출력할때 

//MS-949 (ANSI)- Microsoft 사에서 개발한 한글 표기 방식. 11,000모두를 표기할 수 있다. Windows OS
	//영문 : 1byte	<== UTF-8로 처리 (영어일때)
	//한글 : 2byte

//UTF-8 : 모든 서버 (Web, FTP, Mail,DB .....) , Git, MAC,Linux <가변 길이>
	//영문 : 1byte	<== UTF-8로 처리 (영어일때)
	//한글 : 3byte

//UTF-16 : <고정 길이>
	//영문, 한글 모두 2byte로 처리.
	//BOM 2byte : 모든 나라의 식별코드
	//모든 나라의 언어를 처리


//문자를 해당 인코딩 타입으로 바이트 스트림으로 생성한 경우, 해당 인코딩 타입으로 조합을 해야 깨어지지 않는다.

//이클립스에서 인코딩타입 설정 3가지
	//1. 전역설정 :
	//2. 프로젝트에서 설정 :
	//3. 파일에서 설정 :
	
	//우선순위 : 파일 > 프로젝트 > 전역





public class EUCKR_VS_MS949 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//EUCKR VS MS949

			//1. 영문자를 byte로 내보내고 다시 String으로 변환 : 영문 1byte
		
			byte[] b1 = "a".getBytes("EUC-KR"); //문자를 byte로 변환, ===>네트워크로 문자를 byte 스트림으로 변환해서 전송. 
			//예외가 발생 getBytes하면, (UnsupportedEncodingException) <==오타가 발생할경우 인코딩할수 없는 문제(예외)가 발생
		
			byte[] b2 = "a".getBytes("MS949"); //문자열 ==> byte[]
			
			System.out.println(b1.length); //1바이트
			System.out.println(b2.length); //1바이트
			
			System.out.println(new String(b1,"EUC-KR")); //byte[] ==> 문자열로 바꿈
			System.out.println(new String(b2,"MS949"));
			
		
			//2. 한글을 byte로 내보내고 다시 String으로 변환 : 한글 2byte
			
			byte[] b3 = "가".getBytes("EUC-KR");
			byte[] b4 = "가".getBytes("MS949");
			
			System.out.println(b3.length);//2
			System.out.println(b4.length);//2
			
			System.out.println(new String(b3, "EUC-KR"));//byte[] ==> 문자열로 바꿈
			System.out.println(new String(b4, "MS949"));
		
			
			//3.EUC-KR은 현재 사용 가능한 것만 표기, 약 2000자
			//	MS949는 11000자 모두 표기됨.
			byte[] b5 = "뷁".getBytes("EUC-KR"); //11,000자중 2000자만 표기 8000자는코드가 구현되어있지않다.
			byte[] b6 = "뷁".getBytes("MS949");	//11,000자 모두 처리할수있다.
			
			System.out.println(b5.length);//1
			System.out.println(b6.length);//2
			
			System.out.println(new String(b5, "EUC-KR"));//byte[] ==> 문자열로 바꿈
			System.out.println(new String(b6, "MS949"));
			
			
			
			
			
			
	}

}
