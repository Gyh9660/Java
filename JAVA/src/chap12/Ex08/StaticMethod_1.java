package chap12.Ex08;

// 인터페이스 내부에 static 키가 들어간 메소드 : 하위 자식에서 구현없이 바로 호출

/* interface 내부 구성 요소
 * 1. 필드 : [public static final] 	[] <== 생략가능
 * 2. method : 1. [public abstract]  <== 추상 메소드(구현부가 없는메소드)
 * 				2. [public] default  <== 구현부가 있는 메소드 (Java 1.8 이상에서 새롭게 생긴 기능)
 * 				3. [public] static	<== 구현부가 있고, 객체생성없이 호출 (Java 1.8 이상에서 새롭게 생긴 기능)
 * 
 */


interface A {
	static void abc() {		//Java 1.8이상에서 새롭게 추가된 기능
		System.out.println("A 인터페이스의 정적 메소드 abc()");
	}
}



public class StaticMethod_1 {

	public static void main(String[] args) {
		//1. 정적 메소드 호출 (static method) 
		A.abc(); 		// interface 이름으로 바로 호출 가능
		
		
	}

}
