package chap19.Ex06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

// 콘솔에서 배열 100byte 이하 한글을 인풋 받은 값을 input.txt에 저장 후 ,charSet : Default
// input.txt 파일에서 값을 읽어서 콘솔에 출력.

//예외 throws로 처리



public class Ex06_ConsoleInputOutObject {

	public static void main(String[] args) throws IOException {
		File outFile = new File ("src/chap19/Ex06/input.txt");
		
		InputStream is = new FileInputStream(outFile);
		System.out.println("========콘솔에 값 입력=============");
		System.out.println("입력하세요>>");
		
		InputStream is2 = System.in;
		
		byte[] isArray2 = new byte[100];
		int count2 = is2.read(isArray2);
		String str2 = new String (isArray2, 0, count2, Charset.defaultCharset());
		System.out.println(str2);
		
		System.out.println("============input.txt에 값 저장=============");
		
		OutputStream os = new FileOutputStream(outFile);
		OutputStream os2 = System.out;
		
		byte[] osArray1 = str2.getBytes(Charset.defaultCharset());
		
		os.write(osArray1,0,count2);
		
		os.flush();
		
		System.out.println();
		
		System.out.println("==========input.txt의 값 읽어오기============");
		byte[] isArray1 = new byte[100];
		int count1 = is.read(isArray1);
		String str1 = new String (isArray1, 0, count1, Charset.defaultCharset());
		System.out.println(str1);
		
		System.out.println("==============System.out으로 콘솔에 출력============");
		os2.write(isArray1, 0, count1);
		
		os2.flush();
		
		os2.close();
	}

}
