package chap16.Ex08;


class A {}
class B extends A {}
class C extends B {}

//제너릭 타입의 클래스 : 제너릭 타입의 들어오는 객체를 제한을 둠
class D <T extends B> { //T에 올수 있는것 : classB, classC만 올 수 있다.
					//T extends B > 의미 : T타입에 접근을 제한
//extends가 없으면 모든타입이 다 접근할수있음
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
}




public class BoundedTypeOfGeneric {

	public static void main(String[] args) {

	//	D<A> d1 = new D<A>(); //불가능: <T>에 들어갈 객체를 제한을 둚, B class, C class만 들어 올수 있다(타입지정 가능).
		//extends B햇기떄문에 A는 만들지못함(접근불가)
		
		D<B> d2 = new D<B>(); //B, C를 타입으로 설정 가능
		D<C> d3 = new D<C>(); //C 타입만 저장 가능	
		
		D d4 = new D(); // = D(B) D (C) //타입을 지정하지 않고 객체 생성시 최상위 타입을 최상으로 설정됨
	// = D<B> d2 = new D<B>();
		
		d2.set(new B()); //B객체 저장
		d2.set(new C()); //C객체 저장
//		d2.set(new A()); //오류 발생
		
		
		//d3는 C 타입만 넣을수있다.
		
	//	d3.set(new B()); // 오류 발생
		d3.set(new C()); //
	//	d3.set(new A()); // 오류 발생
		
		//d4.set(new A()); //오류발생
		d4.set(new B());
		
		d4.set(new C());
		
	}

}
