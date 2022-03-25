package chap06_07.Ex02;

public class EffectOfPrimaryDataArguejment {
	int abc; //필드 : heap영역 에 저장, 객체화를 시켜야 사용가능
		
	
	static int twice (int a) { //정수를 받아서 *2한 값을 리턴
		a =a *2;
		return a; // a변수는 메소드가 종료되면 메모리에서 날라가는 값(삭제)
	}
	
	
	
	public static void main(String[] args) {

		int a = 3; //지역변수 stack 변수명과 값이 저장
		int result1 = twice(3);
		System.out.println(result1);  //6
		
		int result2= twice(a);
		System.out.println(result2);	//6
		System.out.println(a);			//3 <== a가 최종적으로 main메소드안의 a출력
		//메소드 안의 변수들은 stack에저장
		
	}

}
