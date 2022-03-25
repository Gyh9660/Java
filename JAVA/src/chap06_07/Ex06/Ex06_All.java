package chap06_07.Ex06;


class Abc{ // 외부 클래스 : public 제어자를 사용할 수 없다. 				//default  제어자가 기본으로 적용
				//class : public,default
				//접근 제어자가 붙을수 있는 키워드 : class 앞, field, method , 생성자 
				//반드시 접근제어자가 할당 되어 있다. 생략되어 있으면 default 
				//접근 제어자 :
					//1.public: 다른 패키지에서 접근 가능
					//2.protected:다른 패키지에서 접근 가능(상속구현이 되어 있어야 다른패키지에서 접근 가능)
					//3.default: 같은 패키지에서 접근이 가능, 같은 패키지에 존재하는 클래스는 import없이 접근가능
					//4.private: 같은 클래스 내부에서만 접근가능
	
	public int a = 10;
	protected int b = 20;
	int c = 30;
	private int d = 40;
	
	// Abc() {} <== 기본 생성자 : 필드의 초기값을 부여해서 객체를 생성, 
	
	public void print1() {
		System.out.println("다른 패키지에서 접근 가능 : public ");
	}
	
	protected void print2() {
		System.out.println("다른 패키지에서 접근 가능(상속관계가 구성되어있는 경우) : protected");
	}
	
	void print3() {
		System.out.println("같은 패키지에서만 접근가능 : default");
	}
	
	private void print4 () {
		System.out.println("같은 클래스에서만 접근가능 : private ");
	}
	
	
	
}

public class Ex06_All {

	public static void main(String[] args) {
		
		Abc abc1 = new Abc(); //기본 생성자 호출
		//Abc는 :클래스명, abc1 : 메모리에 로드할 객체명, new = 객체틀 :Heap영역에 생성,  Abc(): 생성자 호출
			//Abc() : 기본 생성자: ㅅ생략 가능, Abc(){}
				//생성자 : 1. 클래스이르뫄 동일한 메소드, 리턴타입이 존재하지 않는 메소드 새아
		
		//같은 패키지 내에서 필드 호출
		abc1.a = 100; //public 호출
		abc1.b = 200; //protected
		abc1.c = 300;	//default
//		abc1.d = 400; //private 오류 //다른 클래스에서는 접근불가

		//같은 패키지 내에서 메소드 호출
		abc1.print1(); // public
		abc1.print2(); // protected
		abc1.print3(); //default
		//abc1.print4(); //private 오류발생
		
	}

}
