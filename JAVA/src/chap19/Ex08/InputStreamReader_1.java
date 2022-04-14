package chap19.Ex08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


/*InputStreamReader : byte 데이터를 char 포멧으로 변환하는 객체.
 * 	//byte 포멧은 인코딩을 잘 지정해야 한다. <= encoding : MS949, UTF-8
 * 	//char 포멧으로 바꾸면 인코딩 타입을 신경쓸 필요가 없다.
 *	//사용목적 1.FileReader : default charSet 만 사용 가능하여서 MS949 이지만 외부 파일이 UTF-8을 읽어올 경우
 	  사용목적 2. 네트워크에서 전송되는 스트림이 UTF-8, MS949 byte ====> char로 변환해서 처리하기 위해서
*/



public class InputStreamReader_1 {

	public static void main(String[] args) {
		
		//1. 파일 객체 생성
		File isr = new File("src\\chap19\\Ex08\\isr.txt"); //isr.txt는 UTF-8로 저장되어 있다.
		
		try(Reader reader = new FileReader(isr);) { //FileReader는 인코딩설정이 안된다. default Encoding만 사용가능하다.
			int data;
			
			while((data = reader.read()) != -1) { //MS949
				System.out.print((char)data);
			}
			
		} catch (Exception e) {}
		
		System.out.println();
		System.out.println("=======================================");
		
		
		//2. FileInputStream + InputStreamReader를 이용한 파일 읽기
		//InputStreamReader (is[InputStream] , "UTF-8"[charSet]);   byte ===> char로 변환
		
		
		
		
		try (InputStream is = new FileInputStream(isr);
			 InputStreamReader isr1 = new InputStreamReader(is,"UTF-8");){ //isr1 : char로 변환된것
			
			int data;
			while((data=isr1.read())!= -1) {
				System.out.print((char)data);
			}
			
			
		} catch (Exception e) {}
		
		
	}

}
