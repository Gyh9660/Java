package Ex;

public class Ex09_1 {

	public static void main(String[] args) {

		double c =(double) Math.random(); // 난수 발생기(임의의 수를 자동으로 발생
			//0.000000xxx~0.999999xxx <=== 범위의 임의의 값을 발생시킴
		int d = (int)(Math.random()*10); // 0~9 까지의 랜덤한 값을 생성
		int e = (int)(Math.random()*10+1); // 1~10 까지의 랜덤한 값을 생성
		System.out.println(c);
		System.out.println("0부터 9까지의 랟넘한값:"+d);
		System.out.println("1부터 10까지의 랜덤한값:"+e);
		// 1부터 100까지의 난수를 발생시킴
		int f = (int)(Math.random()*100+1);
		System.out.println("1부터 100까지의 랜덤한값:"+f);
		
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
			System.out.println(sum/i); //i가아니라 a.length로 해도됨. 그럴경우는i를 밖에선언 안해줘도될듯?
	}

}
