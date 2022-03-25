package chap03;

import java.awt.SystemColor;

public class OperatorEx03 {

	public static void main(String[] args) {

		/*
		 * 논리 연산자( &&, ㅣㅣ,^,!)쇼트 서킷이 발생됨 (앞부분의 연산 결과를 인지할수 있을때 뒷부분은 연산을 생략)
		 * 비트 연산자( & ,ㅣ,^,)쇼트 서킷이 발생되지 않는다.
		 * 쇼트서킷은 앞부분을보고 결과가나오면 뒤에는 보지않고 연산을 생략
		 */
		
		//1. 논리 연산자 AND (&&) : 두 항이 모두 true일때 결과가 true
		
		System.out.println(true && true); // true, 쇼트서킷이 발생되지 않음.
		System.out.println(true && false);// false, 쇼트 서킷이 발생되지 않음.
		System.out.println(false && true); //false, 쇼트 서킷이 발생됨. 앞에가 false가 와버리면 and연산을 한다면 뒤는 뭐가나오든 false가 나오기때문에 뒷부분의 연산을 생략함
		System.out.println(true && (5<3) ); //(5<3)는 false이기에 false가 발생
		System.out.println( (5<=5) && (7>2) );//true
		System.out.println( (3<2) && (8<10) );//false 쇼트서킷이 발생됨
		
		//OR (||) 두항중 하나만 true이면 결과가 true
		System.out.println( true || true); //true, 쇼트 서킷이 발생
		System.out.println(false || (5<3) );
		System.out.println("================");
		
		//XOR (^) : 두값이 같을떄 false, 다를떄 true
		System.out.println( true ^ true);// false
		System.out.println( false ^ false);// false
		System.out.println( true ^ false);// true
		System.out.println( false ^ true);// true
		System.out.println( ( 5<=5 ) ^ ( 7>2 ) ); //false
		System.out.println("===================");

		//NOT (!) : true 이면 false, false 이면 true
		System.out.println(!true); //false
		System.out.println(!false); //true
		System.out.println(false || !( 5 < 3 ) ); //true
		System.out.println("=================");
		// 숏 서킷을 사용하는 여부 ( 논리 연산자일때 발생, 비트 연산자일때는 발생되지 않음.)
		
		int value2 = 3;
		System.out.println(false &&  ++value2 > 6); //숏 서킷이 발생, false 
 		System.out.println(value2); // 원래라면 4가나와야하지만 3이나옴, 그이유는 &&연산일때 앞이 false가 나오면 false밖에 나오지 않기때문에 숏 서킷이 발생하여 뒤의 연산이 발생되지않고 생략됨 그래서 변수 value2를 다시찍었을때 4가아닌 3이나옴
 		
 		int value3 = 3;
 		System.out.println(false & ++value3 > 6); // 결과는 false지만 숏 서킷이 발생되지 않음(비트 연산자 이기 떄문에), 그렇기 떄문에 뒤의 연산이 생략되지않아서 value3를 찍으면 4가 나올것임.
 		System.out.println(value3); //4가나옴, 위의 연산 이 숏서킷이 발생하지 않아서 생략되지 않았기때문에 
		
 		int value4 = 3;
 		System.out.println(true || ++value4 > 6); //앞이 true 기떄문에 무조건 true or연산은 둘중하나가 true면 무조건 true
 		System.out.println(value4);
 		
 		int value5 = 3;
 		System.out.println(true | ++value5 > 6); //true
 		System.out.println(value5);
		
		
		
		
	}

}
