package chap19.Ex06;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

//한글을 콘솔에 출력. 1바이트씩(1-byte) 출력하면 한글 출력이 안됨. n-byte로 출력 해야 한글 출력

public class ConsoleOutputObject_2 {

	public static void main(String[] args) throws IOException {
		OutputStream os =System.out;	//콘솔에 출력. byte로 콘솔에 값을 던져줘야 한다.
		
		//2. n-byte 출력 (byte[] 배열에 처음 부터 끝까지 데이터 쓰기
		byte[] byteArray1 ="안녕하세요".getBytes(Charset.defaultCharset());
		
		os.write(byteArray1);
		os.write('\n'); //버퍼에 쓰기
		
		os.flush(); //버퍼의 내용을 콘솔에 출력.
		
		//3. n-byte 출력 (byte[] 의 offset 부터 length개의 byte 데이터 쓰기)
		byte[] byteArray2 ="반갑습니다".getBytes(Charset.defaultCharset());
		
		os.write(byteArray2,6,4); //6byte 제거후 4byte만 처리
		
		os.flush();
		
		os.close();
		
		
		
		
	}

}
