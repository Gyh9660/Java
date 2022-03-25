package chap05;

public class Ex04_PrimaryAndReferenceType {

	public static void main(String[] args) {
		//1. 기본 데이터 타입의 대입 연산 ( Stack 값을 복사 )
		int value1 = 3;
		int value2 = value1; // 값을 복사
		
		value2 = 7;
		System.out.println(value1); // 3
		System.out.println(value2); // 7
		System.out.println("===============");
		
		
		//2. 참조 자료형의 대입 연산 ( Stack의 힙영역의 주소를 복사 , )
		int[] array1 = new int[] {3,4,5,7};
		int[] array2 = array1;
		array2[0]= 7;
		
		System.out.println(array1[0]); // 7 array1과 2는 주소를 가르키기떄문에 주소값에 있는 내용은 똑같다 그래서 array2주소값에 있는 힙영역의 내용을 변경하면 같은 주소값을 가지고있는 array1의 힙영역과 같으므로 둘다 7로나옴 ( array2는 스택영역에서 array1의 힙영역의 주소를 복사)
		System.out.println(array2[0]); // 7
		System.out.println(array1); //객체의 힙영역의 주소값 출력
		System.out.println(array2);//객체의 힙영역의 주소값 출력
		
		
	}

}
