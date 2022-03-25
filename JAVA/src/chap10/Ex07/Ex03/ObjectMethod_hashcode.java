package chap10.Ex07.Ex03;

import java.util.HashMap;
// HashMap : "Key = 값" 으로 저장되는 자료구조.
	// Key는 중복 될수 없다.
	// HashMap에 Key의 객체를 저장하는 경우, Key에 저장되는 객체가 중복되지 않는 고유한 정보를 저장해야한다.
	// Object 클래스의 hashcode()를 사용해서 객체가 Key에 저장될경우 중복되지 않도록 설정할 수 있다.
class A {
	String name;
	A (String name){
		this.name=name;
	}
	@Override
	public boolean equals(Object obj) {
		if (this.name == ((A)obj).name) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return name;
	
	}
	
}
class B {		//hashCode() 오버라이드 + equals() 재정의 << 두개다 만족=>동일객체
	String name;
	B (String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if (this.name == ((B)obj).name) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}


public class ObjectMethod_hashcode {

	public static void main(String[] args) {

		HashMap<Integer,String> hm1 = new HashMap<>(); //<Integer <= key, String <= value>
		hm1.put(1, "데이터1");
		hm1.put(1, "데이터2");	//1 : 데이터1 => 1 : 데이터2 로 수정
		hm1.put(2, "데이터3");
		System.out.println(hm1);
		
		System.out.println("======================================");
		
		HashMap<A,String> hm2 = new HashMap<>(); //equals()만 재정의 되어있다.
		hm2.put(new A("첫번째"), "데이터1");		//hashCode()는 재정의 안되어 있다.
		hm2.put(new A("첫번째"), "데이터2");
		hm2.put(new A("두번째"), "데이터3");
		System.out.println(hm2); 		//HashMap이 잘못 구현된 경우 
										//객체를 키로삼을경우 중복될수있음(키는 중복 X)
		
		System.out.println("======================================");
		
		HashMap<B, String> hm3 = new HashMap<>();//hashCode() + equals() 재정의
		hm3.put(new B("첫번째"), "데이터1");
		hm3.put(new B("첫번째"), "데이터2");
		hm3.put(new B("두번째"), "데이터3");
		System.out.println(hm3); //HashMap에 구현이 제대로된 경우 :key가 중복되면 안된다.
				//hm3(HashMap)는 toString() 메소드가 재정의 되어있음
		
		System.out.println("첫번째".hashCode());
		System.out.println("첫번째".hashCode());
		System.out.println("두번째".hashCode());
		
	}

}
