package chap04;

public class Continue_01 {

	public static void main(String[] args) {
		System.out.println("======<<Ȧ��>>========");
		
		
		for(int i=1;i<20;i++) {
			if (i % 2 == 0) {
				continue;
			}
			for(int j =1;j<20;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println("==============");
		}
		
		
	System.out.println();
	System.out.println("========<<3�� ���>>===========");
	
	
		for(int i=1;i<20;i++) {
			if ( i % 3 != 0) {
				continue;
			}
			for(int j =1;j<20;j++) {
				
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println("==============");
		}

	}

}
