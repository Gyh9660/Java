package chap06_07.Ex04;

/* 1. this가 키워드로 사용되는 경우 : this.m (필드의 m), this.init() (자기 자신 객체의 메소드 init()을 뜻함)
 *
 * 2. this가 메소드로 사용되는 경우 :
 * 	  this(); <== 생성자 내에서 다른 생성자를 호출할 때 사용
 * 				<== 반드시 생성자 내부의 첫 줄에 와야함
 * 				<== 메소드 내부에서는 사용할 수 없다. 
 *				 <== (생성자 내부에서만 사용가능)
 */

class Abc {
	Abc(){ //기본생성자 // 생성자의 매개변수값이 없는 생성자
		System.out.println("첫번째 생성자 입니다. ");
	}
	Abc(int a){
		this(); //매개변수가 없는 기본생성자를 호출, this();는 반드시 생성자의 첫라인에 와야함
		System.out.println("두번째 생성자 입니다. ");
	}
	
	Abc(int a, String b){
		this(30); //this(30); : 매개변수가 정수 1개가 들어가는 새엉자를 호출
		System.out.println("세번째 생성자 입니다. ");
	}
	
/* 오류 발생, 메소드 내부에서는 사용 불가능, 생성자 내부에서만 사용 가능( 반드시 첫 라인에 위치 해야 한다.)	
	void abc () {
		this(); // 메소드 내에서는 this();는 올수없다. 사용불가
				  // this(); <== 다른 생성자를 호출 할 대 사용.
	}
*/		
}



public class ThisMethod_1 {

	public static void main(String[] args) {
		// 1. 객체 생성 
		Abc abc = new Abc();//매개 변수가 없는 생성자 호출
		System.out.println("=====================");
		
		Abc abc1 = new Abc(3); //매개변수가 정수 1인 생성자를 호출.
		System.out.println("=====================");
		
		Abc abc2 = new Abc(3,"3");
		
		
		
		
		
		
		
	}

}
