package chap03;

public class OperatorEx01 {

	public static void main(String[] args) {
		int data = 13; //
		
		System.out.println(Integer.toBinaryString(data)); // 2������ ��ȯ 13-> 1101
		System.out.println(Integer.toOctalString(data)); // 8������ ��ȯ 13-> 15
		System.out.println(Integer.toHexString(data)); // 16������ ��ȯ 13-> d
		System.out.println();
		
		System.out.println(Integer.parseInt("1101", 2)); // 2���� 1101�� �������� ��ȯ 1101�ڿ� 2��°��� ���������� �˷��ִ� �κ� 8������ 8���� 16������ 16����
		System.out.println(Integer.parseInt("15", 8)); // 8���� 15�� �������� ��ȯ
		System.out.println(Integer.parseInt("0D", 16)); // 16���� 0D�� �������� ��ȯ
		
		System.out.println("====================");
		
		System.out.println(~3);// ����� ~�� �ϸ�, ���� :0�� �������� ���+1
		System.out.println(~7); //����� +1�ؼ� �����ٿ��ָ� �װ� not (~) �� ���̳���
		
		//�پ��� ���� ǥ��
		System.out.println("===================");
		System.out.println(13);
		System.out.println(0b1101);//0b�� ������ ǥ��
		System.out.println(015); //00�� 8���� ǥ���ε� 0�� ��������
		System.out.println(0x0D);// 0x�� 16���� ǥ��
		System.out.println("==================");
		
		
		
		
	}

}
