package chap06_07.Ex02;

public class Example_Car2 {

	public static void main(String[] args) {
		
		
		Car sonata =new Car(); //��üȭ , 
		Car grandeur =new Car();
		//������ ���� �����Ҵ� ; ���� ������ �ƴϴ�. �޸��� �������ʴ� ���� ���� �Ҵ��Ҽ� �ִ�. (���ȹ���)
		//private�� ������տ� �����ϸ� : ĸ��ȭ, ���� ������ ���� �Ҵ����� ���ϵ��� �Ѵ�.
		//setter�� ���ؼ� ���� �ο� : ������ �ԷµǴ� ���� ���� �Ҽ� �ִ�.
		sonata.company = "����";
		sonata.model = "�ҳ�Ÿ";
		sonata.maxSpeed = 200; //-,700�� �̻��� ������ ������ ����
		sonata.color = "���׸�";
		
		System.out.println("======================");
		
		System.out.println(sonata.company);
		System.out.println(sonata.model);
		
		System.out.println("======================");
		
		// setter�� ���ؼ� ���� �Ҵ� : RAM�� ���� �ο� �Ҷ� ���
		grandeur.setCompany("����");
		grandeur.setColor("����");
		grandeur.setMaxSpeed(300);
		grandeur.setModel("�׷���");
		//getter�� �޸��� ���� ��� �Ҷ�
		System.out.println(grandeur.getCompany());
		System.out.println(grandeur.getModel());
		System.out.println(grandeur.getColor());
		
		
		
	}

}
