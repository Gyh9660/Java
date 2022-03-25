package chap06_07.Ex06;

import chap06_07.Ex05.C;

public class Ex_C {

	public static void main(String[] args) {
		//다른패키지에 존재함 /public만 접근 /model,color 메모리로 접근 불가
		// model과 color는 setter를 public 통해서 할당후 출력
		C cc = new C(); // 다른 패키지 이므로 import
			//company, model, color 는 다른 패키지에서 접근 불가, setter를 통해서 메모리값을 할당하도록 구성
		cc.maxSpeed = 220; //다른 패키지의 클래스에서는 public, protected(상속 설정)
		
		//setter를 통해서 메모리의 값을 부여.
		cc.setModel("그렌져");
		cc.setColor("흰색");
		cc.setMaxSpeed(300);
		
		cc.print();
		
	}

}
