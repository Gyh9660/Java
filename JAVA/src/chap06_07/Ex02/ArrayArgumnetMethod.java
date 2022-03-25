package chap06_07.Ex02;

import java.util.Arrays;

public class ArrayArgumnetMethod {
	
	// static이 있으면서 같은 클래스에 존재하는 메소드 :메소드 이름으로 호출이 가능
	//public키는 다른패키지에서 접근 가능하도록 설정: 
	//접근제어자(public, protected,default,private)
	//접근제어자가 생략되어있으면 : default (같은 패키지에서 접근 가능하도록 설정)
	
	static void printArray (int[] a) {  // 객체생성없이 바로 호출가능
		System.out.println("===========Arrays.toString()로 출력=======");
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		
		System.out.println("========for문=========");
		//for문을 사용해서 출력
		
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		
		System.out.println("========향상된 for문으로 출력=========");
		// enhanced for 문을 사용해서 출력
		for (int k : a) {
			System.out.print(k+" ");
		}
		System.out.println();
		
		
	}
	
	public static void main(String[] args) {
		//배열을 매개 변수로 가지는 메소드 호출
		
		int [] a= new int[] {1,2,3}; // 배열변수를 선언하고 값을 넣은후 
		
		printArray (a); // 메소드호출시 배열변수 입력
		
		printArray (new int[] {4,5,6,7,8});
		
		//printArray ({1,2,3}); // 오류발생
		
		
	}

}
