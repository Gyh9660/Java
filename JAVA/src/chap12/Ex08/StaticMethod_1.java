package chap12.Ex08;

// �������̽� ���ο� static Ű�� �� �޼ҵ� : ���� �ڽĿ��� �������� �ٷ� ȣ��

/* interface ���� ���� ���
 * 1. �ʵ� : [public static final] 	[] <== ��������
 * 2. method : 1. [public abstract]  <== �߻� �޼ҵ�(�����ΰ� ���¸޼ҵ�)
 * 				2. [public] default  <== �����ΰ� �ִ� �޼ҵ� (Java 1.8 �̻󿡼� ���Ӱ� ���� ���)
 * 				3. [public] static	<== �����ΰ� �ְ�, ��ü�������� ȣ�� (Java 1.8 �̻󿡼� ���Ӱ� ���� ���)
 * 
 */


interface A {
	static void abc() {		//Java 1.8�̻󿡼� ���Ӱ� �߰��� ���
		System.out.println("A �������̽��� ���� �޼ҵ� abc()");
	}
}



public class StaticMethod_1 {

	public static void main(String[] args) {
		//1. ���� �޼ҵ� ȣ�� (static method) 
		A.abc(); 		// interface �̸����� �ٷ� ȣ�� ����
		
		
	}

}
