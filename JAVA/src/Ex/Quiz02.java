package Ex;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		boolean run = true;
		int nu = 0; //스캐너로 번호를 인풋
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=======================================================");
			System.out.println(" 1. 19단 출력 | 2. 홀수단만 출력 | 3. 3의배수단만 출력 |4.종료");
			System.out.println("=======================================================");
			System.out.println("번호를 입력해 주세요.");
			nu = sc.nextInt();
			if (nu == 1) { //이중 for문을 사용해서 1번을선택시 19단출력
				for(int i =1; i<20; i++) {
					for(int j=1; j<20;j++) {
						System.out.printf("%d * %d = %d",i,j,i*j);
						System.out.println();
					}
				}
			}else if ( nu == 2) { //이중 for문을 사용해서 2번선택시 홀수단만 출력
				for(int i =1; i<20; i+=2) {
					for(int j=1; j<20;j+=2) {
						System.out.printf("%d * %d = %d",i,j,i*j);
						System.out.println();
					}
				}
			}else if ( nu == 3) { // 3의 배수단만 출력
				for(int i=1; i<20; i++) {
					if(i % 3 == 0) {
						for(int j=1;j<20; j++) {
							System.out.printf("%d * %d = %d",i,j,i*j);
							System.out.println();
						}
					}
				}
			}else if ( nu == 4) { // 프로그램 종료
				break;
			}
			
		}while (run);
		sc.close();
		System.out.println("프로그램을 종료합니다.");
	}

}
