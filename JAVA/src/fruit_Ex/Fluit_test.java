package fruit_Ex;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ����� �ٷ�� ���� �Դϴ�. ������ �����ڿ� super()�޼ҵ� ���
 * 
 */

class Fruit{
	String fruitName;	//���� �̸�
	String color;		//���� ��
	int large;			//���� ũ��
	Fruit(){
		
	}
	Fruit(String fruitName, String color, int large){
		this.fruitName = fruitName;
		this.color = color;
		this.large = large;
	}
	
	public String toString() { //������ ������ ����ϴ� �޼ҵ�
		return "������ �̸� :"+fruitName+"�̰�, ������ "+ color +"�̰�, ũ��� "+ large +"�Դϴ�.";
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLarge() {
		return large;
	}

	public void setLarge(int large) {
		this.large = large;
	}
	
}

class Apple extends Fruit {
	Apple(String fruitName, String color, int large){
		super(fruitName,color,large);
		
	}
	
}
class Orange extends Fruit {
	Orange(String fruitName, String color, int large){
		super(fruitName,color,large);
		
	}
}
class Banana extends Fruit {
	Banana(String fruitName, String color, int large){
		super(fruitName,color,large);
		
	}
}


public class Fluit_test {

	public static void main(String[] args) {
		ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
		//1. �ڵ� �ۼ� : ��ĳ�ʸ� ��ǲ �޴� �ڵ� �ۼ�.
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean run = true;		
		while(run) {
			System.out.println("===============================================");
		System.out.println("1. ��� | 2. ������ | 3. �ٳ��� | 4. ������� | 5. ����");
		System.out.println("===============================================");
			System.out.println("����>>");
			num = sc.nextInt();
			
			if(num == 1) {
				System.out.println("���� >> 1");	
				System.out.println("���ϸ� : ");
				String Name;
				Name = sc.next();
				System.out.println("���� : ");
				String color;
				color = sc.next();
				System.out.println("ũ�� : ");
				int large = sc.nextInt();
				Apple apple = new Apple(Name,color,large);
				fruitList.add(apple);
			}else if(num == 2) {
				System.out.println("���� >> 2");	
				System.out.println("���ϸ� : ");
				String Name;
				Name = sc.next();
				System.out.println("���� : ");
				String color;
				color = sc.next();
				System.out.println("ũ�� : ");
				int large = sc.nextInt();
				Orange orange = new Orange(Name,color,large);
				fruitList.add(orange);
			}else if(num == 3) {
				System.out.println("���� >> 3");	
				System.out.println("���ϸ� : ");
				String Name;
				Name = sc.next();
				System.out.println("���� : ");
				String color;
				color = sc.next();
				System.out.println("ũ�� : ");
				int large = sc.nextInt();
				Banana banana = new Banana(Name,color,large);
				fruitList.add(banana);
			}else if(num == 4) {
				System.out.println("���� >> 4");
				for(Fruit k : fruitList) {
					System.out.println(k);
				}
			}else if(num == 5) {
				System.out.println("���� >> 5");
				break;
			}
		}
		System.out.println("���α׷� ����");
		sc.close();
		
		
		
		
		//2. �ڵ� �ۼ� : ��ĳ�ʷ� ���� ������ ������ ��ü�� �����ؼ� ArrayList�� ����
		/*
		3. ����>> 4 ��ü�� �����ͼ� ��ü�� ��������� ArrayList�� ��簴ü�� �����ͼ� ��ü ������ ���	, Enhanced For ���� ����켭
			��°�� :
			������ �̸� : <���> �̰�, ������ <������> �̰�, ũ��� <10> �Դϴ�.
			������ �̸� : <������> �̰�, ������ <��Ȳ��> �̰�, ũ��� <12> �Դϴ�.
			������ �̸� : <�ٳ���> �̰�, ������ <�����> �̰�, ũ��� <15> �Դϴ�.
		*/
		
	}

}
