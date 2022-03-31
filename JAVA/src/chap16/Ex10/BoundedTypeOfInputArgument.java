package chap16.Ex10;

//제네릭 메소드에서 매개변수에서 값의 제한

class A {}
class B extends A{}
class C extends B{}
class D extends C{}

class Goods<T>{ //제너릭 클래스
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

class Test {	//일반 메소드들, 매개변수로 들어오는 타입이 제너릭 타입.
	void method1(Goods<A> g) {} //g의 매개변수로 A클래스 타입만 전송
	void method2(Goods<?> g) {} //g의 매개변수로 A,B,C,D클래스 타입만 전송
	void method3(Goods<? extends B> g) {} //g의 매개변수로 B,C,D클래스 타입만 전송
	void method4(Goods<? super B> g) {} //g의 매개변수로 A,B 클래스 타입만 전송
	
	
}




public class BoundedTypeOfInputArgument {

	public static void main(String[] args) {
		
		Test t = new Test();
		
		//1. Method1 :
		t.method1(new Goods<A>()); //정상 작동
		//t.method1(new Goods<B>()); //오류
		//t.method1(new Goods<C>()); //오류
		//t.method1(new Goods<D>()); //오류
		
		//2. Method2
		t.method2(new Goods<A>());	//정상 작동
		t.method2(new Goods<B>());	//정상 작동
		t.method2(new Goods<C>());	//정상 작동
		t.method2(new Goods<D>());	//정상 작동
		
		//3. Method3 (Goods<? extends B> g ) : B,C,D
		//t.method3(new Goods<A>()); //오류
		t.method3(new Goods<B>());	//정상 작동
		t.method3(new Goods<C>());	//정상 작동
		t.method3(new Goods<D>());	//정상 작동
	
		//4. MEthod4 (Goods<? super B> g) {} : B, A
		t.method4(new Goods<A>());	//정상 작동
		t.method4(new Goods<B>());	//정상 작동
		//t.method4(new Goods<C>());	//오류
		//t.method4(new Goods<D>());	//오류
	
	
	
	
	
	
	
	
	}

}
