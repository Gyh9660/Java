package chap19.Ex08;

import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
 *  Reader / Writer : 추상 클래스 , char를 처리, 문자(O) , 이미지 (X), MP3(X).....
 *  FileReader / FileWriter : 완성된 클래스 , Default charSet 만 사용.
 *  InputStreamReader / OutputStreamWriter :  읽을때 인코딩 (MS949, UTF-8)지정해서 읽기, 쓸때 인코딩(MS949,UTF-8)지정해서 쓰기 가능
 *  
 *  주의 : System.in : 콘솔에서 입력, System.out : 콘솔에 출력 <== Application에서 한번 close()되면 재사용 불가.
 *  System.in, System.out <== byte읽기, byte 쓰기.
 *  
 *  
 */


public class OutputStreamWriter_2 {

	public static void main(String[] args) {

		//1. 콘솔 출력 (Application Default : MS949 ==> MS949)
		
		try {
			OutputStreamWriter osw = new OutputStreamWriter(System.out,"MS949");
			osw.write("OutputStreamWriter1 예제 파일 입니다.\n".toString()); //String을 char배열에 저장
			osw.write("한글과 영문이 모두 포함되어 있습니다. ");//String
			osw.write('\n'); //char 저장
			osw.write("Good Bye !!!!\n\n");
			osw.flush(); //버퍼에 저장된 것을 콘솔에 출력
		} catch (Exception e) {}
		System.out.println();
		System.out.println("==============================");
		//2. 콘솔 출력 (Application Default : MS949 ==> UTF-8)
		
		try {
			OutputStreamWriter osw = new OutputStreamWriter(System.out,"UTF-8");
			osw.write("OutputStreamWriter1 예제 파일 입니다.\n".toString()); //String을 char배열에 저장
			osw.write("한글과 영문이 모두 포함되어 있습니다. ");//String
			osw.write('\n'); //char 저장
			osw.write("Good Bye !!!!\n\n");
			osw.flush(); //버퍼에 저장된 것을 콘솔에 출력
		} catch (Exception e) {}
	}

}
