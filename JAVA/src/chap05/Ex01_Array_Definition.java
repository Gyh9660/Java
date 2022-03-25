package chap05;

import java.io.StreamCorruptedException;

public class Ex01_Array_Definition {

	public static void main(String[] args) {

		/*
		 * 배열 변수 선언 바법
		 * 		- 배열은 하나의 배열 변수에 많은 데이터를 저장.
		 * 		- 배열은 선언시 동일한 자료형의 값을 저장, (컬렉션은 여러 데이터 타입을 저장)
		 * 		- 배열은 배열의 값을 저장할 방크기를 지정하면 방크기를 수정 할 수 없다. 
		 * (컬렉션은 방크기가 자동으로 늘어난다. )
		 * 
		 */
		
		// 배열 선언 방법
		
		int[] array1 = new int[3]; //배열을 선언과 동시에 배열방크기를 할당 방크기가 -> array1[0] / [1] / [2]세개가 나옴: 자료형 뒤에 []
		int[] array2;
		array2= new int[3]; // array2 배열변수를 선언하고나서 따로 방크기를 지정

		//배열 변수 선언 방법2
		
		int array3[] = new int[3];  // 배열 변수 선언과 동시에 방크기 지정: 변수명 뒤에 []
		
		int array4[];
		array4 = new int[3]; //new는 객체를 만드는키워드 나중에배움 RAM에는 여러 영역이 있는데, 배열변수는 stack에 배열변수명(array4)이 들어감 int[3]배열에 들어가는 값은 Heap영역에 들어감. stack에 는 주소값만 들어가고 실제값은 heap에 들어가있음. 즉 stack에는 heap의 주소값이들어있음 stack의 주소값을보고 주소를 찾아가서 heap에서 데이터를 가져옴?
		
		//다양한 배열 선언 (기본 자료형 배열, 참조 자료형 배열)
		boolean[] array5=new boolean[3];
		int[] array6=new int[5];
		double[] array7=new double[7]; //위에3개는 기본자료형
		String[] array8=new String[9]; // 참조자료형 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
