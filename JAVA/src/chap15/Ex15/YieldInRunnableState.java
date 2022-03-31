package chap15.Ex15;

//Thread.yield() : 쓰레드의 실행상태 (RUNNABLE)에 있는 특정 쓰레드에게 자신의 쓰레드는 일시 양보
	//싱행상태 내부에서 다른 쓰레드를 먼저 실행 하도록 양보.
	// 동기화에서 key를 서로 점유하는 현상이 발생되는데.... 키를 양보해서 균등하게 처리 하도록 할때 사용.

class MyThread extends Thread{
	boolean yieldFlag;
	@Override
	public void run() {
		while (true) { //무한 루프
			if (yieldFlag) { // yieldFlag가 True일때 쓰레드를 양보 해줌
				Thread.yield(); // 쓰레드를 양보 해줌.
			}else { //yieldFlag가 False일때  쓰레드 정보를 출력
				System.out.println(getName()+ "실행");
				for (long i = 0; i < 100000000L ; i++) {} //0.5초 시간 지연
			}
		}
	}
	
}


public class YieldInRunnableState {

	public static void main(String[] args) {

		MyThread thread1 = new MyThread();
		thread1.setName("thread1");
		thread1.yieldFlag = false; //false일때 쓰레드 정보 출력
		thread1.setDaemon(true); //마지막 쓰레드가 종료하면 같이 종료
		thread1.start();		//while무한 루프로 인해 빠져나오기 위해
		
		
		MyThread thread2 = new MyThread();
		thread2.setName("thread2");
		thread2.yieldFlag = true;
		thread2.setDaemon(true); //마지막 쓰레드가 종료하면 같이 종료
		thread2.start();
		
		//쓰레드 6초 지연 (1초마다 한번씩 양보)
		for (int i = 0; i <6; i++) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {} //0.1초 딜레이
			thread1.yieldFlag =! thread1.yieldFlag; // 참일땐 거짓을 저장하고 거짓일땐 참을 저장
			thread2.yieldFlag =! thread2.yieldFlag;
		}
		
	}

}
