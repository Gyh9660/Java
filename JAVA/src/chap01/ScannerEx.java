package chap01;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
		System.out.println("�̸�, ����, ����, ü��, ���ſ��θ� ��ĭ���� �и��Ͽ� �Է��� �ּ���.");
		Scanner scanner/*<�̰� ��� �ٸ������� *�ٲܼ����� sc�� �����Ͽ� ����Ҽ��� ����*/ = new Scanner(System.in);
		String name = scanner.next(); //���ڿ��� ��ǲ�޵��� ��//
		System.out.println("�̸��� " + name + ", ");
		String city = scanner.next();
		System.out.println("���ô� " + city + ", ");
		int age = scanner.nextInt(); //�������� ��ǲ�޾Ƽ� �о� ����//
		System.out.println("���̴� " + age + ", ");
		double weight = scanner.nextDouble();
		System.out.println("ü���� " + weight + ", "); //�Ǽ� ���� ��ǲ �޾Ƽ� �о� ����//
		boolean single = scanner.nextBoolean();
		System.out.println("���� ���δ� " + single + "�Դϴ�. "); //������ �о� ���� (��true, ���� false)//
		scanner.close();
	}

}
