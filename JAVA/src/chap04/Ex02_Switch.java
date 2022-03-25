package chap04;
public class Ex02_Switch {
	public static void main(String[] args) {

		/*
		 * Switch문 break를 처리하지 않았을때 해당 case로 이동을하고
		 * switch문을 빠져나오지 않고 밑에있는 것들도 계속 진행(브레이크 만나기 전까진 하위의 case를 모두 실행한다.) 
		 */
		
		int value1 = 2; // 값2가 스위치에 들어가 case2 으로 이동
		
		switch ( value1 ) {
		case 1:
			System.out.println("A 학점");
		case 2:
			System.out.println("B 학점");
		case 3:
			System.out.println("C 학점");
		default :
			System.out.println("F 학점");
		
		}

		System.out.println("================");

		// 2. switch문에 break가 포함된 경우
		
		
		int value2 = 3;
		
		switch ( value2 ) {
		case 1:
			System.out.println("A 학점");
			break;
		case 2:
			System.out.println("B 학점");
			break;
		case 3:
			System.out.println("C 학점");
			break;
		default :
			System.out.println("F 학점"); // switch문의 마지막은 case는 (default) break를 생략 가능
		}

		System.out.println("====================");
		
		value2 = 2;
		
		if ( value2 == 1 ) {
			System.out.println("A 학점(if)");
		}else if (value2 == 2) {
			System.out.println("B 학점(if)");
		}else if (value2 == 3) {
			System.out.println("C 학점(if)");
		}else {
			System.out.println("F 학점(if)");
		}
		
		System.out.println("======================");
		/*
		 * switch 문 사용해서 점수가 7점 이상은 pass, 7점 미만은 fail을 출력 ( 점수 : 1 ~ 10 )
		 */
		
		
		int a = 10;
		
		switch (a) {
		case 10:
		case 9:	
		case 8:
		case 7:
			System.out.println("Pass");
			break;
		default:
			System.out.println("Fail");
		}
		
		
		
	}

}
