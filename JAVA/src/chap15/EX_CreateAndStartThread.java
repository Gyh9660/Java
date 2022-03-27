package chap15;

/*
 * ������ 4�� ���� : 1. Thread�� ���, 2. Runnable ����, 3. �͸� ����Ŭ������ �����ؼ� ����
 * �� ���� String �迭�� ������ �Ʒ��� ���� ����ϼ���.
 * 
 * 1	2		3		4
 * �̸�	ȫ�浿	�̼���	�Ż��Ӵ�
 * ����	40		50		60
 * ����	100		90		80
 * ����	70		60		100
 * ����	50		70		80
 */
class A extends Thread{
	@Override
	public void run() {
		String[] strArray3 = {"�̼���","50","90","60","70"};
		try {Thread.sleep(15);}catch(InterruptedException e) {}//0.01
		for (int i=0; i<strArray3.length; i++) {
			System.out.print(strArray3[i]+ " ");
			//0.2�� ������ ���
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}
class B implements Runnable{
	@Override
	public void run() {
		String[] strArray4 = {"�Ż��Ӵ�","60","80","100","80"};
		try {Thread.sleep(20);}catch(InterruptedException e) {}//0.01
		for (int i=0; i<strArray4.length; i++) {
			try {Thread.sleep(10);}catch(InterruptedException e) {}//0.01
			System.out.println(strArray4[i]+ " ");
			//0.2�� ������ ���
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
				String[] strArray1 = {"�̸�","����","����","����","����"};
				for (int i =0; i<strArray1.length;i++) {
					System.out.print(strArray1[i]+ " ");
					try {Thread.sleep(200);}catch(InterruptedException e) {}
				}
			}
			});	

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				String[] strArray2 = {"ȫ�浿","40","100","70","50"};
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
