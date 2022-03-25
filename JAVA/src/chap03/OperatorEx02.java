package chap03;

public class OperatorEx02 {

	public static void main(String[] args) {
		//#크기 비교 ( <, >, <=, >-) ====> 비교한 값을 true, false로 리턴
		System.out.println(5 < 2); //false
		System.out.println(-5 < 5); //true
		System.out.println(5 <= 5); //true
		System.out.println("===============");
		
		//등가 비교 ( ==(같다) , != (같지 않다) ===> 비교한 값을 true, false로 리턴 ==는 같으면 true !=는 같지않으면 true
		
		int a=5;
		int b=2;
		int c=5;
		
		System.out.println(a==b); //false
		System.out.println(a!=b); //true
		System.out.println(a==c); //true
		System.out.println(a!=c); //false
		
		System.out.println("================");
		//참조 자료형 등가 비교 ( 객체의 메모리의 번지를 비교,)
		String str1 = new String ("안녕");
		String str2 = new String ("안녕"); //new를통해 별도의메모리를 설정했기떄문에 2개는 메모리가 다름
		
		System.out.println(str1 == str2 );
		
		System.out.println(str1 == str2); //메모리의 번지가 다르기떄문에 false가 나옴 / 객체의 메모리의 번지를 비교

		
		
		
		
		
	}

}
