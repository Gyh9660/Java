package Ex;

public class Ex04 {

	public static void main(String[] args) {
		for(int i=1; i<5;i++) { // i=0;으로 바꾸고 i<4로 바꾼뒤
			for(int j=0; j<i;j++) { // j<= i로 바꾼게 좀더 맞을거같음 (최적화된코드..?)
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
