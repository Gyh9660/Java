package Ex;

public class Ex04 {

	public static void main(String[] args) {
		for(int i=1; i<5;i++) { // i=0;���� �ٲٰ� i<4�� �ٲ۵�
			for(int j=0; j<i;j++) { // j<= i�� �ٲ۰� ���� �����Ű��� (����ȭ���ڵ�..?)
				System.out.print("*");
			}
			System.out.println();
		}
		/*
		 * 1 , 0
		 * 2 , 0 / 2 , 1
		 * 3 , 0 / 3 , 1 / 3 , 2
		 * 4 , 0 / 4 , 1 / 4 , 2 / 4 , 3
		 * vs
		 * 0 , 0
		 * 1 , 0 / 1 , 1
		 * 2 , 0 / 2 , 1 / 2 , 2
		 * 3 , 0 / 3 , 1 / 3 , 2 / 3 , 3
		 */
		
	}

}
