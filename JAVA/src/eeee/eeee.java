package eeee;

interface A {
    double method1 (int a, int b) ;
}
public class eeee {

	public static void main(String[] args) {

		 A a1 = (int a, int b) -> { return a+b; };
		  A a2= (int a, int b) ->  a+b;
		  A a3 = (a, b) -> { return a+b; };
		 // A a4 = (a, b) -> { a+b; };
		
	}

}
