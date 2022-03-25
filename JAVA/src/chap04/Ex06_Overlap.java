package chap04;

public class Ex06_Overlap {

	public static void main(String[] args) {

		//1. if문 내에 if문 중복
		
		int value1 = 5;
		int value2 = 3;
		
		if (value1 > 5) {
			if ( value2 < 2) {
				System.out.println("실행 1");
			}else {
				System.out.println("실행 2");
			}
		}else { 
			System.out.println("실행 3");
		}
 		
		System.out.println("====================");
		
		//2. switch문 안의 for문 중첩
		int value3 = 1; 
		switch (value3) {
		case 1 :
			for(int k=10;k>0;k--) {
				System.out.print(k + " ");
			}
			break;
		case 2 :
			for (int k= 0; k<10;k++) {
				System.out.print(k+ " ");
			}
			break;
		}
		
		//3.f or문 내의 for문 (이중 for문)
		System.out.println();
		for (int i=0; i<3; i++) { //0부터 2까지
			for ( int j=0; j<5;j++) { //0부터 4까지
				
				if ( i == j) {
					System.out.println( i + "="+ j);
				}else {
					System.out.println(i + "," + j);
				}
			}
		}
		
		
	}

}
