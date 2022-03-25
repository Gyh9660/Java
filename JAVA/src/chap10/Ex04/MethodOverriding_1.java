package chap10.Ex04;

//�޼ҵ� �������̵�

class Animal {
	void cry() {
		
	}
}

class Bird extends Animal{
	@Override
	void cry() {
		System.out.println("±��");
	}
}

class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("�߿�");
	}
}

class Dog extends Animal{
	@Override
	void cry() {
		System.out.println("�۸�");
	}
}




public class MethodOverriding_1 {

	public static void main(String[] args) {
		//1. ������ Ÿ������ ���� + ������ Ÿ������ ����.
		Animal aa = new Animal(); //Animal Ŭ������ cry()
		Bird bb = new Bird();	//Bird Ŭ������ cry()
		Cat cc = new Cat();		//Cat Ŭ������ cry()
		Dog dd = new Dog();		//Dog Ŭ������ cry()
			aa.cry();
			bb.cry();
			cc.cry();
			dd.cry();
		System.out.println("=====================");
		
		//2. Animal Ÿ������ ���� + �ڽ� Ÿ������ ���� :���� ���ε��� ���ؼ� �θ��� cry()�� ȣ���� ��� �ڽ��� �����ε��� cry()�� ���ε��� 
		
		
		Animal ab = new Bird();
//Bird�� ��äȭ�ؼ� AnimalŸ������ //ab�� Animal,Bird Ÿ���� ����, Animal�ʵ�� �޼ҵ常 ����
		ab.cry(); 	
		//Animal�� cry() �� ȣ���� ��� �������ε��� ���ؼ� BirdŬ������ cry()�� ȣ��
		
		Animal ac = new Cat();
//Cat�� ��äȭ�ؼ� AnimalŸ������ //ac�� Animal,CatŸ���� ����, Animal�ʵ�� �޼ҵ常 ����
		ac.cry();
		//Animal�� cry() �� ȣ���� ��� �������ε��� ���ؼ� CatŬ������ cry()�� ȣ��
		
		Animal ad = new Dog();
//Dog�� ��äȭ�ؼ� AnimalŸ������ //ac�� Animal,DogŸ���� ����, Animal�ʵ�� �޼ҵ常 ����
		ad.cry();	
		//Animal�� cry() �� ȣ���� ��� �������ε��� ���ؼ� DogŬ������ cry()�� ȣ��
			
		System.out.println("=====================");
		
		//3. ��ü �迭�� ����
	
		Animal[] animal = {ab, ac, ad};
	 //��üŸ�Թ迭 �迭�̸� = {��ü,��ü,��ü};
		
		for (Animal k : animal) {
			k.cry();
		}
		
		System.out.println("=========================");
		
		for (int i = 0; i<animal.length;i++) {
			animal[i].cry();
		}
		
		
	}

}
