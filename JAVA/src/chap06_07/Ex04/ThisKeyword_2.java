package chap06_07.Ex04;

//this 반드시 추기해야하는 경우 [명시적 this 키워드 추가]

class Aa{ //this key를 사용하지 않은 경우 : 지역변수로 인식
	int m;
	int n;
	void init (int m, int n) {
		m = m; //this keyword를 사용하지 않은 경우 m<==지역변수m
		n = n; //this keyword를 사용하지 않은 경우 n<==지역변수n
		
	}
	
}

class Bb{ //this key를 사용하는 경우
	int m;
	int n;
	void init (int m, int n) { //this 키를 병시적으로 반드시 사용해서 m과 n이 필드의 m과 n이라고 알려줘야 한다.
		this.m = m; //this 키를 사용한 경우 m <== 필드 m
		this.n = n; //this 키를 사용한 경우 n <== 필드 n
		
	}
	
}

public class ThisKeyword_2 {

	public static void main(String[] args) {
		
		// 1. 필드의 명과 지역변수의 명이 같은 경우 (this 키워드를 사용하지 않은 경우 : 지역변수에 저장)
		Aa aa = new Aa();
		aa.init(2, 3);
		System.out.println(aa.m); //0
		System.err.println(aa.n); //0
		// 2. 필드의 명과 지역변수의 명이 같은 경우 (this 키워드를 사용한 경우 : 필드 변수에 저장)
		
		Bb bb = new Bb();
		bb.init(2, 3);
		System.out.println(bb.m); //2
		System.out.println(bb.n); //3
	}

}
