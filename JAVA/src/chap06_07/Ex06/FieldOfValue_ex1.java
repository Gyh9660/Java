package chap06_07.Ex06;

//객체의 필드에 값을 할당 하는 방식 : 3가지
	//1. 필드에 직접 대입
		//<== 객체를 생성후
	//2. setter를 통해서 객체에 필드에 값을 부여하는 방식(컨트롤이 된다) 
		//<==객체를 생성 후 객체에 값을부여
	//3. 생성자를 통해서 객체의 필드 값을 부여 (컨트롤 된다)
		//<== 객체를 생성할 때 초기값으로 필드에 값을 할당

class Aaa{ //1.객체 생성후 직접 필드에 값 할당
	String name; //이름
	int age;	//나이
	String mail;	//메일주소
	
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}
	
	
}

class Bbb{ //2.setter를 통해서 객체의 필드의 값을 할당 
	
	String name; //이름
	int age;	//나이
	String mail;	//메일주소
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}
	
}

class Ccc{ //3. 생성자를 통해서 객체의 필드의 값을 할당
	
	String name; //이름
	int age;	//나이
	String mail;	//메일주소
	
	Ccc(String name, int age, String mail){ //생성자에서 매개변수 3개를 받아서
		this.name = name;
		this.age = age;
		this.mail = mail;
	}
	
	
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}
	
	
}


public class FieldOfValue_ex1 {

	public static void main(String[] args) {

		//1. 객체의 필드에 직접 값을 할당.
		Aaa aaa = new Aaa();		//객체를 생성후 값 할당
		aaa.name = "홍길동";
		aaa.age = 30;
		aaa.mail="aaa@aaa.com";
		aaa.print();
		//2. 객체의 setter를 통해서 필드의 값을 부여.
		System.out.println(); 		//객체를 생성후 값 할당	
		Bbb bbb = new Bbb();
		bbb.setName("김유신");
		bbb.setAge(50);
		bbb.setMail("bbb@bbb.com");
		bbb.print();
		//3. 생성자를 사용해서 필드의 값을 부여. (객체를 생성할떄 필드의 값을 초기화)
		Ccc ccc = new Ccc("세종대왕",40,"ccc@ccc.com");		//객체를 생성할때 값 부여
		ccc.print();
		
		
	}

}
