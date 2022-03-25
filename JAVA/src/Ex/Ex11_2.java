package Ex;

import java.util.Scanner;

public class Ex11_2 {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		String[] course= {"Java", "C++","HTML5","컴퓨터구조","안드로이드"};
		int[] score = {95,88,76,62,55};
		
		String name = null; //scanner로 과목의 문자열을 받는 변수
		int i = 0; //방번호를 담는 변수
		
		System.out.println("프로그램을 종료하려면 \"그만\" 을 입력 하세요."); //"와" 안에서 "를 나오게하려면 \"\"로 사용 \가 "특수문자를 출력하게해줌
		while (true) { //특정 조건을 만족할때 까지 계속 루프 돌아감./무한루프
			System.out.println("과목 이름 >>> ");
			name = sc.next();      // scanner로 과목이름을 받아서 변수 name에 할당.
			
			if (name.equals("그만")) break; //주의 :name은 참조변수 이므로 ==를 사용하면 안됨. equals를 사용해야함.
			//course의 각방을 돌면서 scanner로 받은 name 변수의 값이 같을때 출력
			for(i=0; i<course.length; i++) {
				if(course[i].equals(name)) {
					System.out.println(course[i] + " 점수는 : "+ score[i]);
					break;
				}
				//마지막 방까지 갔을때 검색이 안된경우ㅓ
				if(i == course.length-1) { //i변수가 마지막 방까지 왔을때 검색이 안된경우
					System.out.println("없는 과목");
				}
				
			}
		}
		sc.close();
		System.out.println("프로그램을 종료합니다.");
		
		
		
	}

}
