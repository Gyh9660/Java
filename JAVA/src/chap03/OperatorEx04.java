package chap03;

public class OperatorEx04 {

	public static void main(String[] args) {
		/*
		 * ���� ������ ( =, +=, -=, *=, /=, >>=, <<=, >>>=)
		 * a = b; <=== �������� ���� ���ʿ� �Ҵ��ض� ��� �ǹ� , ==(����)
		 * a +=b; <== a= a+b; �� ����س�����
		 * a -=b; <== a= a - b;
		 * a *=b; <== a= a * b;
		 * a /=b; <== a= a / b;
		 * a &=b; <== a= a & b;
		 * a |=b; <== a= a | b;
		 * a <<=b; <== a= a << b;
		 * 
		 */
		int value1 = 3;
		value1 = value1 + 3;
		System.out.println(value1);
		System.out.println();
		
		int value2; //�⺻�� �ڷ����� ��� ������ ���� ���� ���� ��� �⺻������ 0�� �Ҵ�
		value2 = 5; //�����ڷ� ���� ��� ������ ���� �Ҵ� ���� ���� ��� �⺻������ NULL�� �Ҵ�
		//��� ǥ��
		
		System.out.println(value2 +=2 ); //value2 =value2 +2 // 5+2=7
		System.out.println(value2 -=2); // value2 =value2 -2 // 7-2=5
		System.out.println(value2 /=2); // value2 =value2 /2 // 5/2=2.5 ������ intŸ���̶� 2�� ����
		value2 = 5; System.out.println(value2 %= 2);
		value2 = 5; System.out.println(value2 |= 2); // 5 = 0101 2 = 0010 OR = 0111 = 7 //value2 = value2 | 2 
		value2 = 5; System.out.println(value2 &= 2); //5 = 0101 2 = 0010 AND = 0000 = 0 //value2 = value2 & 2
		
		value2 = 5; System.out.println(value2 <<= 2); // valur2 = value2 << 2 �������� 2ĭ�̵��ض�
		value2 = 5; System.out.println(value2 >>= 2); // value2 = value2 >> 2 ���������� 2�ڸ��̵��ض�
		value2 = -5; System.out.println(value2 >>>= 2); // value2 = value2 >>> 2 ���������� �̵��ϴµ� ������Ʈ���� �����̵��ض�
		byte value3;
		value3 = -128; System.out.println(value3 >>>= 2);
		
		
	}

}
