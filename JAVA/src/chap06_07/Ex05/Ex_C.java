package chap06_07.Ex05;

public class Ex_C {

	public static void main(String[] args) {
		//���� ��Ű���� ������.
		C c = new C(); //���� ��Ű���� �����ϴ� Ŭ����
		//c.company="�Ｚ�ڵ���"; //���ٺҰ� private �ܺ�Ŭ�������� ���� �Ұ�
		c.model = "�ҳ�Ÿ"; //�� ,default
		c.color = "���";  // ���� protected
		c.maxSpeed = 200; // �ִ�ӵ� public
		
		c.print(); //public
		
	}

}
