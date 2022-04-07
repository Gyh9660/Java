package chap17.Ex06;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Set : 중복된 값을 넣을 수 없다.
	// equals () 메소드, hashCode() 메소드가 정의 되어 있어야 한다.
	// String, Integer 클래스들은 equals() 메소드와 hashCode()가 재정의 되어 있다.
	//특정 객체를 set에 저장할 경우 중복저장을 하지 못하도록 하기 위해서 equals()와 hashCode() 메소드를 재정의 해야한다.
	// Object 클래스의 equals()와 hassCode()
		// Object 클래스의 equals()메소드는 ==과 같다.
			//== Stack 메모리의 값을 비교.

//1.equals(), hashCode()메소드가 재정의 되지 않은 상태

class A{
	int data;
	public A(int data) {
		this.data =data;
	}
}

//equals()는 재정의 하고 hashCode()는 재정의 되지 않은 상태
class B{	
	int data;		// 두개의 객체가 data필드의 값이 같을때 동일하다라고 식별자를 넣어줘야함
					//equals(), hashCode()
	public B(int data) {
		this.data =data;
		
	
	}
	@Override
	public boolean equals(Object obj) { //객체의 주소를 비교하는 것이 아니라 객체 내부의 특정필드의 값을 비교하도록 설정
		if (obj instanceof B) {
			if(this.data == ((B)obj).data) //주의 : 잘못 다운캐스팅을 할 경우 : 예외가 발생됨
			return true;
		}
		return false;
		
		/*if(this.data == ((B)obj).data) {
			return true;
		}else {
			return false;
		}
		*/
		
	}
}
//equals()는 재정의 하고 hashCode()도 재정의
class C{	
	int data;		// 두개의 객체가 data필드의 값이 같을때 동일하다라고 식별자를 넣어줘야함
					//equals(), hashCode()
	public C(int data) {
		this.data =data;
		
	
	}
	@Override
	public boolean equals(Object obj) { //객체의 주소를 비교하는 것이 아니라 객체 내부의 특정필드의 값을 비교하도록 설정
		if (obj instanceof C) {
			if(this.data == ((C)obj).data) //주의 : 잘못 다운캐스팅을 할 경우 : 예외가 발생됨
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {	//Objects.hash(필드명,필드명,필드명) <--여러개의 필드의 해쉬코드를 같게 설정
		return Objects.hash(data);
		//==>여러개의 필드를 할수있다.
		//return data; //data필드의 값이 같으면 hashCode를 동일하게 생성.
		//이렇게 던져줘도 가능하지만 하나의필드만 할수있디.
	
	}
	
}

public class HashSetMachanism {

	public static void main(String[] args) {

		//1. equals(), hashCode()메소드가 재정의 되지 않은 상탸
		Set<A> hashSet1 = new HashSet();
		A a1 = new A(3);
		A a2 = new A(3);
		
		System.out.println(a1 == a2); //false
		// == : 스택 메모리의 값을 비교.
		System.out.println(a1); //객체명을 출력 : 패키지명.클래스명@힙메모리주소의해쉬코드(16진수로)
		System.out.println(a2);	
		
		System.out.println(a1.equals(a2)); //false, Object equals()는 == 와같다
		System.out.println(a1.hashCode()+ "," + a2.hashCode()); //10진수로 출력
	
		hashSet1.add(a1); 	//Set은 중복된 값을 넣지 못한다.
		hashSet1.add(a2);
		System.out.println(hashSet1.size()); //2가 출력 < = equals()와 hashCode()메소드가 재정의 되어있지않다.
	
		//2. equals()재정의 (객체의 data필드의 값을비교) hashCode()메소드가 재정의 되지 않은 상태
		Set<B> hashSet2 = new HashSet();
		
		B b1 = new B(3);
		B b2 = new B(3);
		
		System.out.println(b1 == b2); //Stack 메모리의 값을 비교 //false
		System.out.println(b1.equals(b2)); //true
		
		hashSet2.add(b1);
		hashSet2.add(b2);
		
		System.out.println(hashSet2.size()); //equals()만 재정의,hashCode()재정의 안됨
		System.out.println(b1.hashCode() + "," +b2.hashCode());
		
		//2. equals()재정의 (객체의 data필드의 값을비교) hashCode()도 재정의
			
		Set<C> hashSet3 = new HashSet();
		C c1 = new C(3);
		C c2 = new C(3);
		System.out.println(c1 == c2); //false, Stack의 주소값 비교
		System.out.println(c1.equals(c2)); //true , 객체의 data필드이 값을 비교하도록 재정의
		System.out.println(c1.hashCode()+ ","+c2.hashCode()); //data필드를 기준으로 hashCode를 생성. 
		//두 객체는 동일한 객체이다.
		
		hashSet3.add(c1);
		hashSet3.add(c2);
		System.out.println(hashSet3.size()); //1 <== equals(), hashCode() 재정의 되어 있다. data필드에 대해서.
	
	
	
	
	
	
	
	}

}
