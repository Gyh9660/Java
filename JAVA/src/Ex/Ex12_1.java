package Ex;

import java.util.Scanner;

public class Ex12_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str[] = {"가위", "바위", "보"};
		String User,Com; //User 당신이 낸값(스캐너로 인풋)
						// Com 컴퓨터가 낸값(난수 발생기(Math.random()을 사용해서 인풋)
		int n; //컴퓨터가 낸값 ( 0 (가위), 1(바위), 2(보))
		System.out.println("컴퓨터와 \'가위 바위 보\' 게임을 합니다.");
		
		do {
			System.out.println("가위 바위 보 !! >>>");
			User = sc.next(); //사용자(당신이)가 내는값 :인풋
			if ( User.equals("그만")) break;	
			
			n = (int)(Math.random()*3); //컴퓨터가 내는 값 : 0, 1, 2
			Com = str[n]; 				//컴퓨터가 내는값 : 0(가위), 1(바위), 2(보)
			
			//사용자가 가위일때 ?
			if (User.equals("가위")) {
				if(Com.equals("가위")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n비겼습니다.");
				}else if(Com.equals("바위")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n졌습니다.");
				}else if(Com.equals("보")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n이겼습니다.");
				}
				// 사용자가 바위일떄 ?				
			} else if (User.equals("바위")) {
				if(Com.equals("가위")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n이겼습니다.");
				}else if(Com.equals("바위")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n비겼습니다.");
				}else if (Com.equals("보")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n졌습니다.");
				}
				// 사용자가 보일떄 ?
			} else if(User.equals("보")) {
				if (Com.equals("가위")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n졌습니다.");
				}else if(Com.equals("바위")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n이겼습니다.");
				}else if(Com.equals("보")) {
					System.out.println("사용자 : "+User+"\n컴퓨터 : "+Com+"\n비겼습니다.");
				}
			}
			
			
			
			
		}while (true);
		
		
		
		sc.close();
		System.out.println("프로그램을 종료 합니다.");
		/*int k = (int)(Math.random()*3); //0, 1, 2 : k의 값
			//Math.random() : 0.000000xxx ~ 0.999999xx
		System.out.println(k);
		 */
	}

}
