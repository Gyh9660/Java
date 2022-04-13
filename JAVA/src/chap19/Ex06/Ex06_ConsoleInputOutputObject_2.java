package chap19.Ex06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex06_ConsoleInputOutputObject_2 {

	public static void main(String[] args) throws IOException {

		//1.콘솔에서 한글을 인풋 (System.in) <== byte[] 배열을 생성해서 처리 : 한글을 처리할 수 있다.
		InputStream is = System.in; //new로 생성하지 않고 연결만 설정, 콘솔에서 인풋 값을 받는다.
		
		System.out.println("한글을 입력 하세요 >>>");
		
		byte[] byteArray1 = new byte[100];
		int count1 = is.read(byteArray1); // byteArray1에 byte로 \r과\n을포함한 전체가 리드 ,count1 배열에 값이 들어온 갯수,
		//int data = 1s.read(); 한글을 처리하지 못한다. data에는 1byte read한 값이 저장.
		
		
		
		
		//2. 인풋 받은 한글을 파일에 저장(FileOutputStream)
		File f1 = new File("src/chap19/Ex06/input2.txt");
		OutputStream fos = new FileOutputStream(f1); //덮어 쓰기
		
		fos.write(byteArray1); //메모리에(버퍼/RAM)만 쓰여짐 
		fos.flush();			//버퍼에 쓰인 내용을 파일에다 쓰기.
		
		
		
		//3. 저장된 파일에서 값을 읽어온다.(FileInputStream)
		
		InputStream fis = new FileInputStream(f1);// read()만쓰면 한글 처리를 할 수 없다. read(byte[]) : 한글 처리
		byte[] byteArray2 = new byte[100];
		
		int count2 = fis.read(byteArray2); //read(byte[])를 넣어야 한글 처리 가능
		//int data2 = fis.read();  read
		
		
		System.out.println();
		System.out.println("파일에서 읽은 내용을 콘솔에 출력 합니다. >>>>");
		System.out.println();
		
		
		//4. 읽어온 배열을 콘솔에 출력 한다. (System.out)
		
		OutputStream os = System.out; // 콘솔에 출력 : byte[]
		os.write(byteArray2);
		os.flush();
		
		
		is.close();
		fis.close();
		fos.close();
		os.close();
		
		
		
		
		
		
		
	}

}
