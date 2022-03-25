package Ex;

public class Ex10_1 {

	public static void main(String[] args) {

		int a, b ; // a변수는 10의 자리를 표현하는 변수, b는 1의자리를 표현하는 변수
		
		for(int i=1; i<100; i++) {
			a = i/10; // i를 10으로 나눠서 몫만 가져옴 a=는 10의자리를 뜻함
			b = i%10; // i를 10으로 나눠서 나머지만 가져옴 b=는 1의자리를 뜻함
			
			if ((a==3 || a==6 || a==9)&&(b==3|| b==6|| b==9)) {
				System.out.println(i+ "짝짝");
			} else if ((a==3 || a==6 || a==9)&&(b!=3 || b!=6 || b!=9)) {
				System.out.println(i+ "짝");
			} else if ((a!=3 || a!=6 || a!=9)&&(b==3 || b==6 || b==9)) {
				System.out.println(i+ "짝");
			}
			
		}
		
		
	}

}
