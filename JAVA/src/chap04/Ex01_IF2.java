package chap04;

public class Ex01_IF2 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 2;
		char operator = '+';
		
		int result = 0;
		
		if ( operator == '+') {
			result = num1 + num2;
		}else if (operator == '-') {
			result = num1 - num2;
		}else if (operator == '*' ) {
			result = num1 * num2;
		}else if ( operator == '/') {
			result = num1 / num2;
		}else {
			System.out.println("연산자 오류입니다.");
			return; //return이나오면 밑에 안나오고 그냥종료
		}
		
		System.out.println("결과 값은 :" + result + "입니다.");
	}
	
	
}
