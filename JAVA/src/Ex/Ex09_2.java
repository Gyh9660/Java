package Ex;

public class Ex09_2 {

	public static void main(String[] args) {
		
		int[] num = new int[10];
		int sum=0;
		double avg = 0; //���= ��ü���� ���ؼ� sum/���ǰ���
						//����� ����� ���� �ݵ�� double������ ����
		
		System.out.println("������ ������ : ");
		//�迭�� �� �濡 ������ ���� �߻����Ѽ� �Է� : 1~10
		for(int i=0; i<num.length;i++) {
			num[i]= (int)(Math.random()*10+1); // num[0]~num[9]���濡 ����: 1~10
			System.out.print(num[i]+" ");
		}
		System.out.println();
		//�迭�� �� ���� ������ ���� ���ؼ� ��ü ���� ������ ������.
		
		for(int i=0; i<num.length;i++) {
			sum+=num[i]; // sum = sum+num[i];
		}
		avg = (double)sum / num.length; // ��� = ��/ ���� ���� 
		//sum�� double�� ����Ÿ�Ժ�ȯ ��������� ���������� 37->3.7�̾ƴ� 3.0���� ����.
		//�ƴϸ� ���ʿ� sum�� double�� �������൵ �ɵ�?
		System.out.println("����:"+ sum);
		System.out.println("�����:"+avg);
		System.out.println("���� ������ :"+num.length);
	}

}
