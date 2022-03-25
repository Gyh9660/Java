package aa.dd;
public class Variable {
	public static void main(String[] args) {
		int a=3; //변수a 숫자는 int에 삽입 <==정수 =는 같다가 아니라 오른쪽의 값을 왼쪽에 대입하라 자바는 변수값을 넣을때 뭐인지 변수선언해줘야함//
		String b = "화면"; //변수 b 문자는 String에 삽입<==문자열//
		
		System.out.println(a);
		System.out.println(b);
		System.out.println("============");
		System.out.println(b +"출력");
		System.out.println(a + b + "출력");
		
		System.out.println("===========");
		System.out.println();
		
		a=10;
		b="오늘";
		System.out.println(a);
		System.out.println(b);
		System.out.println("============");
		System.out.println(b +"출력");
		System.out.println(a + b + "출력");
		
		a= 30;
		b= "10";
		/* a="내일";
		* b= 10; 이건 넣으면 오류발생 a는 정수값만 b는 문자열만 가능*/
	}

}
