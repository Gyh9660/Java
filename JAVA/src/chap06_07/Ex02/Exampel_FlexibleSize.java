package chap06_07.Ex02;

import java.util.Scanner;

public class Exampel_FlexibleSize {

	public static void main(String[] args) {

		//[문제] : 스캐너로 임의의 정수값을 받아서 합계, 평균 출력
		Scanner sc = new Scanner(System.in);
		int a;
		int c=0;
		int d=0;
		double avg;
		String b;
		while(true) {
			System.out.println("정수를 입력해주세요");
			b=sc.next();
			
			if(b.equals("그만")) {
				break;
			}else {
			c+=Integer.parseInt(b);
			d++;
			}
		}avg = (double) c/d;
		System.out.println("합계는 : "+ c);
		System.out.println("평균은 : "+ avg);
		
	}
	
}
