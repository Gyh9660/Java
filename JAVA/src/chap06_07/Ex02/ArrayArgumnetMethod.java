package chap06_07.Ex02;

import java.util.Arrays;

public class ArrayArgumnetMethod {
	
	// static�� �����鼭 ���� Ŭ������ �����ϴ� �޼ҵ� :�޼ҵ� �̸����� ȣ���� ����
	//publicŰ�� �ٸ���Ű������ ���� �����ϵ��� ����: 
	//����������(public, protected,default,private)
	//���������ڰ� �����Ǿ������� : default (���� ��Ű������ ���� �����ϵ��� ����)
	
	static void printArray (int[] a) {  // ��ü�������� �ٷ� ȣ�Ⱑ��
		System.out.println("===========Arrays.toString()�� ���=======");
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		
		System.out.println("========for��=========");
		//for���� ����ؼ� ���
		
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		
		System.out.println("========���� for������ ���=========");
		// enhanced for ���� ����ؼ� ���
		for (int k : a) {
			System.out.print(k+" ");
		}
		System.out.println();
		
		
	}
	
	public static void main(String[] args) {
		//�迭�� �Ű� ������ ������ �޼ҵ� ȣ��
		
		int [] a= new int[] {1,2,3}; // �迭������ �����ϰ� ���� ������ 
		
		printArray (a); // �޼ҵ�ȣ��� �迭���� �Է�
		
		printArray (new int[] {4,5,6,7,8});
		
		//printArray ({1,2,3}); // �����߻�
		
		
	}

}
