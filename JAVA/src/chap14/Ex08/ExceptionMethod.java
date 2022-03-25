package chap14.Ex08;

//메소드의 throws를 전가, 전가, 전가 main전가.
	//main 까지 예외가 전가돠 된 경우는 예외의 결과창을 띄우고 프로그램 종료.
	//main 메소드는 예외 처리 하지 않는다.

class AA{
	public void abc() throws NumberFormatException{
		bcd();
	}
	public void bcd() throws NumberFormatException{
		cde();
	}
	public void cde() throws NumberFormatException{
		int num = Integer.parseInt("10A");	//Exception발생, NumberFOrmatException 발생
	}
}
public class ExceptionMethod {

	public static void main(String[] args){

		//1. 객체 생성
		AA aa = new AA();
		
		//2. 메소드 호출
		try {
			aa.abc(); //실행 예외 (컴파일 단계에선 오류가 없음)
			
		}catch(NumberFormatException e){
			e.printStackTrace(); //예외의 자세한 정보를 출력
			System.out.println("예외가 발생 되었습니다."); 
		}
		
		
		
		System.out.println("프로그램 종료");
	}

}
