package chap05;

import java.util.Arrays;

public class Array2_300 {

	public static void main(String[] args) {

		int[] arr2 = new int[300];
		
		for (int i=0; i<arr2.length; i++) {
			
			arr2[i] =(i*3)+3;	
		}
		for (int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+ " ");
		}
		System.out.println();
		for (int k : arr2) {
			System.out.print(k+ " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(arr2));
		System.out.println();
		for (int i=101; i<arr2.length; i+=2) {
			System.out.print(arr2[i]+" ");
		}
	}

}
