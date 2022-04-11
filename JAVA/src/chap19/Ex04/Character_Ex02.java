package chap19.Ex04;
/*
 * A~Z 까지의 아스키 코드값 추력
 * 출력결과
 * =======================
 * A,65
 * B,66
 * C,67
 *.... 
 * Z,90
 *
 *a~z까지의 아스키 코드값 출력
 *출력결과
 *================
 *a,97
 *b,98
 *...
 *z,97
 */
public class Character_Ex02 {

	public static void main(String[] args) {
		System.out.println("출력결과");
		System.out.println("=================");
		/*for(int i =65; i<91;i++) {
			
			System.out.println((char)i +", "+i);
		}*/
		int[] arr1 = new int[26];
		 for(int i=0; i<arr1.length; i++) {
			 arr1[i] = 65+i;
			 System.out.println((char)arr1[i] +"," +arr1[i]);
		 }
		System.out.println();
		System.out.println("출력결과");
		System.out.println("=================");
		/*for(int i =97; i<123;i++) {
			
			System.out.println((char)i +", "+i);
		}
		*/
		int[] arr2 = new int[26];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] =97+i;
			System.out.println((char)arr2[i] +"," +arr2[i]);
		}
		
		
		
	}

}
