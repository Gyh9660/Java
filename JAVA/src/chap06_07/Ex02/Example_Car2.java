package chap06_07.Ex02;

public class Example_Car2 {

	public static void main(String[] args) {
		
		
		Car sonata =new Car(); //객체화 , 
		Car grandeur =new Car();
		//변수에 값을 직접할당 ; 권장 사항은 아니다. 메모리의 원하지않는 값을 직접 할당할수 있다. (보안문제)
		//private을 변수명앞에 설정하면 : 캡슐화, 직접 변숭듸 값을 할당하지 못하도록 한다.
		//setter를 통해서 값을 부여 : 변수의 입력되는 값을 제어 할수 있다.
		sonata.company = "현대";
		sonata.model = "소나타";
		sonata.maxSpeed = 200; //-,700값 이상을 넣을수 없도록 제어
		sonata.color = "블랙그린";
		
		System.out.println("======================");
		
		System.out.println(sonata.company);
		System.out.println(sonata.model);
		
		System.out.println("======================");
		
		// setter를 통해서 값을 할당 : RAM에 값을 부여 할때 사용
		grandeur.setCompany("현대");
		grandeur.setColor("빨강");
		grandeur.setMaxSpeed(300);
		grandeur.setModel("그랜져");
		//getter는 메모리의 값을 출력 할때
		System.out.println(grandeur.getCompany());
		System.out.println(grandeur.getModel());
		System.out.println(grandeur.getColor());
		
		
		
	}

}
