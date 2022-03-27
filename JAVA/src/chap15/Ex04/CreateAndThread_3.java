package chap15.Ex04;

// Runnable �������̽��� run()�� �����ؼ� ������ ����
class SMIfileRunnable implements Runnable{
	@Override
	public void run() {
		String[] strArray = {"��","��","��","��","��"};
		try {
			Thread.sleep(10);//0.01
		} catch (InterruptedException e) {
		}
		for (int i=0; i<strArray.length; i++) {
			System.out.println(" - (�ڸ� ��ȣ)  "+strArray[i]);
			//0.2�� ������ ���
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
		//2. ���� ������ ���
		int [] intArray= {1,2,3,4,5};
				
		for (int i =0; i<intArray.length; i++) {
			System.out.print("(���� ������)"+ intArray[i]);
					
			//�۾� ���� (0.2��)
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}



public class CreateAndThread_3 {

	public static void main(String[] args) {
		//ù���� ��ü ������ ����
		Runnable smi = new SMIfileRunnable();
		//smi.start(); //start();�� Runnable�������̽� �� ����
		Thread thread = new Thread(smi); //Runnable ��ü�� Thread ������ ���ο� �ִ´�
		thread.start();
		
		
		Runnable vidio = new VidioFileRunnable();
		Thread thread2 = new Thread(vidio);
		thread2.start();
	}

}
