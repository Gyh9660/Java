package chap14.Ex02;

//실행 예외 (UnChecked Exception, RunTime Exception): 컴파일 단계에서는 예외 발생되지 않음
	//실행시에 발생될수있다.

class AA{}

class BB extends AA{}


public class UnCheckedException {

	public static void main(String[] args) {
		//실행 예외
		//ArithmeticException : 0으로 어떤수를 나누면 오류가 발생
		//System.out.println(10/0);
		
		//ClassCastException : 클래스의 타입을 변환할때 변환 되지 않는 예외
		AA aa = new AA();
		//BB bb = (BB) aa; //컴파일 단계에서는 오류가 발생되지 않는다.
		
		//ArrayIndexOutOfBoundsException : 배열에서 존재하지 않는 방번호를 출력할경우 발생
		int[] array = {1,2,3};
		//System.out.println(array[3]);
		
		//NumberFormatException : 문자형 숫자를 정수타입으로 변환할 수 없는 예외
		//int num = Integer.parseInt("10!"); //문자열 10을 정수로 변환
		//System.out.println(num);
		
		//NullPointerException
		//String str = null;
		//System.out.println(str.charAt(4));
		
		
	}

}
