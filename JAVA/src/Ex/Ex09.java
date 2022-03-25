package Ex;

public class Ex09 {

	public static void main(String[] args) {
		
		int []arr1 = new int[10];
		for(int i=0; i<arr1.length;i++) {
			arr1[i] = (int)(Math.random()*10+1);
			System.out.print(arr1[i]+ " ");		
		}
		double sum = 0;
		for (int i=0; i<arr1.length;i++) {
			sum+=arr1[i];
		}
		System.out.println();
		System.out.println("평균: "+ sum/arr1.length); //10이아니라 arr1.length로 나누기 arr1.length <<<arr1배열 방의갯수
	}

}
