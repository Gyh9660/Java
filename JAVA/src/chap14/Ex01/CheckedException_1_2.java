package chap14.Ex01;

public class CheckedException_1_2 {

	public static void main(String[] args) {
		try {
			System.out.println(10/0); //프로그램이 비정상 종료되어 버린다.
										//예외에 대한 처리
			
		}catch (ArithmeticException e) {
			//try{}에서 오류가 발생할 경우에 작동된다.
			//e.printStackTrace(); //오류에 대한 자세한 정보를 출력
			System.out.println("0을 넣을 수 없습니다!!!");
			//catch{}에 값이 없어도 설정을 따로 하지 않아도 예외처리가 됨
		
		}finally {
			//try{}이 오류가 없어도 작동(O), 오류가 있어도 작동(O)
			//try{}가 작동되면 항상 작동
			//객체를 사용후 객체의 메모리를 제거할때 사용, 예) sc.close();
			System.out.println("finally{} 블락은 항상 호출 됩니다.");
		}
		
		System.out.println("프로그램을 정상 종료 합니다."); //정상 종료
		
	}
}
