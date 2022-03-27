package chap15.Ex05;

//객체 생성없이 이경객체를 사용해서 스레드 생성. < == 제일 많이 사용한다.

public class CreateAndThread_4 {

	public static void main(String[] args) {
		//자막 번호 출력
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				//1 자막 번호 출력
				String[] strArray = {"일","이","삼","사","오"};
				try {Thread.sleep(10);}catch(InterruptedException e) {}//0.01
				for (int i =0; i<strArray.length;i++) {
					System.out.println(" - 자막 번호" + strArray[i]);
					try {Thread.sleep(200);}catch(InterruptedException e) {}
				}
			}
			});	

		//비디오 프레임 출력 -쓰레드
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//2 비디오 프레임 출력
				int[] intArray = {1,2,3,4,5};
				for (int i =0; i<intArray.length;i++) {
					System.out.print(" (비디오프레임)" + intArray[i]);
					try {Thread.sleep(200);} catch(InterruptedException e) {}
				}
			}
			});	
		
		thread1.start();
		
		thread2.start();
	}
}
