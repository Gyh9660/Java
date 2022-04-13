package chap19.Ex05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//InputStream : 추상 클래스 <== FileInputStream은 InputStream을 구현한 클래스
//OutputStream : 추상 클래스 <== FileOutputStream은 OutputStream을 구현한 클래스
//FileInputStream : byte() 단위 데이터 읽기
//FileOutputStream : byte() 단위 데이터 쓰기


// Windows 콘솔, 메모장 Enter 를 넣으면 : \r\n
// MAC : \n

public class FileOutputStream_1 {

	public static void main(String[] args) throws IOException {
		
		//1. 입력 파일 생성(존재하지 않음)
		File outFile = new File ("src/chap19/Ex05/FileOutput1.txt");
		
		//2. 1- byte 읽기
		OutputStream os1 = new FileOutputStream(outFile); //예외처리
			//FileOutputStream에 존재하지 않는 파일을 넣으면 실행시 생성됨
			//FileInputStream은 경로에 파일이 존재해야됨, 예외발생
		
		os1.write('J'); //write도 IOEXception 발생 예외처리
		os1.write('A'); //write도 IOEXception 발생 예외처리
		os1.write('V'); //write도 IOEXception 발생 예외처리
		os1.write('A'); //write도 IOEXception 발생 예외처리
		os1.write('\r');	//13 <== 생략 가능
		os1.write('\n'); 	//10
	
				//중요 : write() 메소드는 메모리 (버퍼)에 쓰기, 버퍼가 꽉차면 파일에 쓰기
				//		flush() : 버퍼에 저장된 내용을 파일에 강제로 쓰기 할대 사용
		
		os1.flush(); //버퍼가 꽉 차지 않더라도 강제로 파일에 쓰기를 한다., <== 생략가능하지만 write()를 사용하면 flush()를 사용할것을 권장
		os1.close(); //close() 호출시 flush() 먼저 작동됨
		
		//2. n-byte 단위 쓰기 (byte[]의 offset부터 length개의 byte 데이터 쓰기)
		OutputStream os2 = new FileOutputStream(outFile); //예외처리필요 //덮어쓰기
		//OutputStream os2 = new FileOutputStream(outFile,true);//true를 넣으면 이어쓰기, 기본적으로 false가 입력되어있고(생략되어있음) 이는 덮어쓰기임 FileOutputStream(File o, Boolean append)
		byte[] byteArray1 = "Hello!".getBytes();	//String ---> byte로 변환 : getBytes()
		
		os2.write(byteArray1);
		os2.write('\n'); //\r은 생략가능, \n만 넣어도 Windows에서 Enter 처리가됨.
		
		os2.flush();
		os2.close();		//덮어쓰기가 된다.
		
		
		//3. n-byte 단위 쓰기 (byte[]의 offset부터 length개의 byte 데이터 쓰기)
		OutputStream os3 = new FileOutputStream(outFile,true);//이어쓰기
		
		byte[] byteArray2 ="Better the last smile than the first laughter".getBytes();
		os3.write(byteArray2, 7, 8); // write 일떄는 offset뒤에서 length 읽어서 저장. 7byte 뒤부터 8byte읽는다.
									//read 일때는 반대로 처리. 8개 읽어와서 7번방부터 저장
		os3.flush();
		os3.close();
		
		
		
		
	}
	

}
