package chap02;

public class OperationBetweenDataType {

	public static void main(String[] args) {
		//���� �ڷ��� ���� ����
		
		int value1 = 3+5; //int + int ====> int
		int value2 = 8 / 5; // int / int ===> int
		float value3 = 3.0f + 5.0f; // float + float =>float
		double value4 = 8.0  / 5.0; //double / double ==> double
		
		byte data1 = 3; 
		byte data2 = 5;
		
		//byte value5 = data1 + data2; ���� �߻�
		int value5 = data1 + data2; //int���� ���� �ڷ����� ���� ������ ����� int Ÿ������ ��ȯ
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println(value5);
		System.out.println("==================");
		
		//�ٸ� �ڷ��� ���� ����
		
		double value6 = 5 + 3.5; //int + double ---> double ������
		//int value66 = 5 + 3.5; �����߻� (int)(5 + 3.5)���ϸ� ������ ����������, ��Ʈ��ĳ�����Ұ�� �����ڷ����� ū�ڷ����� �����ϸ� ū�ڷ������� �޾������ ���̰�쿡�� int���ƴ϶� double�� float�� �޾��־���� ����.
		int value666 = (int)(5 + 3.5);
		
		double value7 = 5 / 2.0;
		byte data3 = 3;
		short data4 = 5;
		
		//short value88 = data3 +data4; �����߻�
		int value8 = data3 + data4; //int���� ���� ������ Ÿ���� ������ ��� int�� �޾������
		double value9 = data3 + data4; 
		
		System.out.println(value6);
		System.out.println(value666);
		System.out.println(value7);
		System.out.println(value8);
		System.out.println(value9);
		
		System.out.println((int)5.6+3.5);
		System.out.println((int)5.6+(int)3.5);
		System.out.println((int)(5.6+3.5));
		System.out.println(7/4);
		System.out.println((double)3/2);
		System.out.println((double)(3/2));
		
	}

}
