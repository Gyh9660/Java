package chap05;

import java.util.Arrays;

public class Ex05_ReadArrayData {

	public static void main(String[] args) {

		int[] array = new int[] {3,4,5,6,7};
		
		// 1. 배열의 방(index)의 길이 구하기
		System.out.println(array.length); // 방의 갯수를 출력 : 5
		
		//2. 출력하기 1 : 방번호를 직접 찍어서 출력 : 특정 방의 값을 가져올 때
		System.out.print(array[0]+" ");
		System.out.print(array[1]+" ");
		System.out.print(array[2]+" ");
		System.out.print(array[3]+" ");
		System.out.print(array[4]+" ");
		//System.out.print(array[5]+" "); // ArrayIndexOutOfBoundsException, 방번호를 초과한 경우를 출력시 오류 발생
		System.out.println();
		
		//3. 출력하기 2 : for 문을 사용해서 특정 범위를 지정해서 출력
		for (int i=0; i< array.length; i++) { //****array.length****
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
		// for 문을 사용해서 특정범위만 출력하기
		for (int i= 1; i<3; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
		
		
		//4. 출력하기 3 : 향상된 for문, 처음 방부터 마지막 방까지 순환하면서 출력, 단점?특징: 범위를 지정해서 출력할수 없다.
			// 구문은 for문에 비해서 짧다. 
		
		for ( int k : array) { //for ( 출력할자료형 변수 : 배열변수) { 실행구문, k를 출력 }
			System.out.print(k + " ");
		} //향상된 for문 무조건 첫방부터 마지막방까지 출력
		
		System.out.println();
		//5. 출력하기 4 : Arrays.toString(배열변수명) 배열변수안의 모든값 출력
		
		System.out.println(Arrays.toString(array));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
