package chap15.Ex20;


class DataBox{
	int data ; //���� �ʵ�
	boolean isEmpty= true; // �⺻�� ����
 	
	synchronized void inputData (int data) { //����ȭ �޼ҵ�
		if (!isEmpty) {//false �϶� wait(); ����ȭ ���̳� ����ȭ �޼ҵ忡�� WAITING ���·� ��ȯ
						//data �ʵ��� ���� ������� ������ ��� ��� t2 �����尡 ó���ϵ���
			try {wait();} catch (InterruptedException e) {}
		}
		isEmpty = false ; //Data �ʵ��� ���� �ְ� t2�����尡 ���� ���� �� �ֵ��� false�� �⺻����
		
		this.data=data;
		System.out.println("�Է� ������" + data); //data : �Ű����� ������ ������ data
		notify();
	}
	
	synchronized void ouputData () { //����ȭ �޼ҵ�(��)
		if(isEmpty) {
			try {wait();} catch (InterruptedException e) {} //true�϶� Waiting���·� ����
		}
		isEmpty = true;
		System.out.println("��� ������" + data); //data : �޸𸮿� �ִ� data => this.data ���� this�� ������
		notify(); //inputData() �޼ҵ��� wait()�� �����带 �ƿ��ش�
	}
	
}

public class Watiing_WaitNotiy_2 {

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
