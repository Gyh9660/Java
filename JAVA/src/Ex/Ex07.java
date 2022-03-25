package Ex;
import java.util.Scanner;
public class Ex07 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr1 =new int[10];
		
		System.out.println("양의 정수 10개 입력하시오");
		for(int i=0; i<arr1.length;i++) {
			arr1[i]=sc.nextInt();
		}
		
		for(int i=0; i<arr1.length;i++) {
			if(arr1[i] % 3 ==0) {
				System.out.print(arr1[i]+ " ");
			}
		}
		sc.close();
	}

}
