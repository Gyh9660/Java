package chap04;

public class For1_1000 {

	public static void main(String[] args) {
	
		int num = 0;
		for (int i=0; i<=1000; i+=4) {
			num+=i;
		}
		double y = 1000/4;
		System.out.println(num);
		double avg = (num/y);
		System.out.println(avg);
		System.out.println("1���� 1000���� 4�� ������� :"  + num +" " + "��� :" +  avg );
		double sum = 0;
		int p = 0;
		for (int j = 1; j<=1000; j++) {
			if (j % 4 ==0) {
				sum+=j;
				p++;
			}
		}
		System.out.println(sum);
		System.out.println(p);
		System.out.println(sum/p);
		
	}
	

}
