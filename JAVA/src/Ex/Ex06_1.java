package Ex;

public class Ex06_1 {

	public static void main(String[] args) {

		int max =0; // 최대 값을 저장하는 변수
		int[] array = {4,5,1,2,3};
		
		for (int i=0 ; i<array.length; i++) { //각방의 값을 순환하면서 가지고 온다.
			if ( array[i]> max) { // 방의 값이 max 변수의 값보다 클때
				max = array[i];  // max 변수에 방의값을 저장한다.
			}
		}
		System.out.println(max);
	}

}
