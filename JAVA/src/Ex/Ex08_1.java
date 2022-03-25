package Ex;

import java.util.Scanner;

public class Ex08_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		int money= 0; //Scanner로 input받을 돈을 저장하는 변수
		
		System.out.println("금액을 입력하시오 >>");
		money = sc.nextInt();
		
		
		for(int i=0; i<unit.length;i++) {
			System.out.printf("%d원 짜리 : %d개 \n",unit[i],money/unit[i]);
			//System.out.println(unit[i]+"원 짜리 : "+ money/unit[i] + "개");
				money= money-(money/unit[i])*unit[i];
							  //환산한 돈의 갯수(1장) * 50000
				//money= money % unit[i];
						//65536 을 50000으로 나눈 나머지 15536
		}
	sc.close();	
	}

}
