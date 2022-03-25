package chap06_07.Ex03;


//생성자 오버로딩 : 하나의 생성자 명에 데이터타입, 개수에 따라 다른 생성자가 호출
	//주의) 데이터타입과 개수 두개모두가 같은경우가 2개이상 있으면 오류가발생
class Abc{
	int a,b,c;
	String d;
	
	Abc(){System.out.println(a+","+b+","+c);} //기본 생성자
	Abc(int a){ //매개변수 1개인 생성자
		this.a =a;
		System.out.println(a);
	}
	Abc(String d){ 
		this.d = d; 
		System.out.println(d);
	}
	
	Abc(int a, int b){ //매개변수 2개인 생성자
		this.a=a;
		this.b=b;
		System.out.print(a+ "," + b);
		System.out.println();
	}
	Abc(int a, int b, int c){ //매개변수 3개인 생성자
		this.a=a;
		this.b=b;
		this.c=c;
		System.out.print(a+","+b+","+c);
		System.out.println();
	}

	
}


public class ConstructorOverloading {

	public static void main(String[] args) {

		Abc a = new Abc(); //기본 생성자 호출
		
		Abc ab = new Abc(6); //매개 변수 하나인 생성자 호출(int 타입)
		
		Abc ab2 = new Abc("현대"); //매개 변수가 하나인 생성자 호출(String타입) 매개변수의 값이 같더라도 타입이다르면 해당 메소드를 호출
		
		Abc abc = new Abc(6,7); //매개 변수 두개인 생성자 호출
		
		Abc abcd = new Abc (6,7,8); //매개 변수 세개인 생성자 호출
		
	}

}
