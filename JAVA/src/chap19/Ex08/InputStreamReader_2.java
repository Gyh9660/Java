package chap19.Ex08;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class InputStreamReader_2 {

	public static void main(String[] args) {

		//1. 콘솔 입력(MS949) : default chatSet , byte 스트림
		
		try{
		//InputStreamReader : byte ==> char로 변환
		//System.in : 콘솔 입력, byte 
		
		//isr은 byte를 char로 변환한 것을 가지고 있음.
			
		InputStreamReader isr = new InputStreamReader(System.in,"MS949");	
			
		System.out.println("한글을 원하는 대로 입력 하세요 >>");
		int data;
		while((data = isr.read())!= '\r') { //파일은 -1까지지만 콘솔은 \r까지 
			//콘솔 입력 대기↑
			System.out.print((char)data);
		}
		
		System.out.println();
		System.out.println(isr.getEncoding());
			
		} catch (Exception e) {}
		
		System.out.println();
		System.out.println("===================================");
		
		//2. 콘솔 입력 (UTF-8)
		
		try (InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");	){
		//InputStreamReader : byte ==> char로 변환
		//System.in : 콘솔 입력, byte 
		
		//isr은 byte를 char로 변환한 것을 가지고 있음.
			
		System.out.println("한글을 원하는 대로 입력 하세요 >>");
		int data;
		while((data = isr.read())!= '\r') { //파일은 -1까지지만 콘솔은 \r까지 
			//콘솔 입력 대기↑
			System.out.print((char)data);
		}
		
		System.out.println();
		System.out.println(isr.getEncoding());
			
		} catch (Exception e) {}
	
		
	}

}
