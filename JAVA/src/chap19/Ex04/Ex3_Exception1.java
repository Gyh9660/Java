package chap19.Ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/*
 * 	1. is1  <== InputStream 객체 (절대경로로 접근: ms949.txt), 예외처리
 * 	2. is2	<== InputStream 객체 (상대경로로 접근: utf-8.txt), 예외처리(try ~with resource로 예외처리
 * 				close()메소드를 자동으로 처리
 */



public class Ex3_Exception1 {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("=====ms949 절대경로 1==========");
		File file1 = new File("D:\\gyh\\JAVA\\src\\chap19\\Ex04\\Exception-ms949.txt");
		System.out.println(file1.getAbsolutePath());
		InputStream is1 = null;
		Reader reader1 = null;
		BufferedReader in1 = null;
		try {
			is1 = new FileInputStream(file1);
			reader1 = new InputStreamReader(is1);
			in1 = new BufferedReader(reader1);
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재 하지 않습니다.");
		}
		
		int data;
		try {
			while((data = in1.read()) != -1) { 
				System.out.print((char)data);
			}
		} catch (IOException e) {
			System.out.println("파일을 읽지 못하는 예외가 발생되었습니다.");
		}finally {
			try {
				if (is1 != null) {
					is1.close();
				}
				if (reader1 != null) {
					reader1.close();
				}
				if (in1 != null) {
					in1.close();
				}
			}catch (IOException e) {
				System.out.println("예외가 발생했습니다.");
			}
		}
		
		
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("=====ms949 절대경로 2==========");
		
		File file4 = new File("D:\\gyh\\JAVA\\src\\chap19\\Ex04\\Exception-ms949.txt");
		
		System.out.println(file1.getAbsolutePath());
		
		InputStream is4 = null;
		try {
			is4 = new FileInputStream(file4);
			byte[] array2= is4.readAllBytes();
			String str2 = new String(array2,"MS949");
			System.out.println(str2);
		} catch (IOException e1) {
			System.out.println("예외발생.");
			e1.printStackTrace();
		}finally {
			if (is4 != null) {
				try {
					is4.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("예외가 발생했습니다.");
				}
			}
		}
		

		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("=====ms949 절대경로 3==========");
		//is5 = 절대경로로 접근 -ms949.txt 예외처리 try 각각 의예외
		File file5 = new File("D:\\gyh\\JAVA\\src\\chap19\\Ex04\\Exception-ms949.txt");
		
		System.out.println(file5.getAbsolutePath());
		InputStream is5 = null; //전역 변수로 선언. finally블락에서 is5.close()
	
		byte[] arr5 = new byte[100];
		
		try {
			is5 = new FileInputStream(file5);
		} catch (FileNotFoundException e2) {
			System.out.println("파일 존재하지않습니다.");
		}
		
		int data5=0;
		
		try {
			while((data5 = is5.read(arr5))!= -1) {
				String str5 = new String(arr5, 0, data5, Charset.forName("MS949"));
				System.out.println(str5);
			}
		} catch (IOException e2) {
			System.out.println("예외");
		}finally {
			if(is5 != null) {
				try {
					is5.close();
				} catch (IOException e) {
					System.out.println("예외");
				}
			}
		}

		System.out.println();
		System.out.println();
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//3-2 단일 트라이캐치 여러 Exception에 대해서 단일 try catch로 처리
		System.out.println("=====ms949 절대경로 3-2==========");
		InputStream is6 = null; //전역 변수로 선언. finally블락에서 is5.close()
		
		byte[] arr6 = new byte[100]; 
		//한글 처리 #1 : byte[] 선언
	
		int data6=0;
		try {
			is6 = new FileInputStream(file5); //FileNotFoundException
			
			
			while((data6 = is6.read(arr6))!= -1) { //IOException
				//한글 처리 #2 : read(byte배열)
				String str6 = new String(arr6, 0, data6, Charset.forName("MS949"));
				//한글 처리 #3 : String(byte배열,offset,length,Charset.forName("encoding"))
				System.out.println(str6);
			}
		} catch (IOException e2) {
			System.out.println("예외");
		}finally {
			if(is6 != null) {	//is6이 null이 아닐때 객체를 메모리에서 제거
				try {
					is6.close();
				} catch (IOException e) {
					System.out.println("예외");
				}
			}
		}
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//2. is2 : 상대경로로 접근 -utf-8.txt , 예외처리 try~with resource로 예외처리
		System.out.println("==========utf-8 상대경로 1==========");
		
		File file2 = new File("src/chap19/Ex04/Exception-utf-8.txt");
		System.out.println(file2.getAbsolutePath());
		
		 
		try (InputStream is2 = new FileInputStream(file2)){
			//try (..) ..에 넣어줘야함
			Reader reader2 = new InputStreamReader(is2,"UTF-8");
			//Reader reader2 = new InputStreamReader(is2);
			//is2뒤에 UTF-8을 지정해줘야 글자가 꺠지지않고나옴
			BufferedReader in2 = new BufferedReader(reader2);
			int data2;
			while((data2 = in2.read()) != -1) { 
				System.out.print((char)data2);
			}
		} catch (IOException e) {
			System.out.println("예외발생.");
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("==========utf-8 상대경로 2==========");
		
		File file3 = new File("src/chap19/Ex04/Exception-utf-8.txt");
		System.out.println(file3.getAbsolutePath());
		try (InputStream	is3 = new FileInputStream(file3)){
			byte[] array1 = is3.readAllBytes();
			String str1 = new String(array1,"UTF-8");
			//String str1 = new String(array1,"UTF-8");
			//array1뒤에 UTF-8을 지정해줘야 글자가 꺠지지않고나옴
			System.out.println(str1);
			
		} catch (IOException e) {
			System.out.println("예외발생.");
			e.printStackTrace();

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("==========utf-8 상대경로 3==========");
		
		File file7 = new File("src/chap19/Ex04/Exception-utf-8.txt");
		System.out.println(file7.getAbsolutePath());
		try (InputStream is7 = new FileInputStream(file3)){
			byte[] array7 = is7.readAllBytes();
			String str7 = new String(array7,"UTF-8");
			System.out.println(str7);
			
		} catch (IOException e) {
			System.out.println("예외발생.");
			e.printStackTrace();
		}

		System.out.println("==========utf-8 상대경로 3-2==========");
		
		byte[] arr8 = new byte[100];
			// 한글처리 #1
		int data8 = 0;
		
		try (InputStream is8 = new FileInputStream(file7))
			//try (with resourse : 객체 생성, RAM를 사용) <= close() 자동으로 처리된다. AutoCloseable의 close() 구현한 클래스여야 한다.
			{
			while((data8=is8.read(arr8))!=-1) {
				//한글 처리 #2 : is.read(byte배열);
				String str8 = new String(arr8, 0, data8, Charset.forName("UTF-8"));
				//한글 처리 #3 : new String(byte 배열,[offset,length,]<==생략 가능"encoding");
				System.out.println(str8);
			}
		} catch (IOException e) {
			System.out.println("예외 발생");
		}
	
	
	
	
	
	
	
	}
}
