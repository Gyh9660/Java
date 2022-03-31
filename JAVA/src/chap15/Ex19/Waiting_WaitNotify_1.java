package chap15.Ex19;

//Waiting :
	//a[객체명].join() : 자신의 스레드는 waiting상태이고 a라는 객체에게 CPU를 할당 (RUNNABLE) 
			//a객체가 실행이 완료되면 자신의 쓰레드가 (RUNNABLE)로 이동
		//자신 쓰레드의 처리할내용이 다른쓰레드의 결과를 받아서 처리해야 할 경우
	//wait(),notify(),notifyAll() <== 동기화 블럭에서만 사용가능
	//  -wait() 동기화블럭(메소드) 내에서 wait() 메소드를 만나면  Waiting 상태로 진입.
	//  -notify(),notifyAll()가 wait() 메소드를 꺠워줌. 
			//===>반드시 다른 쓰레드에서 깨워줄수 있다.

class DataBox{
	int data ; //공유 필드
	
	synchronized void inputData (int data) { //동기화 메소드
		this.data=data;
		System.out.println("입력 데이터" + data); //data : 매개변수 값으로 들어오는 data
		
	}
	
	synchronized void ouputData () { //동기화 메소드(블럭)
		System.out.println("출력 데이터" + data); //data : 메모리에 있는 data => this.data 에서 this가 생략됨

	}
	
}

public class Waiting_WaitNotify_1 {

	public static void main(String[] args) {

		DataBox dataBox = new DataBox();
		
		//첫번째 쓰레드 : 공유 객체에 값을 넣는 쓰레드
		Thread t1 = new Thread() { //익명 내부클래스
			@Override
			public void run() {
				for (int i=1; i<9; i++) {
					dataBox.inputData(i);
				}
			}
		};
		
		//두번째 쓰레드 : 공유 객체로 부터 값을 읽어 오는 메소드
		Thread t2 = new Thread() { //익명 내부클래스
			@Override
			public void run() {
				for (int i=1; i<9; i++) {
					dataBox.ouputData();
				}
			}
		};
		
		t1.start();
		t2.start();
		
		
		
		
		
		
		
		
		
		
	}

}
