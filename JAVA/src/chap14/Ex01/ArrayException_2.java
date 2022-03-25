package chap14.Ex01;

//Exception이 예외의 최상위 클래스 입니다.
//ArrayIndexOutOfBoundsExceptioneh Exception을 상속하고 있다.
public class ArrayException_2 {

	public static void main(String[] args) {

		
		int[]arr =new int[5]; //arr배열에 배열방 5개를 생성, index :0,1,2,3,4
		
		try {
			
			for (int i=0; i<=5; i++) {
				arr[i]=i;
				System.out.println(arr[i]);
			}
			
		}catch(Exception e) { //하위의 모든 예외를 처리 할 수 있다.
			e.printStackTrace(); //예외에 대한 정보를 출력 //오류가없으면 출력안됨
			System.out.println("배열의 인덱스 방번호를 넘겼습니다.");
		}finally {//오류가 있든없든 반드시 출력됨
			System.out.println("출력(finally)");
		}
		System.out.println("프로그램 종료");
		
		
	}

}
