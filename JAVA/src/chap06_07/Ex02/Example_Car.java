package chap06_07.Ex02;

public class Example_Car {

	public static void main(String[] args) {
		// Car Class�� ��üȭ �ؼ� 5���� ��ü�� �����ؼ� ���� �Ҵ��ؼ� ���
		//settor�� ���ؼ� ���� �Ҵ�
		Car sonata = new Car();
		sonata.setCompany("����");
		sonata.setColor("ȸ��");
		sonata.setModel("�ҳ�Ÿ");
		sonata.setMaxSpeed(150);
		
		System.out.println(sonata.getCompany());
		System.out.println(sonata.getColor());
		System.out.println(sonata.getModel());
		System.out.println(sonata.getMaxSpeed());
		System.out.println("==============");
		
		Car sm5 = new Car();
		
		sm5.setCompany("�Ｚ");
		sm5.setColor("ȸ��");
		sm5.setModel("sm5");
		sm5.setMaxSpeed(155);
		
		System.out.println(sm5.getCompany());
		System.out.println(sm5.getColor());
		System.out.println(sm5.getModel());
		System.out.println(sm5.getMaxSpeed());
		System.out.println("==============");
		
		Car  ioniq5 = new Car();
		
		ioniq5.setCompany("����");
		ioniq5.setColor("���");
		ioniq5.setModel("���̿���5");
		ioniq5.setMaxSpeed(140);
		
		System.out.println(ioniq5.getCompany());
		System.out.println(ioniq5.getColor());
		System.out.println(ioniq5.getModel());
		System.out.println(ioniq5.getMaxSpeed());
		System.out.println("==============");
		
		Car sm7 = new Car();
		
		sm7.setCompany("�Ｚ");
		sm7.setColor("������");
		sm7.setModel("sm7");
		sm7.setMaxSpeed(160);
		
		System.out.println(sm7.getCompany());
		System.out.println(sm7.getColor());
		System.out.println(sm7.getModel());
		System.out.println(sm7.getMaxSpeed());
		System.out.println("==============");
		
		Car sm3 = new Car();
		
		sm3.setCompany("�Ｚ");
		sm3.setColor("ȸ��");
		sm3.setModel("sm3");
		sm3.setMaxSpeed(155);
		
		System.out.println(sm3.getCompany());
		System.out.println(sm3.getColor());
		System.out.println(sm3.getModel());
		System.out.println(sm3.getMaxSpeed());
		System.out.println("==============");
		
		//���� ���
		Car g70 = new Car();
		System.out.println(g70.company);
		System.out.println(g70.color);
		System.out.println(g70.model);
		System.out.println(g70.maxSpeed);
		
		g70.company = "����";
		g70.color = "������";
		g70.model = "���׽ý� g70";
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
		
		g80.company = "����";
		g80.color = "���";
		g80.model = "���׽ý� g80";
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
		
		gv60.company = "����";
		gv60.color = "ȸ��";
		gv60.model = "���׽ý� gv60";
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
		
		gv70.company = "����";
		gv70.color = "������";
		gv70.model = "���׽ý� gv70";
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
		
		g90.company = "����";
		g90.color = "���";
		g90.model = "���׽ý� g90";
		g90.maxSpeed = 180;	
		System.out.println("===========");
		
		System.out.println(g90.company);
		System.out.println(g90.color);
		System.out.println(g90.model);
		System.out.println(g90.maxSpeed);
		System.out.println("===========");
	}

}
