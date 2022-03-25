package chap01;

import java.util.Scanner;

public class Scannser과제 {

	public static void main(String[] args) {
		System.out.println("정수값을 입력하세요?");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		System.out.println( (value % 3 ==0)? "3의 배수입니다." : "3의 배수가 아닙니다.");
		sc.close();
	}

}
