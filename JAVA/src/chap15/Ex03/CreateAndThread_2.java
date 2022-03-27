package chap15.Ex03;
//2번째 스레드
class SMIFileThread extends Thread{ //자막 파일 처리하는 쓰레드
	@Override
	public void run() {
		//1 자막 번호 출력
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

//3번째 스레드
class VideoFileThread extends Thread{ // 비디오 프레임을 처리하는 쓰레드
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


public class CreateAndThread_2 {

//1. main Thread
	public static void main(String[] args) {
		//SMIFileThread 객체시작
		Thread smi = new SMIFileThread();
		smi.start();
		
		
		//VideoFileThread 객체시작
		Thread vidio = new VideoFileThread();
		vidio.start();
		
		
		
	}

}
