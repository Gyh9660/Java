package chap04;

public class Ex03_For {

	public static void main(String[] args) {

		//For �⺻ �۵�
		
		int a; // ���� ���� . ��� �ۿ��� ����� ����, ����(0), �ʱⰪ (x)
		for ( a = 0; a < 5 ; a++) {
			System.out.print(a+" "); //
		}

		System.out.println( );
		System.out.println("��� �ۿ��� ��� : " + a);
		System.out.println("=================");
		
		for (int b=0; b<=10; b++) {
			System.out.println(b);
		}
		//System.out.println(b); //���� ������ for�� �������� ��ȿ��.
		System.out.println("===============");
		int c;
		for ( c=10; c>0; c--) {
			System.out.println(c);
		}
		
		System.out.println("==================");
		//2�� ��� ��� ( i+=2 ==> i= i+2)
		for (int i=0; i<100; i+=2) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("==================");
		/* for�� ������ �ʱⰪ�� �������� ���� ������ �Ҵ� �� �� �ִ�.
		 * 
		 */
		
		for (int i=0, j=0; i<10; i++ , j++) {
			System.out.println(i +"*" +j+":"+(i * j)+"  " );
		}
		System.out.println("==================");
		
		// * for���� ����ؼ� 1���� 100���� *���� ����� ������.
		int s=1;
		for (int i=1; i<=10; i++) {
			s*=i; //s= s*i
		}
		System.out.println(s);
		// for ���� ����ؼ� 1���� 100���� ���� ���� ���
		
		int sum =0;
		for (int i=1; i<=100; i++) {
			sum+=i;
		}
		System.out.println(sum);
		
		int o = 0;
		for (int i=0; i<=100; i+=2) {
			o+=i;
		}
		System.out.println(o);
		System.out.println("=======������ ���============");
		/* ���� for �� : 1�ܺ��� �����ؼ� 9�ܱ��� ������ ���
		 * 
		 */
		
		for ( int i = 1; i<=9; i++) { // i: ���� ���
			for ( int j = 1; j<=9; j++) {
				System.out.println( i + " * " + j + " = "  + (i * j));
			}
		System.out.println("=====================");
			}
		
		//for������ ���ѷ��� �߻�, ������ ���� ���
		/*for ( int i = 0;; i++) {
		*	System.out.print(i + " "); // 0, 1 , 2......
		}
		*/
		
		/*for (;;) {
			System.out.println("���� ����");
		}
		*/
		
		System.out.println("======================");
		
		//���� ���� Ż��
		
		for ( int i = 0; ; i++ ) {
			
			if ( i > 100) {
				break;   // break�� �ɾ��ָ� ���ѷ����� ������ ���
			}
			System.out.println(i);
		}
		
		/* for ���� ����ؼ�  1���� 1000���� 4�� ����� ���Ѱ�/ ��հ� double����*/
		
		int num = 0;
		for (int i=0; i<=1000; i+=4) {
			num+=i;
		}
		double y = 1000/4;
		System.out.println(num);
		double avg = (num/y);
		System.out.println(avg);
		System.out.println("1���� 1000���� 4�� ������� :"  + num +" " + "��� :" +  avg );
		
		double sum1 =0; //���� ���� �����ϴ� ����
		int j =0; //4�� ����� ī��Ʈ �ϴ� ����
		for ( int i = 1; i<=1000; i++) {
			if ( i % 4 == 0 ) {
				sum1 += i; // sum = sum + i 4�� ����� ����
				j++;
			}
		}
		System.out.println("���� :" + sum1 );
		System.out.println("��� :" + (sum1/j));
		
		
	}

}
