package chap06_07.Ex06;

import chap06_07.Ex05.C;

public class Ex_C {

	public static void main(String[] args) {
		//�ٸ���Ű���� ������ /public�� ���� /model,color �޸𸮷� ���� �Ұ�
		// model�� color�� setter�� public ���ؼ� �Ҵ��� ���
		C cc = new C(); // �ٸ� ��Ű�� �̹Ƿ� import
			//company, model, color �� �ٸ� ��Ű������ ���� �Ұ�, setter�� ���ؼ� �޸𸮰��� �Ҵ��ϵ��� ����
		cc.maxSpeed = 220; //�ٸ� ��Ű���� Ŭ���������� public, protected(��� ����)
		
		//setter�� ���ؼ� �޸��� ���� �ο�.
		cc.setModel("�׷���");
		cc.setColor("���");
		cc.setMaxSpeed(300);
		
		cc.print();
		
	}

}
