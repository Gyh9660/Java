package chap14.Ex01;

import java.util.Scanner;

//Error : ���α׷��Ӱ� ������ �� ���� �κ�, OS �߻��ϴ� Error, H/W Error
//Exception : ���� : ���α׷��Ӱ� ������ �� �ִ� �κ�,
	// ���ܰ� �߻� �Ǹ� ���α׷��� ����Ǿ� ������.
	// ���ܰ� �߻� �Ǵ��� ���α׷��� ������� �ʰ� ó��(����ó��)

//ArithemticException: ����� 0���� ������ �߻��ϴ� ����
	//��ǻ�ʹ� ����� 0���� ������� ��� �Ұ�.

public class CheckedException_0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �ϳ��� �Է��ϼ���");
		
		int b = 10;
		while(true) {
		  int a = sc.nextInt();
		  if(a==0) {break;}
		  System.out.println((double)b/a);
		  
		}
		System.out.println("��� �����մϴ�.");
		sc.close();
		
		
		
	}

}
