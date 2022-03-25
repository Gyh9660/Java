package chap06_07.Ex06;

import java.util.Scanner;

public class Ex_Exercise {
	
	static void math (String...values) {
		int sum = 0;
		double avg;
		int c = 0;
		
		for(int i=0; i<values.length; i++) {
			if(i % 2 == 1) {
			sum += Integer.parseInt(values[i]);
			c++;
			}
		}
		avg = (double) sum/c;
		System.out.println();
		System.out.println("운동종목의 구성원의 총 합계: "+sum);
		System.out.println("운동중목의 평균 구성원 : "+avg);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("운동과 인원수를 공백을 넣어서 입력.>>");
		while(true) {
			String num = sc.nextLine();
			String [] array1 = num.split(" ");
		
			if (num.equals("그만")) {
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println();
				System.out.println("운동과 인원수는");
				for(int i=0; i<array1.length; i++) {
					System.out.print(array1[i]+" ");
				}
			}	
		
			math(array1);
		}
		sc.close();
	}

}
