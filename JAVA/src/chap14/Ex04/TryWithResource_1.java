package chap14.Ex04;

import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResource_1 {

	public static void main(String[] args) {
		//1. 수동 리소스 해제 (기존 프로그램이 사용) => 코드가 길고 지저분하다.
		System.out.println("문자를 입력 하세요!");
	
		InputStreamReader isr2 = null; //사용후 반드시 메모리에서 객체를 삭제, isr2.close();
		//System.in : 콘솔에서 입력을 받도록 처리. 1번만 인풋을 받을 수 있다.
		//객체가 종료 되면 두번 인풋을 받지 못한다.
		try {
			
			isr2 = new InputStreamReader(System.in);
			char input = (char)isr2.read(); //일반 예외 (checked 예외) : IOException: 입력출시예외
			System.out.println("입력글자 = "+ input);
		}catch (IOException e) {
			e.printStackTrace(); //try{}에서 예외 발생시 예외에대한 자세한 정보 출력
		}finally { //객체를 사용후에 메모리 영역에서 삭제
			//리소스 해제 : isr2.close();
			if ( isr2 != null) {
				try {
					isr2.close();//일반예외 : IOException  반드시 try catch로 묶어줘야함
				} catch (IOException e) {
					
					e.printStackTrace();
				}  
			}
		}
		
		//2. 자동 리소스 해제 (Java 1.7버전부터 자동으로 리소스를 해제) => 코드가 간결하다.(필요조건이 있다)
			//1. 사용하는 객체가 InputStreamReader 인터페이스를 구현한 객체여야 한다.
			//2. 반드시 객채에 close()가 존재해야 한다.
			// 위의 2가지 조건을 만족할 때 자동 리소스 해제
			//try(자동으로 리소스를 해제할 객체 선언) {} catch{} finally{} 
		
		
		//InputStreamReader는 InputStreamReader 인터페이스를 구현하고있다. close()도 가지고 있다.
		// Try with Resource : try (with resource : 객체 메모리 로드){}
		try (InputStreamReader isr1 = new InputStreamReader(System.in); ){
			char input = (char) isr1.read();
			System.out.println("입력글자 = "+ input);
		}catch (IOException e){
			e.printStackTrace();
		} //finally 블락을 생략하더라도 객체를 자동으로 isr1.close()		
		
		
		
		
		
	}

}
