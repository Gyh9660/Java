package chap19.Ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream_1 {

	public static void main(String[] args) throws IOException {

		//현재 작업 디렉토리 위치확인
		System.out.println(System.getProperty("user.dir"));
	
		
		//1. 입력 파일 생성
			//절대 경로로 설정
		File inFile1 = new File("C:\\gyh\\JAVA\\src\\chap19\\files\\IFileInputStream1.txt");
		
			//상대 경로로 설정 : 현재 작업디렉토리를 기준으로 설정
		File inFile = new File ("src\\chap19\\files\\IFileInputStream1.txt");

		//InputStream 객체를 생성해야 파일의 내용을 읽어들일수 있다.
		InputStream is = new FileInputStream(inFile); 
			//InputStream은 추상클래스, 직접 객체 생성을 할 수 없다. 타입 지정은 가능 하다.
		
		//UTF-8 :영어 :1byte, 한글 : 3byte
		//MS949 :영어 :1byte, 한글 : 2byte
		//EUC-KR :영어 :1byte, 한글 : 2byte
		//UTF-16 :영어 :2byte, 한글 : 2byte, 그외 다른언어도 2byte// 첫번째 BOM(식별자) 2byte
		
		
		//JAVA에서 줄바꿈 처리
			// -UNIX :  \n
			// -Windows : \r\n  <== \r은 생략해도 됨. <== 콘솔이나 메모장에서 enter를 넣으면 기본적으로 \r\n 
			// -MAC : \r
		
		
		//파일의 내용을 출력.
		//한 바이트 데이터를 읽어서(byte로) char로 변환후 출력. 
		System.out.print((char)is.read());	//read() 메소드는 1byte를 읽어들인다. =>바이트단위로 출력 앞에(char)를 넣어서 byte를 char단위로 바꿔서 출력해줘야함
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		System.out.print((char)is.read());
		
		System.out.println();
		System.out.println();
		System.out.println("==================================");
		
		//Stream은 값을 읽으면 메모리에서 값이 삭제 된다. 새로 읽기 귀해서는 새로운 Stream을 생성해야 한다.
		
		//int read() [리턴타입이 int] : 한 바이트를 읽어서 값이 존재할 경우 양수를 리턴, 읽은 데티어가 존재하지 않을 경우 -1을 리턴
		//파일의 내용을 출력. While문을 사용해서 한번에 출력

		InputStream is1 = new FileInputStream(inFile); 
		int data;
		
		while((data = is1.read()) != -1) { //-1이 아닐떄까지 루프 -1이면 빠져나옴 -1 -> 데이터가 존재하지 않을떄까지, 마지막값까지 계속 순환 / (-1 : 값이 더이상 존재하지 않으면 -1리턴)
			System.out.print((char)data);
			
		}
			// 중요 :is1.read() : 1byte를 읽어 들임. 반환 타입은 int 이다.
			// 
			// FileInputStream은 반드시 index 0번부터 읽어 들임.  중간의 임이의 방에서 읽을 수 없다.
				//FileRandoomAccess를 사용해서 임의의 index에서 읽어 들임
		System.out.println();
		System.out.println();

		System.out.println("=================================");
		
		
		// available() : 스트림의 남은 바이트수를 출력.
		
		InputStream is2 = new FileInputStream(inFile); 
		
		while((data = is2.read()) != -1) { //-1이 아닐떄까지 루프 -1이면 빠져나옴 -1 -> 데이터가 존재하지 않을떄까지, 마지막값까지 계속 순환
			System.out.println("읽은 데이터 : "+ (char)data + "남은 바이트수 : " + is2.available());
			
		}
		
		is.close();
		is1.close();
		is2.close();
		
		
		
		
		
		
		
	}

}
