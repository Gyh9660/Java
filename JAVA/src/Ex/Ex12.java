package Ex;
import java.util.Scanner;
public class Ex12 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str[]= {"가위","바위","보"};
		String User,Com;
		int n;
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		while(true) {
			System.out.println("가위 바위 보 !");
			User =sc.next();
			if(User.equals("그만"))break;
				n= (int)(Math.random()*3);
				Com=str[n];
			if(User.equals("가위")) {
				if(str[n].equals("가위")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 비겼습니다.");
				}else if(str[n].equals("바위")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 졌습니다.");
				}else if(str[n].equals("보")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 이겼습니다.");
				}
			}if(User.equals("바위")) {
				if(str[n].equals("가위")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 이겼습니다.");
				}else if(str[n].equals("바위")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 비겼습니다.");
				}else if(str[n].equals("보")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 졌습니다.");
				}
			}if(User.equals("보")) {
				if(str[n].equals("가위")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 졌습니다.");
				}else if(str[n].equals("바위")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 이겼습니다.");
				}else if(str[n].equals("보")) {
					System.out.println("사용자 : "+User + ", 컴퓨터 : "+Com+" 비겼습니다.");
				}
			}
		
		}
		System.out.println("게임을 종료합니다..");
		sc.close();
	}
	

}
