package Ex;

import java.util.Scanner;

public class Ex12_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str[] = {"����", "����", "��"};
		String User,Com; //User ����� ����(��ĳ�ʷ� ��ǲ)
						// Com ��ǻ�Ͱ� ����(���� �߻���(Math.random()�� ����ؼ� ��ǲ)
		int n; //��ǻ�Ͱ� ���� ( 0 (����), 1(����), 2(��))
		System.out.println("��ǻ�Ϳ� \'���� ���� ��\' ������ �մϴ�.");
		
		do {
			System.out.println("���� ���� �� !! >>>");
			User = sc.next(); //�����(�����)�� ���°� :��ǲ
			if ( User.equals("�׸�")) break;	
			
			n = (int)(Math.random()*3); //��ǻ�Ͱ� ���� �� : 0, 1, 2
			Com = str[n]; 				//��ǻ�Ͱ� ���°� : 0(����), 1(����), 2(��)
			
			//����ڰ� �����϶� ?
			if (User.equals("����")) {
				if(Com.equals("����")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�����ϴ�.");
				}else if(Com.equals("����")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�����ϴ�.");
				}else if(Com.equals("��")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�̰���ϴ�.");
				}
				// ����ڰ� �����ϋ� ?				
			} else if (User.equals("����")) {
				if(Com.equals("����")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�̰���ϴ�.");
				}else if(Com.equals("����")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�����ϴ�.");
				}else if (Com.equals("��")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�����ϴ�.");
				}
				// ����ڰ� ���ϋ� ?
			} else if(User.equals("��")) {
				if (Com.equals("����")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�����ϴ�.");
				}else if(Com.equals("����")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�̰���ϴ�.");
				}else if(Com.equals("��")) {
					System.out.println("����� : "+User+"\n��ǻ�� : "+Com+"\n�����ϴ�.");
				}
			}
			
			
			
			
		}while (true);
		
		
		
		sc.close();
		System.out.println("���α׷��� ���� �մϴ�.");
		/*int k = (int)(Math.random()*3); //0, 1, 2 : k�� ��
			//Math.random() : 0.000000xxx ~ 0.999999xx
		System.out.println(k);
		 */
	}

}
