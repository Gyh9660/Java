package chap10.Ex04;

import chap10.Ex03.InstanceOf;

class Animal2{
	void run() {
		
	}
}

class Tiger extends Animal2{ //호랑이는 네발로 달립니다.
	@Override
	void run() {
		System.out.println("호랑이는 네발로 달립니다.");
	}
	void tigerEat() {
		System.out.println("호랑이는 동물을 먹습니다.");
	}
}

class Eagle extends Animal2{
	@Override
	void run() {
		System.out.println("독수리는 하늘을 납니다.");
	}
	void eagleEat() {
		System.out.println("독수리는 다른 새를 잡아 먹습니다.");
	}
}

class Snake extends Animal2{
	@Override
	void run() {
		System.out.println("뱀은 기어다닙니다.");
	}
}

public class MethodOverriding_2 {

	public static void main(String[] args) {

		//1. 모든 객체는 Animal2 타입으로 업캐스팅해서 생성.
		Animal2 at = new Tiger();
		at.run();
		Animal2 ae = new Eagle();
		ae.run();
		Animal2 as = new Snake();
		as.run();
		
		//2. Animal2배열에 각 객체를 저장
		Animal2[] animal = {at, ae, as};
		System.out.println("=======for 문===========");
		//3. for문으로 배열의 객체를 출력, run()실행
		for (int i=0; i<animal.length; i++) {
			animal[i].run();
		}
		System.out.println("========Enhanced For문========");
		//4. Enhanced For 문을 사용해서 객체의 run()메소드 출력
		for (Animal2 k : animal) {
			k.run();
		}
		System.out.println("===========다운캐스팅==========");
		//5. 다운캐스팅 (instanceof를 사용해서) 출력
		if (at instanceof Tiger) {
			Tiger tt = (Tiger)at;
			tt.tigerEat();
		}else {
			System.out.println("Tiger타입으로 캐스팅 불가");
		}
		
		if (ae instanceof Eagle) {
			Eagle ee = (Eagle)ae;
			ee.eagleEat();
		}else {
			System.out.println("Eagle타입으로 캐스팅 불가");
		}
		
		
	}

}
