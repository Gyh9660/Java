package chap15;

/*
 * 쓰레드 4개 생성 : 1. Thread를 상속, 2. Runnable 구현, 3. 익명 내부클래스를 생성해서 구현
 * 각 값을 String 배열에 저장후 아래와 같이 출력하세요.
 * 
 * 1	2		3		4
 * 이름	홍길동	이순신	신사임당
 * 나이	40		50		60
 * 국어	100		90		80
 * 영어	70		60		100
 * 수학	50		70		80
 */
class A extends Thread{
	@Override
	public void run() {
		String[] strArray3 = {"이순신","50","90","60","70"};
		try {Thread.sleep(15);}catch(InterruptedException e) {}//0.01
		for (int i=0; i<strArray3.length; i++) {
			System.out.print(strArray3[i]+ " ");
			//0.2를 지연후 출력
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}
class B implements Runnable{
	@Override
	public void run() {
		String[] strArray4 = {"신사임당","60","80","100","80"};
		try {Thread.sleep(20);}catch(InterruptedException e) {}//0.01
		for (int i=0; i<strArray4.length; i++) {
			try {Thread.sleep(10);}catch(InterruptedException e) {}//0.01
			System.out.println(strArray4[i]+ " ");
			//0.2를 지연후 출력
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}
public class EX_CreateAndStartThread {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				String[] strArray1 = {"이름","나이","국어","영어","수학"};
				for (int i =0; i<strArray1.length;i++) {
					System.out.print(strArray1[i]+ " ");
					try {Thread.sleep(200);}catch(InterruptedException e) {}
				}
			}
			});	

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				String[] strArray2 = {"홍길동","40","100","70","50"};
				try {Thread.sleep(10);}catch(InterruptedException e) {}//0.01
				for (int i =0; i<strArray2.length;i++) {
					System.out.print(strArray2[i]+ " ");
					try {Thread.sleep(200);} catch(InterruptedException e) {}
				}
			}
			});	
		
		thread1.start();
		thread2.start();
		Thread thread3 = new A();
		thread3.start();

		Runnable b = new B();
		Thread thread4 = new Thread(b);
		thread4.start();
		
	}

}
