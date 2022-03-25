package chap06_07.Ex04;

//Aaa 클래스는 여러개의 생성자를 사용할 경우 this(); 없이 사용한 경우: 중복된 값을 매번 입력
class Aaa{
	int m1, m2, m3, m4; //필드 4개 선언
	Aaa(){ //매개변수가 없는 생성자
		m1 = 1; //this가 다 생략되어 있음
		m2 = 2;
		m3 = 3;
		m4 = 4;
	}
	Aaa(int a){
		m1 = a;
		m2 = 2;
		m3 = 3;
		m4 = 4;
	}
	Aaa(int a, int b){
		m1 = a;
		m2 = b;
		m3 = 3;
		m4 = 4;
	}
	Aaa(int a, int b, int c){
		m1 = a;
		m2 = b;
		m3 = c;
		m4 = 4;
	}
	Aaa(int a, int b, int c, int d){
		m1 = a;
		m2 = b;
		m3 = c;
		m4 = d;
	}
	void print () { // 각 메모리의 값을 출력....
		System.out.print(m1 + " ");
		System.out.print(m2 + " ");
		System.out.print(m3 + " ");
		System.out.print(m4 + " ");
		System.out.println();
	}
}

//Bbb 클래스는 여러개의 생성자를 사용할 경우 this();를 사용한경우

class Bbb{
	int m1, m2, m3, m4; //필드 4개 선언
	Bbb(){
		m1 = 1; //초기값 할당
		m2 = 2;
		m3 = 3;
		m4 = 4;
	}
	Bbb(int a){
		this(); // 인풋 갑싱 없는 생성자 호출
		m1 = a;
	}
	Bbb(int a, int b){
		this(a);
		m2 = b;
	}
	Bbb(int a, int b, int c){
		this(a,b);
		m3 = c;
	}
	Bbb(int a, int b, int c, int d){
		this(a,b,c);
		m4 = d;
	}
	void print2() { //각 메모리의 값을 출력....
		System.out.print(m1 + " ");
		System.out.print(m2 + " ");
		System.out.print(m3 + " ");
		System.out.print(m4 + " ");
		System.out.println();
	}
}

public class ThisMethod_2 {

	public static void main(String[] args) {
		//this 미사용 5가지 객체생성
		Aaa aaa = new Aaa(); // 매개 변수가 없는 생성자 호출
		aaa.print();
		System.out.println("============");
		Aaa aaa1 = new Aaa(9);// 매개 변수가 하나인 생성자 호출
		aaa1.print();
		System.out.println("============");
		Aaa aaa2 = new Aaa(9,8);//매개 변수가 두개인 생성자 호출
		aaa2.print();
		System.out.println("============");
		Aaa aaa3 = new Aaa(9,8,7);//매개 변수가 세개인 생성자 호출
		aaa3.print();
		System.out.println("============");
		Aaa aaa4 = new Aaa(9,8,7,6);//매개 변수가 네개인 생성자 호출
		aaa4.print();
		
		//2. this 사용 5가지 객체생성
		System.out.println("=====Bbb시작=======");
		
		Bbb bbb = new Bbb();
		bbb.print2();//매개 변수가 없는 생성자 호출(기본생성자)
		System.out.println("============");
		Bbb bbb1 = new Bbb(11);//매개 변수가 하나인 생성자 호출
		bbb1.print2();
		System.out.println("============");
		Bbb bbb2 = new Bbb(11,12);//매개 변수가 두개인 생성자 호출
		bbb2.print2();
		System.out.println("============");
		Bbb bbb3 = new Bbb(11,12,13);//매개 변수가 세개인 생성자 호출
		bbb3.print2();
		System.out.println("============");
		Bbb bbb4 = new Bbb(11,12,13,14);//매개 변수가 네개인 생성자 호출
		bbb4.print2();
		
	}

}
