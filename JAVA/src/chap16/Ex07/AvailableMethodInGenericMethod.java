package chap16.Ex07;

//���׸� �޼ҵ� ���ο��� ��� ������ �޼ҵ� : Object Ŭ������ �޼ҵ常 ��� �����ϴ�.

class A{
	public <T> void method(T t) {
		//System.out.println(t.length());		//t.length() : String Ŭ�������� ���ڼ��� ��������
												//���Ұ� //�����߻�
		System.out.println(t.equals("�ȳ�"));  	//t.equals�� ObjectŬ������ �޼ҵ�� ��밡��
	}		
	public <T extends Object> void method2 (T t){ //�׳� T��� �����ϸ� extends  Object �� �����Ǿ��� T [extends Object]
		System.out.println("�ݰ����ϴ�."); //��� �����ϴ�. ObjectŬ������ �޼ҵ常 ��밡���ϴ�
		//System.out.println(t.);
		
	}
	public <T extends String> void method3 (T t) {
		System.out.println(t.length());
		//System.out.println(t.);
	}
}

public class AvailableMethodInGenericMethod {

	public static void main(String[] args) {
		A a = new A();
		a.<String>method("�ȳ�");
		
		
		
	}

}
