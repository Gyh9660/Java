package chap06_07.Ex02;

import java.util.Scanner;

public class Exampel_FlexibleSize {

	public static void main(String[] args) {

		//[����] : ��ĳ�ʷ� ������ �������� �޾Ƽ� �հ�, ��� ���
		Scanner sc = new Scanner(System.in);
		int a;
		int c=0;
		int d=0;
		double avg;
		String b;
		while(true) {
			System.out.println("������ �Է����ּ���");
			b=sc.next();
			
			if(b.equals("�׸�")) {
				break;
			}else {
			c+=Integer.parseInt(b);
			d++;
			}
		}avg = (double) c/d;
		System.out.println("�հ�� : "+ c);
		System.out.println("����� : "+ avg);
		
	}
	
}
