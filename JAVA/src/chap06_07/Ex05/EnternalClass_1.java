package chap06_07.Ex05;

class B{ //�ܺ� Ŭ���� : public�� �ü� ����. default�� �����Ǿ� �ִ�.
		//�ٸ� ��Ű���� Ŭ���������� ������ �Ұ�,���� ��Ű�� �������� ���� ����
	private int a = 1; //private:���� Ŭ���������� ���
	int b =2;			//default:���� ��Ű������ �ٸ� Ŭ�������� ���� ����
	protected int c= 3;	//protected : default ����+ �ٸ���Ű������ ���� ����(��ӵȰ�츸)
	public int d =4; //public : �ٸ���Ű������ ������ ����
	
	// private < default < protected < public
	
	private void print1 () { // ���� Ŭ������ �����ϴ� �޼ҵ�;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
	}
	
	void print2 () { // ���� Ŭ������ �����ϴ� �޼ҵ�;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
	}
	protected void print3 () { // ���� Ŭ������ �����ϴ� �޼ҵ�;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
	}
	public void print4 () { // ���� Ŭ������ �����ϴ� �޼ҵ�;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
	}
	

	
	
	
	
	
	
}

public class EnternalClass_1 {

	public static void main(String[] args) {

		B b = new B(); //���� Ŭ������ �����ϹǷ� B class�� ������ �� �ִ�.
					//default ���� �����ڰ� class �̸��տ� �Ҵ�
		Bb bb = new Bb(); //public ���� �����ڰ� class �̸��տ� �Ҵ�
						//���� ��Ű�� ������ ����
		
		//���� ��Ű���� �ٸ� Ŭ�������� ����
		
		//�ʵ� ����
		//bb.a = 10; //<�����߻�:������ �Ұ�> private : a�� BbŬ���� �������� ��밡��
		bb.b = 20; //default : ���� ��Ű���� Ŭ�������� ������ ���
		bb.c= 30; //protected : default�� ����, +�ٸ� ��Ű������ ������ �����Ѵ� ��ӵȰ�츸
		bb.d= 40; // public : protected�� ���� + �ٸ���Ű������ ������ ����
		
		//�޼ҵ� ����
		//bb.print1();//<�����߻�:������ �Ұ�> private //Ŭ�������ο����� ȣ��
		bb.print2(); //default
		bb.print3();// protected
		bb.print4();// public
		
	}

}
