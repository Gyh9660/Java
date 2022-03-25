package chap04;

public class Ex04_While {

	public static void main(String[] args) {

		//while문의 기본 문법
		
		int a = 0; // 초기식 , 초기값
		while(a<10) { // 조건
			System.out.print(a + " "); //실행내용
			
			a++; //증감식 
		}
			//0,1,2,3,4,5,6,7,8,9 : 10번 출력
		System.out.println();
		
		// while 문을 for문으로 변환
		
		for( int i = 0; i<10; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//while 문의 10부터 시작해서 1씩 감소
		int b = 10;
		while(b>0) {
			System.out.print(b + " ");
			b--;
		}
		
		System.out.println();
		
		//for 문의 10부터 시작해서 1씩 감소
		
		for(int j = 10; j>0; j--) {
			System.out.print(j + " ");
		}
		
		System.out.println();
		
		// while문의 무한루프
		
	/*	while (true) {
			System.out.println("while의 무한루프 발생");
		} */

		// while의 무한루프 중지
		
		int c1 = 0;
		while (true) {
			
			if (c1 >100) {
				break;
			}
			System.out.println(c1);
			
			c1++;
		}
		
		
		
		
		
		
		
	}

}
