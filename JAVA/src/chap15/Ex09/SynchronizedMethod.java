package chap15.Ex09;


//����ȭ (Synchronized) : ���� �����尡 �ϳ��� ������ �ʵ带 �����Ұ��
	//					���۾��� ������ �Ϸ��� �����۾��� ó���ϵ��� ����
	//���� �۾��ҋ� lock�� �ɰ� �۾��� ��ġ�� lock�� ���� �Ѵ�.

//1. ����ȭ�� ó�� ���� �ʾ����� ����

//�޼ҵ� ����ȭ : �޼ҵ� ��ü�� ����ȭ �ϴ°�
	//key���� this �Ҵ��

class MyData{ //��������� �����ϴ� ��ü �ʵ�

	int data = 3; //������ ��������
	
	public synchronized void pulsData() { //�޼ҵ� ����ȭ : �޼ҵ� ���� ����(��ü��) ����ȭ
		//����ȭ ó�� �޼ҵ� : �ϳ��� �����尡 �۾��� �Ϸ�Ǹ� ���� �����尡 �۾� �� �� �ִ�. 
		int mydata = data;
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		data = mydata + 1;
	}
}
class PlusThread extends Thread{ //1T�� �����ϸ鼭 �ΰ��� ������
	MyData myData;
	public PlusThread(MyData myData) {
		this.myData=myData;
	}
	@Override
	public void run() {
		myData.pulsData();
		System.out.println(getName()+ "���� ��� : " + myData.data);
	
	
	}
}


public class SynchronizedMethod {

	public static void main(String[] args) {

		//���� ��ü ����
		MyData myData = new MyData();
				
		//1. PlusThread1
		Thread plusThread1 = new PlusThread(myData);
		plusThread1.setName("plusThread1");
		plusThread1.start();
				
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
				
		//2. PlusThread1
		Thread plusThread2 = new PlusThread(myData);
		plusThread2.setName("plusThread2");
		plusThread2.start();
		
		
	}

}
