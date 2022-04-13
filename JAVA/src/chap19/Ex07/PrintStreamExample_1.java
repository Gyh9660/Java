package chap19.Ex07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

//PrintStream : Filter Stream (추가기능을 제공하는 Stream), 기반 스트림이 필요.
	//다양한 방법으로 출력에 특화된 Stream, flush()가 자동으로 적용되 따로 호출할 필요가 없다.
	//pirintln(), print(), printf()
	// 파일 출력, 콘솔 출력, ...

public class PrintStreamExample_1 {

	public static void main(String[] args) {
		//1. File 객체 생성.
		File outFile1 = new File("src\\chap19\\Ex07\\printstream1.txt");
		File outFile2 = new File("src\\chap19\\Ex07\\printstream2.txt");
		
		//2. PrintStream(FileOutputStream(File)) <==파일에 출력
		try (OutputStream os1 = new FileOutputStream(outFile1);
			 PrintStream ps = new PrintStream(os1); //filter Stream(추가기능을 제공)이어서 단독으로 사용하지 못하고 기반스트림이 필요하다.
		){
			
			ps.println(5.8); //double 출력	 <== 줄력후 라인 개행
			ps.print(3 + "안녕" + 12345 + "\n"); //<== 출력후 라인 개행x
			ps.printf("%d 이 호출되었습니다. \n ",7);//<=="%d" : int값을 호출
			ps.printf("%s %f","안녕",5.8); //<== % : string 호출, %f : double 호출
			
			//ps.flush <== 자동으로 호출
			
			
		} catch (Exception e) {}
		
		
		//3. PrintStream(File) <== 파일에 출력
		
		try (PrintStream ps = new PrintStream(outFile2);){
			
			ps.println(5.8); //double 출력	 <== 줄력후 라인 개행
			ps.print(3 + "안녕" + 12345 + "\n"); //<== 출력후 라인 개행x
			ps.printf("%d 이 호출되었습니다. \n ",7);//<=="%d" : int값을 호출
			ps.printf("%s %f","안녕",5.8); //<== % : string 호출, %f : double 호출
		} catch (FileNotFoundException e) {}
		
		
		//4. PrintStream ps = System.out; <== 콘솔에 출력
		try(
			OutputStream os2 = System.out;
			PrintStream ps = new PrintStream(os2);) {
			
			ps.println(5.8); //double 출력	 <== 줄력후 라인 개행
			ps.print(3 + "안녕" + 12345 + "\n"); //<== 출력후 라인 개행x
			ps.printf("%d 이 호출되었습니다. \n ",7);//<=="%d" : int값을 호출
			ps.printf("%s %f","안녕",5.8); //<== % : string 호출, %f : double 호출
			
		}catch (Exception e) {}
		
		System.out.println("==========================");
		
		
		//5. PrintStream ps = System.out; <== 콘솔에 출력
		try(
				PrintStream ps = System.out;) {
			
			ps.println(5.8); //double 출력	 <== 줄력후 라인 개행
			ps.print(3 + "안녕" + 12345 + "\n"); //<== 출력후 라인 개행x
			ps.printf("%d 이 호출되었습니다. \n ",7);//<=="%d" : int값을 호출
			ps.printf("%s %f","안녕",5.8); //<== % : string 호출, %f : double 호출
			
		}catch (Exception e) {}
		
		
		
		
	}

}
