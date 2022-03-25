package chap06_07.Ex02;

public class Example_Car {

	public static void main(String[] args) {
		// Car Class를 객체화 해서 5개의 객체를 생성해서 값을 할당해서 출력
		//settor를 통해서 값을 할당
		Car sonata = new Car();
		sonata.setCompany("현대");
		sonata.setColor("회색");
		sonata.setModel("소나타");
		sonata.setMaxSpeed(150);
		
		System.out.println(sonata.getCompany());
		System.out.println(sonata.getColor());
		System.out.println(sonata.getModel());
		System.out.println(sonata.getMaxSpeed());
		System.out.println("==============");
		
		Car sm5 = new Car();
		
		sm5.setCompany("삼성");
		sm5.setColor("회색");
		sm5.setModel("sm5");
		sm5.setMaxSpeed(155);
		
		System.out.println(sm5.getCompany());
		System.out.println(sm5.getColor());
		System.out.println(sm5.getModel());
		System.out.println(sm5.getMaxSpeed());
		System.out.println("==============");
		
		Car  ioniq5 = new Car();
		
		ioniq5.setCompany("현대");
		ioniq5.setColor("흰색");
		ioniq5.setModel("아이오닉5");
		ioniq5.setMaxSpeed(140);
		
		System.out.println(ioniq5.getCompany());
		System.out.println(ioniq5.getColor());
		System.out.println(ioniq5.getModel());
		System.out.println(ioniq5.getMaxSpeed());
		System.out.println("==============");
		
		Car sm7 = new Car();
		
		sm7.setCompany("삼성");
		sm7.setColor("검정색");
		sm7.setModel("sm7");
		sm7.setMaxSpeed(160);
		
		System.out.println(sm7.getCompany());
		System.out.println(sm7.getColor());
		System.out.println(sm7.getModel());
		System.out.println(sm7.getMaxSpeed());
		System.out.println("==============");
		
		Car sm3 = new Car();
		
		sm3.setCompany("삼성");
		sm3.setColor("회색");
		sm3.setModel("sm3");
		sm3.setMaxSpeed(155);
		
		System.out.println(sm3.getCompany());
		System.out.println(sm3.getColor());
		System.out.println(sm3.getModel());
		System.out.println(sm3.getMaxSpeed());
		System.out.println("==============");
		
		//직접 사용
		Car g70 = new Car();
		System.out.println(g70.company);
		System.out.println(g70.color);
		System.out.println(g70.model);
		System.out.println(g70.maxSpeed);
		
		g70.company = "현대";
		g70.color = "검정색";
		g70.model = "제네시스 g70";
		g70.maxSpeed = 180;	
		System.out.println("===========");
		
		System.out.println(g70.company);
		System.out.println(g70.color);
		System.out.println(g70.model);
		System.out.println(g70.maxSpeed);
		System.out.println("===========");
		
		Car g80 = new Car();
		System.out.println(g80.company);
		System.out.println(g80.color);
		System.out.println(g80.model);
		System.out.println(g80.maxSpeed);
		
		g80.company = "현대";
		g80.color = "흰색";
		g80.model = "제네시스 g80";
		g80.maxSpeed = 180;	
		System.out.println("===========");
		
		System.out.println(g80.company);
		System.out.println(g80.color);
		System.out.println(g80.model);
		System.out.println(g80.maxSpeed);
		System.out.println("===========");
		
		Car gv60 = new Car();
		System.out.println(gv60.company);
		System.out.println(gv60.color);
		System.out.println(gv60.model);
		System.out.println(gv60.maxSpeed);
		
		gv60.company = "현대";
		gv60.color = "회색";
		gv60.model = "제네시스 gv60";
		gv60.maxSpeed = 180;	
		System.out.println("===========");
		
		System.out.println(gv60.company);
		System.out.println(gv60.color);
		System.out.println(gv60.model);
		System.out.println(gv60.maxSpeed);
		System.out.println("===========");
		
		Car gv70 = new Car();
		System.out.println(gv70.company);
		System.out.println(gv70.color);
		System.out.println(gv70.model);
		System.out.println(gv70.maxSpeed);
		
		gv70.company = "현대";
		gv70.color = "검정색";
		gv70.model = "제네시스 gv70";
		gv70.maxSpeed = 190;	
		System.out.println("===========");
		
		System.out.println(gv70.company);
		System.out.println(gv70.color);
		System.out.println(gv70.model);
		System.out.println(gv70.maxSpeed);
		System.out.println("===========");
		
		Car g90 = new Car();
		System.out.println(g90.company);
		System.out.println(g90.color);
		System.out.println(g90.model);
		System.out.println(g90.maxSpeed);
		
		g90.company = "현대";
		g90.color = "흰색";
		g90.model = "제네시스 g90";
		g90.maxSpeed = 180;	
		System.out.println("===========");
		
		System.out.println(g90.company);
		System.out.println(g90.color);
		System.out.println(g90.model);
		System.out.println(g90.maxSpeed);
		System.out.println("===========");
	}

}
