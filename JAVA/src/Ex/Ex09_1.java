package Ex;

public class Ex09_1 {

	public static void main(String[] args) {

		double c =(double) Math.random(); // ���� �߻���(������ ���� �ڵ����� �߻�
			//0.000000xxx~0.999999xxx <=== ������ ������ ���� �߻���Ŵ
		int d = (int)(Math.random()*10); // 0~9 ������ ������ ���� ����
		int e = (int)(Math.random()*10+1); // 1~10 ������ ������ ���� ����
		System.out.println(c);
		System.out.println("0���� 9������ �A���Ѱ�:"+d);
		System.out.println("1���� 10������ �����Ѱ�:"+e);
		// 1���� 100������ ������ �߻���Ŵ
		int f = (int)(Math.random()*100+1);
		System.out.println("1���� 100������ �����Ѱ�:"+f);
		
		int[] a = new int[10];
		int i;
		for (i=0; i<a.length;i++) {
			a[i] = (int)(Math.random()*10+1);
			System.out.print(a[i]+ " ");
			
		}
		double sum=0;
		for(i=0; i<a.length;i++) {
			sum+=a[i];
		}
			System.out.println();
			System.out.println(sum/i); //i���ƴ϶� a.length�� �ص���. �׷�����i�� �ۿ����� �����൵�ɵ�?
	}

}
