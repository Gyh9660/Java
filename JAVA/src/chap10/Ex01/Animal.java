package chap10.Ex01;

class Dog_sub extends Dog {
	
	int dog_sub;
	
	void dog_sub() {
		System.out.println("Dog의 자식 클래스 입니다.");
	}
}




class Tiger extends Animal{
	int leg;
	
	void tigerEat() {
		System.out.println("호랑이는 다른 동물을 잡아 먹습니다.");
	}
}

class Dog extends Animal{
	int dog;
	
	void dogEat() {
		System.out.println("개는 잡식성 입니다.");
	}
	
}

class Eagle extends Animal{
	int eagle;
	void eagleFly() {
		System.out.println("독수리는 날라다닙니다.");
	}
	
}


public class Animal {
	String name;	//동물의 이름
	int age;		//동물의 나이
	String color;	//동물의 색깔
	
	void eat() {
		System.out.println("모든 동물은 음식을 먹습니다.");
	}
	void sleep() {
		System.out.println("모든 동물은 잠을 잡니다.");
	}
	
	public static void main(String[] args) {
		
		//업캐스팅은 다형성으로 처리하기 떄문에 아주아주 효율적으로 프로그래밍을 처리
			//다형성 : 오버라이딩(상속)을 이용해서 상속에서 하나의 메소드로 여러 정보를 처리....
		
		//1. Animal 클래스를 객채화
		Animal a1 = new Animal(); //자신의 필드와 메소드만 접근
		
		//2. Dog 클래스를 Dog타입으로 객체화
		Dog d1 = new Dog();	//Animal, dog의 필드와 메소드 접근
		
		//3.Dog를 Animal타입으로 업캐스팅
		Animal a2 = new Dog(); //a2는 Animal, Dog타입을 내포하고 있고, Animal의 필드와 메소드만 접근가능

		//4.Dog_sub를 Animal타입으로 업캐스팅
		Animal a3 = new Dog_sub(); //a3는 Animal, Dog, Dog_sub 타입을 내포하고 있고, Animal의 필드와 메소드만 접근가능
			a3.name = "요크셔테리어";//Animal
			//a3.dog = 6 ; // Dog 필드 접근불가(오류발생)
		
		
		//5.Dog_sub를 Dog 데이터 타입으로 업캐스팅
		Dog d2 = new Dog_sub(); //d2는 Animal, Dog,Dog_sub 타입을 내포하고 있고, Animal과 Dog의 필드와 메소드만 접근가능
			d2.name="셰퍼드";  //Animal
			d2.dog = 255; //Dog	
			//d2.Dog_sub = 3;//Dog_sub 접근불가(오류발생)
			
			
		//Animal <== Dog <== Dog_sub
		//6. Dog_sub를 Dog_sub데이터 타입으로 객체화
		Dog_sub ds1 = new Dog_sub(); //
			//ds1은 Animal, Dog,Dog_sub 중에 Animal, Dog,Dog_sub 필드와 메소드를 모두 접근 가능
		ds1.name = "진돗개"; //Animal 클래스의 필드
		ds1.age = 4; //Animal
		ds1.dog = 3; //Dog
		ds1.dog_sub = 2; //Dog_sub
	
		
//상속에서 업캐스팅, 다운 캐스팅	
		
		
		
	//업캐스팅 : 자식타입의 데이터타입에서 부모데이터타입으로 변환(자동)
		// 부모타입의 필드와 메소드만 접근.
		// 강제 타입변환을 하지 않아도 자동으로 (업캐스팅)변환
		//ds1은 Dog_sub의 데이터 타입을 가지고 있다. (Animal, Dog, Dog_sub의 모든 필드와 메소드 접근이 가능)
		
		
		Dog ds1_c1 = ds1; //업캐스팅 :Dog_sub ===>Dog타입으로 업캐스팅(Animal, Dog만 접근) = ds1; 에서 ds1앞에 (Dog)생략가능(업캐스팅만) 다운캐스팅은 생략못함 명시해줘야함
			Dog ds2_c1 = (Dog)ds1; //강제 타입변환(제대로된 구문)
		
		ds1_c1.name = "말티즈";
		ds1_c1.dog = 1;
				
		Animal ds1_c2 = ds1; //업캐스팅 : Dog_sub ===> Animal 타입으로 업캐스팅 (Animal만 접근)
		ds1_c2.name = "시츄";
		
		//ds1 : Dog_sub(Animal,Dog,Dog_sub)
		//ds1_c1 : Dog (Animal,Dog)
		//ds1_c2 : Animal (Animal)
		
		
		
	//다운캐스팅 : 부모 데이터 타입을 다시 자식 데이터타입으로 변환(수동)
		// 강제로 타입 변환이 필요함.
		// a3는 Animal, Dog ,Dog_sub 데이터 타입중 Animal 타입만 쓸수 있도록 업캐스팅이 되어있다.
		
		Dog a3_down1 = (Dog)a3; //a3 (Animal) ===> a3_down1(Dog) 강제 타입 변환
		a3_down1.dog = 44;
		//다운캐스팅은 Dog a3_down1 = (Dog)a3 <===에서 (Dog)를 생략하지못하고 반드시 명시해줘야함! 강제 타입 변환
		Dog_sub a3_down2 = (Dog_sub)a3;//a3 (Animal) ===> a3_down2(Dog_sub)
		a3_down2.dog_sub = 24;
		
		
		
	}

}
