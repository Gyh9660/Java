package chap06_07.Ex06;

class Cde{
	String name; //필드 (인스턴스 필드): 객체화 해야 사용가능
	int age;
	
	static String email; //필드 (static(정적)필드 : 객체 생성없이 사용가능 (클래스명.필드명) +객체 생성후 사용가능
	static int num;
}
public class Static_4 {

	public static void main(String[] args) {
		
		
		Cde cde1 = new Cde(); //객체화
		//인스턴스 필드 : 객체화 해야지만 사용가능
		cde1.name = "홍길동";
		cde1.age = 30;
		
		//static 필드 : 객체화 해서 사용가능
		cde1.email = "aaa@aaa.com";
		cde1.num = 4;
		
		//객체 생성 없이 static 필드 호출 :클래스 명으로 호출이 가능 <<권장 사항>>
			//모든 객체들이 공유하는 공간
		Cde.email =  "cde@cde.com";
		Cde.num = 54;
		
		Cde cde2 = new Cde();
		Cde cde3 = new Cde();
		Cde cde4 = new Cde();
		
		//인스턴스 필드 : Heap 영역에 저장 되고, 각 객체에서 공유되지 않는 고유한 값을 가진다.
		
		cde2.name = "김유신";
		cde2.age = 50;
				
		cde3.name = "세종대왕";
		cde3.age = 60;
		
		cde4.name = "신사임당";
		cde4.age = 40;
		
		//인스턴스 필드 값 출력
		
		System.out.println(cde2.name + ","+cde2.age);
		System.out.println(cde3.name + ","+cde3.age);
		System.out.println(cde4.name + ","+cde4.age);
		
		//static 필드의 값을 변경하면 모든 객체에서 모두 변경
		cde2.email = "kkk@kkk.com";
		cde2.num = 55;
		
		System.out.println(cde2.email+ " , "+cde2.num);
		System.out.println(cde3.email+ " , "+cde3.num);
		System.out.println(cde4.email+ " , "+cde4.num);
		
	}

}
