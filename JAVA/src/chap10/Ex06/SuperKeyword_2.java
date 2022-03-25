package chap10.Ex06;
 //super 키워드 : 부모(super)클래스
class AA {
	int m;
	
	void abc() {
		System.out.println("AA 클래스의 abc()");
		System.out.println(m);
	}
}

class BB extends AA {
	void abc() {
		System.out.println("BB 클래스의  abc()");
	}
	void bcd () {
		super.m =300;		
		super.abc();	//부모의 abc 호출
	}
}



public class SuperKeyword_2 {

	public static void main(String[] args) {

		BB bb = new BB();
		bb.bcd();
		
		
	}

}
