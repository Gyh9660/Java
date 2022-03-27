package chap15.Ex03;
//2��° ������
class SMIFileThread extends Thread{ //�ڸ� ���� ó���ϴ� ������
	@Override
	public void run() {
		//1 �ڸ� ��ȣ ���
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

//3��° ������
class VideoFileThread extends Thread{ // ���� �������� ó���ϴ� ������
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


public class CreateAndThread_2 {

//1. main Thread
	public static void main(String[] args) {
		//SMIFileThread ��ü����
		Thread smi = new SMIFileThread();
		smi.start();
		
		
		//VideoFileThread ��ü����
		Thread vidio = new VideoFileThread();
		vidio.start();
		
		
		
	}

}
