package chap19.Ex04;

public class Character_Ex01 {

	public static void main(String[] args) {

		
		char ch1 = 'A';				//char :2byte 
		System.out.println(ch1);
		System.out.println((int)ch1);
		
		char ch1_1 ='a';
		System.out.println(ch1_1);
		System.out.println((int)ch1_1);
		
		
		char ch2 = 'z';
		System.out.println(ch2);
		System.out.println((int)ch2);

	
		//2. char에 정수(아스키 코드)로 저장할 수 있다.
		
		char ch3 = 66;		//<== char에 정수값으로 저장이 가능하다.
		System.out.println(ch3);
		System.out.println((char)ch3);
		System.out.println((int)ch3);

		
		int ch4 = 65;        
		System.out.println(ch4);
		System.out.println((char)ch4);
		System.out.println((int)ch4);
		
		
	
	
	}

}
