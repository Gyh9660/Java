package chap15.Ex09;


//동기화 (Synchronized) : 여러 쓰레드가 하나의 공유된 필드를 접근할경우
	//					한작업을 완전히 완료후 다음작업을 처리하도록 설정
	//내가 작업할떄 lock을 걸고 작업을 마치면 lock를 해제 한다.

//1. 동기화를 처리 하지 않았을때 예문

//메소드 동기화 : 메소드 전체를 동기화 하는것
	//key값이 this 할당됨

class MyData{ //쓰레드들이 공유하는 객체 필드

	int data = 3; //데이터 가져오기
	
	public synchronized void pulsData() { //메소드 동기화 : 메소드 안의 모든걸(전체를) 동기화
		//동기화 처리 메소드 : 하나의 쓰레드가 작업이 완료되면 다음 쓰레드가 작업 할 수 있다. 
		int mydata = data;
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		data = mydata + 1;
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


public class SynchronizedMethod {

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
