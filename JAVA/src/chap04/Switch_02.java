package chap04;



import java.util.Scanner;

public class Switch_02 {
	
	
			public static void main(String[] args) {
				System.out.println("operatior�� �Է��� �ּ���.");
				Scanner sc = new Scanner(System.in);
				char operator = sc.next().charAt(0);
				
				int num1 = 10;
				int num2 = 2;
				
				int result = 0;
				
				
				switch (operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				default:
					System.out.println("������ �����Դϴ�.");
					sc.close(); //���Ͼտ����� �ѹ� ������ ������ �������ͼ� ����Ǳ⋚���� ���Ͼտ��� �ѹ��������
					return;
				}
				System.out.println("��� ���� :" + result + "�Դϴ�.");
				
				sc.close(); //��ĳ��Ŭ��� ���θ޼ҵ峡�����ѹ�
	}

}
