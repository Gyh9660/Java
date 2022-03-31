package chap15.Ex20;


class DataBox{
	int data ; //공유 필드
	boolean isEmpty= true; // 기본값 셋팅
 	
	synchronized void inputData (int data) { //동기화 메소드
		if (!isEmpty) {//false 일때 wait(); 동기화 블럭이나 동기화 메소드에서 WAITING 상태로 전환
						//data 필드의 값이 비어있지 않을때 잠시 대기 t2 쓰레드가 처리하도록
			try {wait();} catch (InterruptedException e) {}
		}
		isEmpty = false ; //Data 필드의 값을 넣고 t2쓰레드가 값을 읽을 수 있도록 false로 기본셋팅
		
		this.data=data;
		System.out.println("입력 데이터" + data); //data : 매개변수 값으로 들어오는 data
		notify();
	}
	
	synchronized void ouputData () { //동기화 메소드(블럭)
		if(isEmpty) {
			try {wait();} catch (InterruptedException e) {} //true일때 Waiting상태로 진입
		}
		isEmpty = true;
		System.out.println("출력 데이터" + data); //data : 메모리에 있는 data => this.data 에서 this가 생략됨
		notify(); //inputData() 메소드의 wait()된 쓰레드를 꺠워준다
	}
	
}

public class Watiing_WaitNotiy_2 {

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
