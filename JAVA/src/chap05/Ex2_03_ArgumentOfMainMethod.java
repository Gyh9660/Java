package chap05;

public class Ex2_03_ArgumentOfMainMethod {
	public static void main(String[] ar) { //���� �޼ҵ�[�Լ�]
		//�޼ҵ��� �⺻ ����
		/*
		 *void main((String[] args){ //void : ���ϰ��� ������ ����.\\		
		 *							//main : �޼ҵ��
		 *							//(��ǲ �Ű�����)
		 *		�޼ҵ带 ȣ��� ������ �ڵ�;
		 */
		
	String a = ar[0]; // "�ȳ��ϼ���" : ���ڿ� ����
	String b = ar[1]; // 3 : ����
	String c = ar[2];; // 3.8 : �Ǽ�
	
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
	
	
	 System.out.println("=============");
	 
	//main method�� ���ڰ����� ������ �Ǽ��� �Ѱ� �ٶ� String���� ��ȯ 
	 System.out.println(b + 1); // 31 ==> StringŸ���̱� ������
	 System.out.println(c + 1); // 3.81 ���ڿ� ����
	
	 System.out.println("=============");
	//String �� ������ ���� ������ ��ȯ�ؼ� ����
	 
	 int d = Integer.parseInt(b); //b(String)===>IntegerŸ������ ��ȯ
	double e = Double.parseDouble(c); //c(String) ===> Double ������ ��ȯ
	
	System.out.println(d + 1); // 4
	System.out.println(e + 1); // 4.8 ���ϱ�
	
	
	
	}
	
                                                                                                                                                                                                                                  
}
