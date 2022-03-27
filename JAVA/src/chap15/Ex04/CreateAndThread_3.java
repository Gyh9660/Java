package chap15.Ex04;

// Runnable 인터페이스의 run()을 구현해서 스레드 생성
class SMIfileRunnable implements Runnable{
	@Override
	public void run() {
		String[] strArray = {"일","이","삼","사","오"};
		try {
			Thread.sleep(10);//0.01
		} catch (InterruptedException e) {
		}
		for (int i=0; i<strArray.length; i++) {
			System.out.println(" - (자막 번호)  "+strArray[i]);
			//0.2를 지연후 출력
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}


class VidioFileRunnable implements Runnable{
	@Override
	public void run() {
		//2. 비디오 프레임 출력
		int [] intArray= {1,2,3,4,5};
				
		for (int i =0; i<intArray.length; i++) {
			System.out.print("(비디오 프레임)"+ intArray[i]);
					
			//작업 지연 (0.2초)
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}



public class CreateAndThread_3 {

	public static void main(String[] args) {
		//첫번재 객체 생성후 시작
		Runnable smi = new SMIfileRunnable();
		//smi.start(); //start();는 Runnable인터페이스 에 없다
		Thread thread = new Thread(smi); //Runnable 객체를 Thread 생성자 내부에 넣는다
		thread.start();
		
		
		Runnable vidio = new VidioFileRunnable();
		Thread thread2 = new Thread(vidio);
		thread2.start();
	}

}
