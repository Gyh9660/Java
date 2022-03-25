package chap05;

import java.util.Arrays;

public class Ex_02 {

	public static void main(String[]args) {
		int[]arr2=new int[300];
		for (int i =0; i<arr2.length; i++) {
			arr2[i]= (i+1)*3;
		}
		
		for (int i = 0; i<arr2.length; i++) {
			System.out.println(i + "번째방의 값 "+arr2[i] );
		}
		
		System.out.println("============");
		
		for (int g : arr2) {
			System.out.println(g);
		}
		System.out.println("===============");
		
		System.out.println(Arrays.toString(arr2));
		
		
		System.out.println("===================");
		
		for (int i =100; i <arr2.length; i++) {
			if (i%2 ==1)
				System.out.println(i+"번째방의 값"+ arr2[i]);
		}
		
		
		
	}
}
