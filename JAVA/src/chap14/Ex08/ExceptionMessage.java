package chap14.Ex08;

public class ExceptionMessage {

	public static void main(String[] args) {
		//1. 예외객체 생성시 메세지 전달하지 않는 경우
		try {
			throw new Exception(); //강제 예외 발생, Exception의 기본 생성자 호출 시 메세지 (x)
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("=====================");
		//2. 예외객체 생성시 메세지 전달하는 경우
		try {
			throw new Exception("예외 메세지 출력"); //Exception객체 생성자에 String 값을 넣어주면 catch block에서 예외 message를 출력할 수 있다.
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
