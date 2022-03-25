package chap03;

import java.awt.SystemColor;

public class OperatorEx03 {

	public static void main(String[] args) {

		/*
		 * �� ������( &&, �Ӥ�,^,!)��Ʈ ��Ŷ�� �߻��� (�պκ��� ���� ����� �����Ҽ� ������ �޺κ��� ������ ����)
		 * ��Ʈ ������( & ,��,^,)��Ʈ ��Ŷ�� �߻����� �ʴ´�.
		 * ��Ʈ��Ŷ�� �պκ������� ����������� �ڿ��� �����ʰ� ������ ����
		 */
		
		//1. �� ������ AND (&&) : �� ���� ��� true�϶� ����� true
		
		System.out.println(true && true); // true, ��Ʈ��Ŷ�� �߻����� ����.
		System.out.println(true && false);// false, ��Ʈ ��Ŷ�� �߻����� ����.
		System.out.println(false && true); //false, ��Ʈ ��Ŷ�� �߻���. �տ��� false�� �͹����� and������ �Ѵٸ� �ڴ� ���������� false�� �����⶧���� �޺κ��� ������ ������
		System.out.println(true && (5<3) ); //(5<3)�� false�̱⿡ false�� �߻�
		System.out.println( (5<=5) && (7>2) );//true
		System.out.println( (3<2) && (8<10) );//false ��Ʈ��Ŷ�� �߻���
		
		//OR (||) ������ �ϳ��� true�̸� ����� true
		System.out.println( true || true); //true, ��Ʈ ��Ŷ�� �߻�
		System.out.println(false || (5<3) );
		System.out.println("================");
		
		//XOR (^) : �ΰ��� ������ false, �ٸ��� true
		System.out.println( true ^ true);// false
		System.out.println( false ^ false);// false
		System.out.println( true ^ false);// true
		System.out.println( false ^ true);// true
		System.out.println( ( 5<=5 ) ^ ( 7>2 ) ); //false
		System.out.println("===================");

		//NOT (!) : true �̸� false, false �̸� true
		System.out.println(!true); //false
		System.out.println(!false); //true
		System.out.println(false || !( 5 < 3 ) ); //true
		System.out.println("=================");
		// �� ��Ŷ�� ����ϴ� ���� ( �� �������϶� �߻�, ��Ʈ �������϶��� �߻����� ����.)
		
		int value2 = 3;
		System.out.println(false &&  ++value2 > 6); //�� ��Ŷ�� �߻�, false 
 		System.out.println(value2); // ������� 4�����;������� 3�̳���, �������� &&�����϶� ���� false�� ������ false�ۿ� ������ �ʱ⶧���� �� ��Ŷ�� �߻��Ͽ� ���� ������ �߻������ʰ� ������ �׷��� ���� value2�� �ٽ�������� 4���ƴ� 3�̳���
 		
 		int value3 = 3;
 		System.out.println(false & ++value3 > 6); // ����� false���� �� ��Ŷ�� �߻����� ����(��Ʈ ������ �̱� ������), �׷��� ������ ���� ������ ���������ʾƼ� value3�� ������ 4�� ���ð���.
 		System.out.println(value3); //4������, ���� ���� �� ����Ŷ�� �߻����� �ʾƼ� �������� �ʾұ⶧���� 
		
 		int value4 = 3;
 		System.out.println(true || ++value4 > 6); //���� true �⋚���� ������ true or������ �����ϳ��� true�� ������ true
 		System.out.println(value4);
 		
 		int value5 = 3;
 		System.out.println(true | ++value5 > 6); //true
 		System.out.println(value5);
		
		
		
		
	}

}
