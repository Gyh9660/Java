package Ex;

import java.util.Scanner;
public class Ex08 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int k=0;
		int[] unit = {50000,10000,1000,500,100,50,10,1};
		
		System.out.println("�ݾ��� �Է��Ͻÿ�>>");
		k = sc.nextInt();
		for(int i=0; i<unit.length;i++) {
			System.out.println(unit[i] +"�� ¥��:"+ k/unit[i] + "��");
			k=k-(k/unit[i]*unit[i]);
		}
		sc.close();
	}
}
