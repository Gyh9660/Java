package chap06_07.Ex02;

import java.util.Arrays;

public class FlexibleSizeArrayArgument {

	public static void main(String[] args) {
		//배열의 길이가 고정되어 있지 않고 가변길이 인경우
		//1.method1 (int...values) <<==가변길이를 처리하는 input매개변수 설정
		method1 (); //메소드 오버라이딩 : 메소드 명은 모두 동일
		method1 (1,2); //매개변수의 타입이나 갯수에 따라 해당메소드가 출력
		method1 (1,2,3);
		method1 (1,2,3,4);
		method1 (1,2,3,4,5);
		method1 (1,2,3,4,5,6,7,8,9,10);
		
		
		//* method2
		method2 ("안녕", "방가");
		method2 ("월", "화","수","목","금","토","일");
		method2 ("토끼", "호랑이","여우","곰");
		
		
	}
		static void method1 (int...values) { //values변수에는 배열을 담은 변수
			System.out.println(values.length);
			
			System.out.println("====Arrays.toString()=======");
			//Arrays.toString()
			System.out.println(Arrays.toString(values));
			
			//for
			System.out.println("======for=======");
			for(int i=0; i<values.length;i++)
				System.out.print(values[i]+ " ");
				System.out.println();
				
			//enhanced for
			System.out.println("======향상된 for=======");
			for (int k : values) {
				System.out.print(k+ " ");
			}
		System.out.println();
			
			
		}
	
		static void method2 (String...value) { 
			System.out.println(value.length);
			
			System.out.println("====Arrays.toString()=======");
			//Arrays.toString()
			System.out.println(Arrays.toString(value));
			System.out.println();
			
			//for
			System.out.println("======for=======");
			for(int i=0; i<value.length;i++) {
				System.out.print(value[i]+ " ");	
			}
			System.out.println();
			//enhanced for
			System.out.println("======향상된 for=======");
			for (String p : value) {
				System.out.print(p+ " ");	
			}
			System.out.println();
		}
			
	
	
	
	
	
	
	
	
	
	/*
		static void method1 () {
			System.out.println("매개변수가 없는 메소드 호출");
		}
		static void method1 (int a,int b) {
			System.out.println(a+ "," +b);
		}
		static void method1 (int a,int b,int c) {
			System.out.println(a + "," + b + "," + c);
		}
		static void method1 (int a,int b,int c,int d) {
			System.out.println(a + "," + b + "," + c + "," + d);
		}
		static void method1 (int a,int b,int c, int d, int e) {
			System.out.println(a + "," + b + "," + c + "," + d + "," + e);
		}
	*/
	

}
