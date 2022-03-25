package chap14.Ex01;

import java.util.Scanner;

//Error : 프로그래머가 제어할 수 없는 부분, OS 발생하는 Error, H/W Error
//Exception : 예외 : 프로그래머가 제어할 수 있는 부분,
	// 예외가 발생 되면 프로그램이 종료되어 버린다.
	// 예외가 발생 되더라도 프로그램이 종료되지 않게 처리(예외처리)

//ArithemticException: 어떤수를 0으로 나누면 발생하는 예외
	//컴퓨터는 어떤수를 0으로 나눌경우 계산 불가.

public class CheckedException_0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 하나를 입력하세요");
		
		int b = 10;
		while(true) {
		  int a = sc.nextInt();
		  if(a==0) {break;}
		  System.out.println((double)b/a);
		  
		}
		System.out.println("장비를 정지합니다.");
		sc.close();
		
		
		
	}

}
