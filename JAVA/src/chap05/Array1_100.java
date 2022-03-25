package chap05;

import java.util.Arrays;

public class Array1_100 {

	public static void main(String[] args) {
		System.out.println("=======혼자해본것=======");
		int[] arr1;
		arr1 = new int[100];
		
		for (int i=0; i<100; i++) { // i<100은 i<arr1.length로 수정하면 더 좋을것
			arr1[i] = i+1;	
		}
		
		for (int i=0; i < arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for (int k :arr1) {
			System.out.print(k+" ");
		}
		System.out.println();
		System.out.print(Arrays.toString(arr1));
		System.out.println();
		System.out.println("========수정해서보낸것========");
		/*int[] arr1;
		*arr1 = new int[100];*/
		for (int i=0; i<arr1.length; i++) {
			arr1[i] = i+1;
			System.out.print(arr1[i]+" ");	
			}
		System.out.println();
		for(int k : arr1) {
			System.out.print(k + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(arr1));
		
	}

}
