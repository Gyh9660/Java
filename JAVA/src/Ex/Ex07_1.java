package Ex;

import java.util.Scanner;

public class Ex07_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] arr1 = new int[10]; //넣을값을 알수없으면 방만선언 방의갯수만 선언
		
		System.out.println("양의 정수 10개를 입력하시오 >>");
		
		for( int i=0; i<arr1.length;i++) { //for문을 사용해서 각방에 스캐너에서 던진값을 저장
			arr1[i]= sc.nextInt();
		}
		//3의 배수만 출력
		System.out.println("3의 배수는");
		for ( int i=0; i<arr1.length;i++) { // 배열의 각방의 값을 가지고와서
			if(arr1[i] % 3 == 0) { 			// 3으로 나눈 나머지가 0인경우 (3의배수)
				System.out.print(arr1[i]+ " ");
			}
		}
		sc.close();
	}

}
