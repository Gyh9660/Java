package Kosmo_gyh;
public class Print {
	public static void main(String[] args) {
		System.out.println("화면출력");//자바의 한라인 주석//
		/*여러라인 주석
		 * 주석: 프로그램에서 해석되지 않는 코드 
		 * 프로그램에 대한 설명
		 * 한라인의 주석 print"ln"은 ln이 들어가서 
		 * 출력하고 다음줄로 엔터 문자는 ""반드시사이(//)
		 * sys만쓰고 컨트롤스페이스바하면 여러개뜸*/
		System.out.println("화면"+"출력");//"+"는 문자열일때 연결 연산자로사용//
		System.out.println(3.8);//정수, 실수를 출력할떄는 ""를 넣지 않는다.
		System.out.println(3+5);//+는 정수나, 실수 일때 +(더하기)연산자
		System.out.println("3"+"5");
		System.out.println("화면 : "+ 3);
		System.out.println("화면 "+ 3 + 5);
		System.out.println(3 + 5 + "화면");
		System.out.println("화면" + "3");
	}

}
