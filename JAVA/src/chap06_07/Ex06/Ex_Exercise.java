package chap06_07.Ex06;

import java.util.Scanner;

public class Ex_Exercise {
	
	static void math (String...values) {
		int sum = 0;
		double avg;
		int c = 0;
		
		for(int i=0; i<values.length; i++) {
			if(i % 2 == 1) {
			sum += Integer.parseInt(values[i]);
			c++;
			}
		}
		avg = (double) sum/c;
		System.out.println();
		System.out.println("������� �������� �� �հ�: "+sum);
		System.out.println("��߸��� ��� ������ : "+avg);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��� �ο����� ������ �־ �Է�.>>");
		while(true) {
			String num = sc.nextLine();
			String [] array1 = num.split(" ");
		
			if (num.equals("�׸�")) {
				System.out.println("�����մϴ�.");
				break;
			}else {
				System.out.println();
				System.out.println("��� �ο�����");
				for(int i=0; i<array1.length; i++) {
					System.out.print(array1[i]+" ");
				}
			}	
		
			math(array1);
		}
		sc.close();
	}

}
