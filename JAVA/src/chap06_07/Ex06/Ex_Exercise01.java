package chap06_07.Ex06;

import java.util.Scanner;

public class Ex_Exercise01 {

	public static void main(String[] args) {
		/*
		 * 임의의 운동의 이름을 넣고 해당 운동의 구성원(명수)를 넣어서 출력하는 프로그램을 작성후, 전체 합 및 평균을 구하는 프로그램을 작성하시오.
		 * 예)
		 * 입력>>
		 * 탁구 2 야구 9 축구 11 농구 6 씨름 2
		 * 출력>>
		 * 탁구 : 2, 야구 ㅣ 9, 축구 : 11, 농구 : 6, 씨름 : 2
		 * 운동종목의 구성원 총 합계:
		 * 운동종목의 평균 구성원수 :
		 * 
		 * "그만: 이라고 입력하면 프로그램 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("운동이름 구성원수를 공백을 이용해서 입력하세요.");
		System.out.println("예) 입력 >>>탁구 2 야구 9 축구 11 농구 6 씨름 2");
		
		String str; 	//전체 String값을 인풋받는 변수
		int sum ; 	//운동구성원의 합을 저장하는 변수
		int memberCount;
		double avg; 	// 구성원의 평균을 구하는 변수: (double)전체구성원의 합/종목의 수
		String[] arr ; 	// 공백을 기준으로 잘라서 배열에 저장하는 변수
		int b ;	// 각 종목의 구성원을 담는 변수
		
		do {
			sum = 0;
			avg = 0;
			b = 0;
			memberCount=0;
			str=sc.nextLine(); //sc.next() : 공백까지만 String
			//sc.nextLine() : 엔터 까지 전체를 String
			
			arr = str.split(" ");//str을 공백을 기준으로 잘라서 arr배열에 저장
			if (str.equals("그만")){ //str은 참조 차료 형이므로 str.equals()를 써야한다.
				break;
			}
			
			for ( int i = 0 ; i < arr.length; i++) {//arr.length :배열의 index 0 ~마지막 방까지
				if (i % 2 != 0) { // i : 방의 번호 이고 숫자만 가지고 온다
					b = Integer.parseInt(arr[i]); //각 방의 String 타입을 정수로 변환
					sum += b; //sum = sum + b //sum 전체구성원의 합
					memberCount++; // avg= sum/memberCount
					
				}
			}
			avg = (double)sum/memberCount; //평균
			
			System.out.println(str);
			System.out.println("sum : "+sum );
			System.out.println("avg : "+avg );
		
			
			
		} while (true); //sum이계속 누적되는 문제발생 나중에 확인
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	
	
}
