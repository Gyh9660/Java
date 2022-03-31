package chap15.Ex10;

//동기화 : 여러 쓰레드가 공유된 필드에 접근할때 하나의 쓰레드 작업시 다른 쓰레드가 접근하지 못하도록 설정
	//메소드 동기화, 블락 동기화 


//블락동기화 : 주의 : 메소드내부의 일부분만 동기화
//		- 구문 형식 : synchronized (임의의 객체) {}
//								this : 자신의 객체, new 임의의 객체
class A{}
class B{}
class C{}

class MyData{ //쓰레드들이 공유하는 객체 필드

	int data = 3; //데이터 가져오기
	
	public void pulsData() { 
		//동기화 처리 메소드 : 하나의 쓰레드가 작업이 완료되면 다음 쓰레드가 작업 할 수 있다. 
		synchronized (new Object()) { 
			//블락 동기화 : 메소드의 일부분만 동기화 , this : 자신의 객체
						//new 임의의객체() 를 넣을수있음
			//this : 자신의 객체를 뜻하고, 동기화 블록에 접근하는 키이다.
			//모든 쓰레드는 Key를 가져야 동기화 블럭을 접근 할 수 있따.
			//Key는 임의의 객체를 키로 사용할 수 있다.
			int mydata = data;
			try {Thread.sleep(2000);} catch (InterruptedException e) {}
			data = mydata + 1;
		}
	}
}
class PlusThread extends Thread{ //1T씩 증가하면서 두개의 쓰레드
	MyData myData;
	public PlusThread(MyData myData) {
		this.myData=myData;
	}
	@Override
	public void run() {
		myData.pulsData();
		System.out.println(getName()+ "실행 결과 : " + myData.data);
	
	
	}
}




public class SynchronizedBlock {

	public static void main(String[] args) {

		//공유 객체 생성
		MyData myData = new MyData();
				
		//1. PlusThread1
		Thread plusThread1 = new PlusThread(myData);
		plusThread1.setName("plusThread1");
		plusThread1.start();
				
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
				
		//2. PlusThread1
		Thread plusThread2 = new PlusThread(myData);
		plusThread2.setName("plusThread2");
		plusThread2.start();
		
		
		
		
		
	}

}
