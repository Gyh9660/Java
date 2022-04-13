package chap19.Ex07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class PrintStreamExample_2 {

	public static void main(String[] args) {

	//1. File 객체 생성.
		File outFile1 = new File("src\\chap19\\Ex07\\printstream3.txt");
		File outFile2 = new File("src\\chap19\\Ex07\\printstream4.txt");
				
	//2.
	try (PrintStream ps = new PrintStream(outFile1);
			){
			ps.println(5.8); //double 출력	 <== 줄력후 라인 개행
			ps.print(3 + "안녕" + 12345 + "\n"); //<== 출력후 라인 개행x
			ps.printf("%d 이 호출되었습니다.  \n ",7);//<=="%d" : int값을 호출
			ps.printf("%s %f","안녕",5.8); //<== % : string 호출, %f : double 호출
			
		} catch (Exception e) {}
				
		try(InputStream is = new FileInputStream(outFile1);){
			byte[] byteArray1 = new byte[100];
			int count = is.read(byteArray1);
			System.out.println(new String(byteArray1, 0, count, "UTF-8"));
		}catch(Exception e) {}
		
	
		
		
	}

}
