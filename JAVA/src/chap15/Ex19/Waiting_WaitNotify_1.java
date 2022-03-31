package chap15.Ex19;

//Waiting :
	//a[��ü��].join() : �ڽ��� ������� waiting�����̰� a��� ��ü���� CPU�� �Ҵ� (RUNNABLE) 
			//a��ü�� ������ �Ϸ�Ǹ� �ڽ��� �����尡 (RUNNABLE)�� �̵�
		//�ڽ� �������� ó���ҳ����� �ٸ��������� ����� �޾Ƽ� ó���ؾ� �� ���
	//wait(),notify(),notifyAll() <== ����ȭ �������� ��밡��
	//  -wait() ����ȭ��(�޼ҵ�) ������ wait() �޼ҵ带 ������  Waiting ���·� ����.
	//  -notify(),notifyAll()�� wait() �޼ҵ带 �ƿ���. 
			//===>�ݵ�� �ٸ� �����忡�� �����ټ� �ִ�.

class DataBox{
	int data ; //���� �ʵ�
	
	synchronized void inputData (int data) { //����ȭ �޼ҵ�
		this.data=data;
		System.out.println("�Է� ������" + data); //data : �Ű����� ������ ������ data
		
	}
	
	synchronized void ouputData () { //����ȭ �޼ҵ�(��)
		System.out.println("��� ������" + data); //data : �޸𸮿� �ִ� data => this.data ���� this�� ������

	}
	
}

public class Waiting_WaitNotify_1 {

	public static void main(String[] args) {

		DataBox dataBox = new DataBox();
		
		//ù��° ������ : ���� ��ü�� ���� �ִ� ������
		Thread t1 = new Thread() { //�͸� ����Ŭ����
			@Override
			public void run() {
				for (int i=1; i<9; i++) {
					dataBox.inputData(i);
				}
			}
		};
		
		//�ι�° ������ : ���� ��ü�� ���� ���� �о� ���� �޼ҵ�
		Thread t2 = new Thread() { //�͸� ����Ŭ����
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
