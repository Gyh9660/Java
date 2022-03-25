package chap04;

public class Ex01_IF {

	public static void main(String[] args) {

		//fif 문:
		/*
		 * if (조건) {
		 * 	조건이 차참일때 실행될 코드;
		 * }
		 */
		
		int value1 = 5;
		if (value1 > 3) {
			System.out.println("실행1 : 조건이 참일때 실행");
		}
		
		/*
		 * if (조건) {
		 * 		조건이 참일때 실행할 문장;
		 * } else {
		 * 		조건이 거짓일때 실행할 문장;
		 * }
		 */
		boolean bool1 = true;
		boolean bool2 = false;
		
		if (bool1) {
			System.out.println("실행 3");		// 조건이 true 일때 실행
		} else {
			System.out.println("실행 4");		// 조건이 false 일때 실행
		}
		
		if (bool2) {
			System.out.println("실행 5");		// 조건이 true 일때 실행
		} else {
			System.out.println("실행 6");		// 조건이 false 일때 실행
		}
		System.out.println("====================");
		// if~else 는 삼항 연산자로 변환이 가능
		System.out.println( (bool1)? "실행 7" : "실행 8"); // bool1이 참(true)이므로 "실행 7"이 출력
		System.out.println( (bool2)? "실행 7" : "실행 8"); // bool2가 거짓(false)이므로 "실행 8"이 출력
		
		/*
		 * if의 조건이 여러개 일대 ?
		 * 
		 * if (조건1) {
		 * 		조건1이 참일때 실행 코드;
		 * }else if (조건2) {
		 * 		조건2가  참일때 실행 코드;
		 * }else if (조건3) {
		 * 		조건3이 참일때 실행 코드;
		 * }else {
		 * 		위의 조건이 다 만족하지 않을때 실행 코드;
		 * }
		 */
		
		int value3 = 85;
		
		if (value3 >= 90) {
			System.out.println("A 학점 , 점수 : " + value3 );
		}else if (value3 >=80) {
			System.out.println("B 학점 , 점수 : " + value3); // 실행후에 if 문을 빠져나옴
		}else if (value3 >=70) {
			System.out.println("C 학점 , 점수 : " + value3);
		}else {
			System.out.println("F 학점 , 점수 : " + value3);
		}
		
		/*
		 * IF 문에서 조건의 순서가 바뀌어 있을 경우
		 */
		
		value3 =85;
		
		if (value3 >= 90) {
			System.out.println("A 학점 , 점수 : " + value3 );
		}else if (value3 >=70) {
			System.out.println("C 학점 , 점수 : " + value3); // 실행후에 if 문을 빠져나옴
		}else if (value3 >=80) {
			System.out.println("B 학점 , 점수 : " + value3);
		}else {
			System.out.println("F 학점 , 점수 : " + value3);
		}
		System.out.println("===================");
		
		/*
		 * 조건을 부여 할때 세밀 하게 적용
		 */
		value3 = 85;
		if (value3 <=100 && value3 >= 90) {
			System.out.println("A 학점");
		}else if ( value3 < 80 && value3 >=70) {
			System.out.println("C 학점");
		}else if ( value3 < 90 && value3 >=80) {
			System.out.println("B 학점");
		}else {
			System.out.println("F 학점");
		}
		
		/*
		 * if 문에서 실행문이 하나일때 {} 를 생략 할 수 있다.
		 */
		
		System.out.println("======================");
		
		if ( 3<5 )
			System.out.println("안녕하세요"); //if에서 {} 가 생략된 경우

		System.out.println("======================");
		
		if (3>5)
			System.out.println("안녕하세요. 2");
			System.out.println("반갑습니다.  ");
			
	}

}
