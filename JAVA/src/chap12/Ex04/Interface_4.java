package chap12.Ex04;

//�������̽� ��ӽ� �ڽ� Ŭ���� ���� ������ ���� <<�߿�>>
	//�������̽��� �޼ҵ带 ���� �Ҷ� �ݵ�� public ���������ڸ� �����ؾ��Ѵ�.
interface A {
	public abstract void abc();
	
}
class F implements A{ //F Ŭ������ �ϼ��� �޼ҵ尡 �����Ǿ� �־�� �Ѵ�.
	public void abc() {
		
	}
}
interface B {
	void abc();
	
}
class C implements A {
	public void abc() { //A�������̽��� abc() �� �������̵� �ؼ� ������ �޼ҵ�
				//�ڽ��� �θ𺸴� ���������ڰ� ���ų� ���о�� �Ѵ�.
	}
}
class D implements B{
	public void abc() { //�������̽��� �޼ҵ带 �����Ҷ��� �ݵ�� public ���� �����ڸ� ����ؾ� �Ѵ�.
		
	}
}

class E implements B{
	
	public void abc() {
		
	}
}

public class Interface_4 {

	public static void main(String[] args) {

		
		
		
		
		
	}

}
