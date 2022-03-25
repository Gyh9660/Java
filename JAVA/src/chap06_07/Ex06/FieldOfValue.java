package chap06_07.Ex06;

//객체의 필드에 값을 할당 하는 방식 : 3가지
	//1. 필드에 직접 대입
		//<== 객체를 생성후
	//2. setter를 통해서 객체에 필드에 값을 부여하는 방식(컨트롤이 된다) 
		//<==객체를 생성 후 객체에 값을부여
	//3. 생성자를 통해서 객체의 필드 값을 부여 (컨트롤 된다)
		//<== 객체를 생성할 때 초기값으로 필드에 값을 할당

class Aa{ //1.객체 생성후 직접 필드에 값 할당
	String name; //이름
	int age;	//나이
	String mail;	//메일주소
	
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}
	
	
}

class Bb{ //2.setter를 통해서 객체의 필드의 값을 할당 
	
	String name; //이름
	int age;	//나이
	String mail;	//메일주소
	
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}	
	
	
	
}

class Cc{ //3. 생성자를 통해서 객체의 필드의 값을 할당
	
	String name; //이름
	int age;	//나이
	String mail;	//메일주소
	
	Cc(){
		name = "이순신";
		age = 20;
		mail = "ccc@ccc.com";
	}
	
	Cc(String name, int age, String mail){ //생성자에서 매개변수 3개를 받아서
		this.name =name;
		this.age =age;
		this.mail=mail;
	}
	void print() {
		System.out.println("name : "+name+ "age : "+age+ "mail : "+mail);
	}
	
	
}

public class FieldOfValue {

	public static void main(String[] args) {

		//1. 객체의 필드에 직접 값을 할당.
		Aa aa = new Aa(); //객체를 생성후 값 할당
		aa.name = "홍길동";
		aa.age = 18;
		aa.mail = "aaa@aaa.com";
		aa.print();
		//2. 객체의 setter를 통해서 필드의 값을 부여.
		System.out.println();
		Bb bb = new Bb(); //객체를 생성후 값 할당
		bb.setName("신사임당");
		bb.setAge(19);
		bb.setMail("bbb@bbb.com");
		bb.print();
		//3. 생성자를 사용해서 필드의 값을 부여.(객체를 생성할떄 필드의 값을 초기화)
		System.out.println();
		Cc cc = new Cc();
		cc.print();
		Cc ccc = new Cc("세종대왕",20,"cc@cc.co.kr"); 	//객체를 생성할때 값 부여
		ccc.print();
	}

}
