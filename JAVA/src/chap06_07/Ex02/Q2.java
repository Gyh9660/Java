package chap06_07.Ex02;

import java.util.Scanner;

public class Q2 {

	static void math (String...values) {
		int sum = 0; //들어온 정수값을 합하는 변수
		double avg;  //평균값을 저장하는 변수
		
		for (int i=0;i < values.length; i++) {
		//	sum = sum + values[i]; //value[i]번재 방의 값이 String 타입이므로 정수타입으로 변환필요
			//sum = sum + Integer.parseInt(values[i]);
				//Integer.parseInt(String) : 숫자형 String  타입을 정수로 변환
			sum += Integer.parseInt(values[i]);
		}
		avg = (double) sum/ values.length; //평균은 형변환이 반드시 필요
		System.out.println();
		System.out.println("임의로 들어온 값의 합계는 : " + sum);
		System.out.println("임의로 들어온 값의 평균은 : " + avg);
		
	}
	
	public static void main(String[] args) {
		//스캐너로 임의의 정수 값을 할당 받아서 합게와 평균을 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 값을 공백을 넣어서 입력하세요.>>");
		
		String num = sc.nextLine();  //공백이 들어가기 때문에 전체 정수값을 String
		String[] array1 = num.split(" "); //split는 구분자를 기준으로 글자를 잘라서 배열에 저장
		
		System.out.println();
		System.out.println("당신이 입력한 정수는 : ");
		for ( int i = 0; i<array1.length; i++) { //입력 되는 값들을 출력
			System.out.print(array1[i]+ " " );
		}
		math(array1); //가변 길이 메소드 math를 호출하면서 매개변수로 array1을 넣어 주면 된다.		
		
		
	}

}
