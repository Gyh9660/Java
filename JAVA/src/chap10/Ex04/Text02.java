package chap10.Ex04;

class Animal3 {		//부모 클래스 ,모든 클래스는 Object클래스를 상속한다. 자바의 최상위 클래스 object
	String name;
	int age;
	
	void cry() {
		System.out.println("동물은 웁니다.");
		
	}

	@Override //Object 클래스의 toString 메소드는 객체자체를 출력할때 호출이 된다.
	public String toString() {		//객체의 주소를 출력합니다.[패키지명.클래스명@객체의메모리의해쉬코드]
		
		return "이름은 : "+name + " , " + "나이는 : "+ age + " 입니다.";
		
	}
}
class Tiger3 extends Animal3 {
	
	Tiger3(){ //기본 생성자: 변수의 초기화 값을 할당하지 않거 초기화.
				//다른 생성자가 객체내에 존재할 경우 기본생성자를 외부에서 호출시 생략되어 있으면 안된다.
	}
	
	Tiger3(String a, int b){ //Tiger3 생성자 : 클래스이름과 동일//객체를 생성할때 메모리의 초기값을 할당할때 사용
		super.name = a; //super : 부모 클래스 , this :자기자신의 객체
		super.age = b;
	}
	
	@Override
	void cry() {
		//super.cry(); 	//super키워드는 부모클래스를 뜻함
						//super : 상속관계일때 부모 클래스
						//this 키워드는 자기자신의 객체 
		System.out.println("호랑이는 어흥하고 웁니다.");
		
	}
	
}
class Cat3 extends Animal3{
	Cat3(){
		
	}
	Cat3(String a, int b){ //생성자
		super.name = a;
		super.age = b;
	}
	
	@Override
	void cry() {
		//super.cry();
		System.out.println("고양이는 야옹하고 웁니다.");
	}
	
}
class Dog3 extends Animal3{

	Dog3(){
		
	}
	Dog3 (String a, int b) { //생성자
		super.name = a;
		super.age = b;
		
	}
	
	@Override
	void cry() {
//		super.cry();
		System.out.println("강아지는 멍멍하고 웁니다.");
	}
	
	
}



public class Text02 {

	public static void main(String[] args) {

		Animal3 a3 = new Animal3(); //a3 객체생성
		
		System.out.println(a3); //객체 자체를 출력 할 경우, Object클래스의 toString 메소드가 호출
			//Object.toString(): 객체의 메모리주소의 해쉬코드를 출력
			//chap10.Ex04.Animal3@32d2fa64 <== 패키지명.객체명@해쉬코드
		System.out.println(a3.toString());

		//객체 자체를 출력하면 Object 클래스의toString 메소드를 호출
		System.out.println("============");
		
		Animal3 t3 = new Tiger3(); //Tiger3를 Animal3로 업캐스팅
		Animal3 c3 = new Cat3(); //Cat3를 Animal3로 업캐스팅
		
		Animal3 d3 = new Dog3();
		
		t3.cry(); //부모의 cry()를 호출 할 경우 오버라이딩된 Tiger3의 cry()를 호출
		c3.cry(); //Animal3.cry를 호출, ====> 오버라이딩된 Cat3의 cry()를 호출
		d3.cry();
		
		System.out.println("============");
		
		Animal3[] arr = {t3, c3, d3};
		for (int i = 0; i<arr.length; i++) {
			arr[i].cry();
		}
		
		System.out.println("==============");
		
		for (Animal3 k : arr) {
			k.cry();
		}
		
		System.out.println("=============");
		
		Animal3 aa3 = new Tiger3("호랑이",5);
		Animal3 cc3 = new Cat3("고양이",3);
		Animal3 dd3 = new Dog3("강아지",10);
		
		System.out.println(aa3);//객체 자체를 출력시, 기본적으로는 객체의 메모리 해쉬코드가 출력,
			
		System.out.println(cc3);//Object의 toString()메소드를  재정의한다.
		System.out.println(dd3);
		
		System.out.println("====1=======");
		
		Animal3[] arr2 = {aa3, cc3, dd3};
		
		for (int i=0; i<arr2.length;i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("===========");
		for ( Animal3 t : arr2) {
			System.out.println(t);
		}
		
		
		
		
		
		
		
	}

}
