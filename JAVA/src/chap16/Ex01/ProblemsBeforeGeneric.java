package chap16.Ex01;

//Generic ����� ������ -��ǰ�� ������ Ŭ������ �Ź� ������ ��� �Ѵ�.

//��ü�� ���� Ŭ������ ���� ���, �Ź� ��ü�� �����Ҷ� ���� �� ��ü�� ���� Ŭ������ ���������Ѵ�.
//��ü�� ������ Ŭ������ �����ؼ� ��ü ������ ���� �� �ִ� <== ���ο� ��ǰ�� �߰� �ɶ� ���� �� ��ǰ�� ���� Ŭ������ ������ ��� �Ѵ�.
// �ڵ尡 ������ ����������




class Apple{ //��� Ŭ����, ����� ������ ���� ��ü
	String name;
	int price;
	
	Apple (String name, int price){ //������
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() { //��ü ��ü�� ��½� ��ü�� �ּҰ� �ƴ϶� �ʵ��� ������ ���
		return "�̸� : " + name + " , ���� : " + price;
	}
}
//1. Apple�� ���� �� �ִ� Ŭ���� ����.
class Goods1 { //��ǰ�� ����� ��� Ŭ����
	private Apple apple = new Apple("���",1000);

	public Apple getApple() { //getter  : ��ü �ʵ��� ������ ����ϴ� ��
		return apple;
	}

	public void setApple(Apple apple) { //setter
		this.apple = apple;
	}
			
}





class Pencil { //���� Ŭ����
	String name;
	int price;
	
	Pencil (String name, int price){ //�����ڸ� ���ؼ� �ʵ��� �� �Ҵ�.
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "�̸� : " + name + " , ���� : " + price;
	}
}

class Goods2{ //��ǰ2 :���� ��ǰ�� ���� Ŭ����
	private Pencil pencil = new Pencil("����",2000);

	public Pencil getPancil() {
		return pencil;
	}

	public void setPancil(Pencil pencil) {
		this.pencil = pencil;
	}
		
	
}


public class ProblemsBeforeGeneric {

	public static void main(String[] args) {
		//1. Goods1 ��ǰ�� ����Ǿ� �ִ�. Apple ��ü �߰� �� ��������
		Goods1 goods1 = new Goods1(); //�⺻������
		goods1.setApple(new Apple("���2", 2000)); //setter�� �����Ҵ�
		System.out.println(goods1.getApple());//�ʵ��� ������ ���
		 
		//2. Goods2 ��ǰ�� ����. Pencil ��ü�� ����,
		Goods2 goods2 = new Goods2();
		goods2.setPancil(new Pencil("����2",3000));
		System.out.println(goods2.getPancil());
	}

}
