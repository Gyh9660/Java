package Ex;
import java.util.Scanner;
public class Ex12 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str[]= {"����","����","��"};
		String User,Com;
		int n;
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");
		while(true) {
			System.out.println("���� ���� �� !");
			User =sc.next();
			if(User.equals("�׸�"))break;
				n= (int)(Math.random()*3);
				Com=str[n];
			if(User.equals("����")) {
				if(str[n].equals("����")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �����ϴ�.");
				}else if(str[n].equals("����")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �����ϴ�.");
				}else if(str[n].equals("��")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �̰���ϴ�.");
				}
			}if(User.equals("����")) {
				if(str[n].equals("����")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �̰���ϴ�.");
				}else if(str[n].equals("����")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �����ϴ�.");
				}else if(str[n].equals("��")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �����ϴ�.");
				}
			}if(User.equals("��")) {
				if(str[n].equals("����")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �����ϴ�.");
				}else if(str[n].equals("����")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �̰���ϴ�.");
				}else if(str[n].equals("��")) {
					System.out.println("����� : "+User + ", ��ǻ�� : "+Com+" �����ϴ�.");
				}
			}
		
		}
		System.out.println("������ �����մϴ�..");
		sc.close();
	}
	

}
