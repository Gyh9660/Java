package chap19.Ex08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

//InputStreamReader : byte ===> char charSet (MS949,UTF-8)지정해서 파일을 읽어 올 수 있다.
//OutputStreamWriter : byte ===> char charSet (MS949,UTF-8)지정해서 파일을 저장 할 수 있다.



public class OutputStreamWriter_1 {

	public static void main(String[] args) {

		//1. FileWriter를 통해서 데이터 쓰기(default : MS949)
		File osw1 = new File("src\\chap19\\Ex08\\osw1.txt"); //MS949
		File osw2 = new File("src\\chap19\\Ex08\\osw2.txt"); //UTF-8
		
		try (Writer writer = new FileWriter(osw1);){
			
			
			writer.write("OutputStreamWriter1 예제 파일 입니다. \n".toCharArray()); //String 을 char배열에 저장
			writer.write("한글과 영문이 모두 포함되어 있습니다."); //String
			writer.write('\n'); //char 저장
			writer.write("Good Bye !!!! \n\n"); //영문
			writer.flush();
			
			
		} catch (IOException e) {}
	
		//2. FileWriter를 사용해서 (Default : MS949 ====>UTF-8 파일 쓰기)
		
		try (OutputStream os = new FileOutputStream(osw2);
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");){
			//OutputStreamWriter : byte ==> char
			
			osw.write("OutputStreamWriter1 예제 파일 입니다. \n".toCharArray()); //String 을 char배열에 저장
			osw.write("한글과 영문이 모두 포함되어 있습니다."); //String
			osw.write('\n'); //char 저장
			osw.write("Good Bye !!!! \n\n"); //영문
			osw.flush();
			
			
		} catch (IOException e) {}
		
	
	
	
	
	
	
	
	}

}
