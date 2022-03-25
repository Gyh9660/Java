package chap10.Ex01;

class Dog_sub extends Dog {
	
	int dog_sub;
	
	void dog_sub() {
		System.out.println("Dog�� �ڽ� Ŭ���� �Դϴ�.");
	}
}




class Tiger extends Animal{
	int leg;
	
	void tigerEat() {
		System.out.println("ȣ���̴� �ٸ� ������ ��� �Խ��ϴ�.");
	}
}

class Dog extends Animal{
	int dog;
	
	void dogEat() {
		System.out.println("���� ��ļ� �Դϴ�.");
	}
	
}

class Eagle extends Animal{
	int eagle;
	void eagleFly() {
		System.out.println("�������� ����ٴմϴ�.");
	}
	
}


public class Animal {
	String name;	//������ �̸�
	int age;		//������ ����
	String color;	//������ ����
	
	void eat() {
		System.out.println("��� ������ ������ �Խ��ϴ�.");
	}
	void sleep() {
		System.out.println("��� ������ ���� ��ϴ�.");
	}
	
	public static void main(String[] args) {
		
		//��ĳ������ ���������� ó���ϱ� ������ ���־��� ȿ�������� ���α׷����� ó��
			//������ : �������̵�(���)�� �̿��ؼ� ��ӿ��� �ϳ��� �޼ҵ�� ���� ������ ó��....
		
		//1. Animal Ŭ������ ��äȭ
		Animal a1 = new Animal(); //�ڽ��� �ʵ�� �޼ҵ常 ����
		
		//2. Dog Ŭ������ DogŸ������ ��üȭ
		Dog d1 = new Dog();	//Animal, dog�� �ʵ�� �޼ҵ� ����
		
		//3.Dog�� AnimalŸ������ ��ĳ����
		Animal a2 = new Dog(); //a2�� Animal, DogŸ���� �����ϰ� �ְ�, Animal�� �ʵ�� �޼ҵ常 ���ٰ���

		//4.Dog_sub�� AnimalŸ������ ��ĳ����
		Animal a3 = new Dog_sub(); //a3�� Animal, Dog, Dog_sub Ÿ���� �����ϰ� �ְ�, Animal�� �ʵ�� �޼ҵ常 ���ٰ���
			a3.name = "��ũ���׸���";//Animal
			//a3.dog = 6 ; // Dog �ʵ� ���ٺҰ�(�����߻�)
		
		
		//5.Dog_sub�� Dog ������ Ÿ������ ��ĳ����
		Dog d2 = new Dog_sub(); //d2�� Animal, Dog,Dog_sub Ÿ���� �����ϰ� �ְ�, Animal�� Dog�� �ʵ�� �޼ҵ常 ���ٰ���
			d2.name="���۵�";  //Animal
			d2.dog = 255; //Dog	
			//d2.Dog_sub = 3;//Dog_sub ���ٺҰ�(�����߻�)
			
			
		//Animal <== Dog <== Dog_sub
		//6. Dog_sub�� Dog_sub������ Ÿ������ ��üȭ
		Dog_sub ds1 = new Dog_sub(); //
			//ds1�� Animal, Dog,Dog_sub �߿� Animal, Dog,Dog_sub �ʵ�� �޼ҵ带 ��� ���� ����
		ds1.name = "������"; //Animal Ŭ������ �ʵ�
		ds1.age = 4; //Animal
		ds1.dog = 3; //Dog
		ds1.dog_sub = 2; //Dog_sub
	
		
//��ӿ��� ��ĳ����, �ٿ� ĳ����	
		
		
		
	//��ĳ���� : �ڽ�Ÿ���� ������Ÿ�Կ��� �θ�����Ÿ������ ��ȯ(�ڵ�)
		// �θ�Ÿ���� �ʵ�� �޼ҵ常 ����.
		// ���� Ÿ�Ժ�ȯ�� ���� �ʾƵ� �ڵ����� (��ĳ����)��ȯ
		//ds1�� Dog_sub�� ������ Ÿ���� ������ �ִ�. (Animal, Dog, Dog_sub�� ��� �ʵ�� �޼ҵ� ������ ����)
		
		
		Dog ds1_c1 = ds1; //��ĳ���� :Dog_sub ===>DogŸ������ ��ĳ����(Animal, Dog�� ����) = ds1; ���� ds1�տ� (Dog)��������(��ĳ���ø�) �ٿ�ĳ������ �������� ����������
			Dog ds2_c1 = (Dog)ds1; //���� Ÿ�Ժ�ȯ(����ε� ����)
		
		ds1_c1.name = "��Ƽ��";
		ds1_c1.dog = 1;
				
		Animal ds1_c2 = ds1; //��ĳ���� : Dog_sub ===> Animal Ÿ������ ��ĳ���� (Animal�� ����)
		ds1_c2.name = "����";
		
		//ds1 : Dog_sub(Animal,Dog,Dog_sub)
		//ds1_c1 : Dog (Animal,Dog)
		//ds1_c2 : Animal (Animal)
		
		
		
	//�ٿ�ĳ���� : �θ� ������ Ÿ���� �ٽ� �ڽ� ������Ÿ������ ��ȯ(����)
		// ������ Ÿ�� ��ȯ�� �ʿ���.
		// a3�� Animal, Dog ,Dog_sub ������ Ÿ���� Animal Ÿ�Ը� ���� �ֵ��� ��ĳ������ �Ǿ��ִ�.
		
		Dog a3_down1 = (Dog)a3; //a3 (Animal) ===> a3_down1(Dog) ���� Ÿ�� ��ȯ
		a3_down1.dog = 44;
		//�ٿ�ĳ������ Dog a3_down1 = (Dog)a3 <===���� (Dog)�� �����������ϰ� �ݵ�� ����������! ���� Ÿ�� ��ȯ
		Dog_sub a3_down2 = (Dog_sub)a3;//a3 (Animal) ===> a3_down2(Dog_sub)
		a3_down2.dog_sub = 24;
		
		
		
	}

}
