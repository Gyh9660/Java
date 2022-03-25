package chap04;

public class Ex05_DoWhile {

	public static void main(String[] args) {

		//1. while문과 do-while문의 비교 : 실행이 0인 경우 (false)
		System.out.println("==========반복횟수가 0인 경우===========");
		int a = 0;
		while(a<0) {
			System.out.print(a + " "); //조건이 true 일때만 실행됨
			a++;
		}
		System.out.println("=================");
		a = 0;
		do {
			System.out.println(a+ " "); // do while문에서 무조건 1번은 실행됨
			a++;
		}while (a < 0); //조건이 false
		
		System.out.println("=====반복 횟수가 1인 경우=======");
		
		// 2. 반복횟수가 1인경우 
		
		a = 0;
		while (a < 1) {
			System.out.print(a + " ");
			a++;
		}
		
		System.out.println();
		
		a = 0;
		do {
			System.out.print(a + " ");
			a++;
		} while (a <1);
		
		System.out.println();
		System.out.println("======반복 횟수가 10번인 경우=========");
		//3. 반복 횟수가 10번인 경우
		
		a = 0;
		while (a<10) {
			System.out.print(a + " ");
			a++;
		}
		
		System.out.println();
		
		a=0 ; 
		do {
			System.out.print(a + " ");
			a++;
		}while (a <10 );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
