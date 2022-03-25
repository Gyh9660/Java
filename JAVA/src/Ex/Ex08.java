package Ex;

import java.util.Scanner;
public class Ex08 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int k=0;
		int[] unit = {50000,10000,1000,500,100,50,10,1};
		
		System.out.println("금액을 입력하시오>>");
		k = sc.nextInt();
		for(int i=0; i<unit.length;i++) {
			System.out.println(unit[i] +"원 짜리:"+ k/unit[i] + "개");
			k=k-(k/unit[i]*unit[i]);
		}
		sc.close();
	}
}
