package Ex;

import java.util.Scanner;

public class Ex11_2 {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		String[] course= {"Java", "C++","HTML5","��ǻ�ͱ���","�ȵ���̵�"};
		int[] score = {95,88,76,62,55};
		
		String name = null; //scanner�� ������ ���ڿ��� �޴� ����
		int i = 0; //���ȣ�� ��� ����
		
		System.out.println("���α׷��� �����Ϸ��� \"�׸�\" �� �Է� �ϼ���."); //"��" �ȿ��� "�� �������Ϸ��� \"\"�� ��� \�� "Ư�����ڸ� ����ϰ�����
		while (true) { //Ư�� ������ �����Ҷ� ���� ��� ���� ���ư�./���ѷ���
			System.out.println("���� �̸� >>> ");
			name = sc.next();      // scanner�� �����̸��� �޾Ƽ� ���� name�� �Ҵ�.
			
			if (name.equals("�׸�")) break; //���� :name�� �������� �̹Ƿ� ==�� ����ϸ� �ȵ�. equals�� ����ؾ���.
			//course�� ������ ���鼭 scanner�� ���� name ������ ���� ������ ���
			for(i=0; i<course.length; i++) {
				if(course[i].equals(name)) {
					System.out.println(course[i] + " ������ : "+ score[i]);
					break;
				}
				//������ ����� ������ �˻��� �ȵȰ���
				if(i == course.length-1) { //i������ ������ ����� ������ �˻��� �ȵȰ��
					System.out.println("���� ����");
				}
				
			}
		}
		sc.close();
		System.out.println("���α׷��� �����մϴ�.");
		
		
		
	}

}
