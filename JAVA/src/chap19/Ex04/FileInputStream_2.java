package chap19.Ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class FileInputStream_2 {
	
	public static void main(String[] args) throws IOException {
		
	//1. 입력 파일 생성
		File inFile = new File ("src\\chap19\\Ex04\\FileInputStream_2.txt");
	//2. 1. byte 단위 읽기(한 바이트씩 읽어서 처리) //처리 속도가 느리다.
		InputStream is1= null; //객체 선언, Finally 블락에서 close
		try {
			is1 = new FileInputStream(inFile); //객체생성
			int data ; //byte로 선언 x int로 선언
			while ((data=is1.read())!=-1) {//영문만 있으므로 read()메소드만 사용, 한글일 경우 read(byte배열)
				System.out.print((char)data);
				
			}
		} catch (IOException e) {
			System.out.println("파일을 찾지 못했습니다.");
		}finally {
			if(is1 != null) {
				try {
					is1.close(); //null일때 close 하면 IOException
				} catch (IOException e) {

				}
			}
		}
		System.out.println();
		System.out.println("===========Try (with resouce)==================");
		
		//2-2
		
		//1. 입력 파일 생성
				File inFile2 = new File ("src\\chap19\\Ex04\\FileInputStream_2.txt");
				
			//try (With resource : ()에 객체생성 <== close()가 자동으로 된다, FileInputStream 은 Closeable 인터페이스를 구현
				try(InputStream is2 = new FileInputStream(inFile2)){					int data ;
					while ((data=is2.read())!=-1) {//영문만 있으므로 read()메소드만 사용, 한글일 경우 read(byte배열)
						System.out.print((char)data);
						
					}
				} catch (IOException e) {
					System.out.println("파일을 찾지 못했습니다.");
				}
		
		
		//3. 2. n-byte 단위로 읽기(byte[]의 처음 위치에서부터 읽은 데이터 저장) : 여러 byte를 동시에 읽어서 처리속도가 빠름.
				//배열의 방의 크기만큼 읽어 들여서 byte배열에 저장한다.
				//한글 처리가능
				
			System.out.println();
			System.out.println();
			System.out.println("==========================");
			InputStream is3 = new FileInputStream(inFile2); //throws로 처리,
			byte[] byteArray1 = new byte[9]; //배열방 9개, 0~8까지// 배열은 바이트배열
			
			int count1;
			while((count1 = is3.read(byteArray1))!= -1) { //-1은 파일의 마지막까지 
					//is3.read() : 1 byte 씩 읽는다.
					//is3.read(byteArray1) : 배열방 크기(9) byte씩 읽는다.
					//count1 : 9, 9, 2 , -1 
				
				
				
				for(int i=0; i<count1; i++) {
					System.out.print((char)byteArray1[i]);
				}
				System.out.println(": count1 =" + count1);
				/*
				System.out.println();
				System.out.println("================");
				String str = new String(byteArray1,Charset.forName("MS949"));
				System.out.println(str);
				System.out.println("================");
				*/
			}
			is3.close();
		
			
			System.out.println("================================");
			//3. 2-1. n-byte 단위로 읽어서 한글 처리[배열 단위로 읽어서 한글 처리]
			InputStream is4 = new FileInputStream(inFile2);
			byte[] byteArray2 = new byte[100];
			
			int count2;
			
			while((count2 =is4.read(byteArray2))!= -1) {//count2 = 100, -1
				System.out.println(new String(byteArray2,Charset.forName("MS949")));
				
			}
			
			System.out.println();
			System.out.println("=============================================================");
			//4. 3. n-byte 단위로 읽어서 저장. offset, length 사용
			
			InputStream is5 = new FileInputStream(inFile2);
			byte[] byteArray3 = new byte[9];
			
			int offset = 3;
			int length = 6;
			int count3 = is5.read(byteArray3, offset, length); //length 만큼 앞에서 읽어와서 byteArray3에 offset 위치에 저장해라
		//length 6 => [랭스를 먼저 읽고]FileIn 까지 읽어와서 [6byte] byteArray3에 저장하는데 [0~8번방] offset 3 => 3번방부터 FileIn을 한방에 하나씩 저장해라. 그앞에 0 1 2 번방은 공백?띄어쓰기?비워두고 offset + length <= byte[]방크기// offset + length 값은 배열방크기보다 작거나(작을경우는 뒤에공간이 남으면 거기도 비워둔다) 같아도 되지만 크면 안됨.
				
				for(int i =0; i< offset + count3;i++) {
					System.out.print((char)byteArray3[i]);
				}
			is5.close();
			
			
			
			
			
			
			
			
			
			
		
	}

}
