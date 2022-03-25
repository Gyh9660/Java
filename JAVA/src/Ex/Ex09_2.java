package Ex;

public class Ex09_2 {

	public static void main(String[] args) {
		
		int[] num = new int[10];
		int sum=0;
		double avg = 0; //평균= 전체방을 합해서 sum/방의갯수
						//평균을 계산할 떄는 반드시 double형으로 지정
		
		System.out.println("랜덤한 정수들 : ");
		//배열의 각 방에 임의의 수를 발생시켜서 입력 : 1~10
		for(int i=0; i<num.length;i++) {
			num[i]= (int)(Math.random()*10+1); // num[0]~num[9]각방에 난수: 1~10
			System.out.print(num[i]+" ");
		}
		System.out.println();
		//배열의 각 방의 랜덤한 값을 더해서 전체 방의 갯수로 나눈다.
		
		for(int i=0; i<num.length;i++) {
			sum+=num[i]; // sum = sum+num[i];
		}
		avg = (double)sum / num.length; // 평균 = 합/ 방의 갯수 
		//sum을 double로 강제타입변환 시켜줘야함 하지않으면 37->3.7이아닌 3.0으로 나옴.
		//아니면 애초에 sum을 double로 선언해줘도 될듯?
		System.out.println("합은:"+ sum);
		System.out.println("평균은:"+avg);
		System.out.println("방의 갯수는 :"+num.length);
	}

}
