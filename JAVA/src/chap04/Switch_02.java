package chap04;



import java.util.Scanner;

public class Switch_02 {
	
	
			public static void main(String[] args) {
				System.out.println("operatior을 입력해 주세요.");
				Scanner sc = new Scanner(System.in);
				char operator = sc.next().charAt(0);
				
				int num1 = 10;
				int num2 = 2;
				
				int result = 0;
				
				
				switch (operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				default:
					System.out.println("연산자 오류입니다.");
					sc.close(); //리턴앞에서도 한번 리턴을 만나면 빠져나와서 종료되기떄문에 리턴앞에서 한번해줘야함
					return;
				}
				System.out.println("결과 값은 :" + result + "입니다.");
				
				sc.close(); //스캐너클로즈를 메인메소드끝날떄한번
	}

}
