package chap19.Ex08;
/*
 * Application Default : MS949
 * reader/Writer 의 하위 클래스를 사용하세요.
 * 
 * 1.콘솔에서 한글을 읽어서
 * C:\Temp\a\aaa.txt(MS949)
 * C:\Temp\b\bbb.txt(UTF-8)
 * 파일에 쓰세요
 * 
 * a,b폴더는 Application에서 생성
 * 
 * 2.두 파일에서 읽은 내용을 콘솔에 깨짐 없이 출력
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ex_Reader_Writer {

	public static void main(String[] args) {
		
		File file = new File("C:\\Temp\\a\\aaa.txt"); //MS949
		File file2 = new File("C:\\Temp\\b\\bbb.txt"); //UTF-8
		
		try(InputStreamReader isr = new InputStreamReader(System.in);	
			OutputStream os = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(os, "MS949");
		
			InputStreamReader isr2 = new InputStreamReader(System.in);	
			OutputStream os2 = new FileOutputStream(file2);
			OutputStreamWriter osw2 = new OutputStreamWriter(os2, "UTF-8");	){
				
			System.out.println("한글을 원하는 대로 입력 하세요(MS949) >>");
			
			int data;
			while((data = isr.read())!= '\r') { 
				 osw.write((char)data);
			}
				osw.flush();
				
			
			System.out.println("한글을 원하는 대로 입력 하세요(UTF-8) >>");
			int data2;
			while((data2 = isr2.read())!= '\r') { 
				 osw2.write((char)data2);
			}
				osw2.flush();
			} catch (Exception e) {}
			
			System.out.println();
		
		
			System.out.println("========콘솔에 출력=========");
			
			System.out.println();
			
			try (InputStream is = new FileInputStream(file);
				 InputStreamReader isr1 = new InputStreamReader(is);
				 
				 InputStream is2 = new FileInputStream(file2);
				 InputStreamReader isr2 = new InputStreamReader(is2,"UTF-8");){ 
				
				int data;
				while((data=isr1.read())!= -1) {
					System.out.print((char)data);
					}
				System.out.println();
				int data2;
				System.out.println();
				while((data2=isr2.read())!= -1) {
					System.out.print((char)data2);
					}	
					
				} catch (Exception e) {}	
			
				System.out.println();
		
	
		
	}

}
