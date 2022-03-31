package chap17.Ex04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.SysexMessage;

//ArrayList vs LinkedList
//ArrayList : ���� ���ؼ� index ���� ������ �ִ�. �˻� �ӵ��� ������.
			//���� : �߰����� ���� �߰�/���� �� ���ϰ� ������ ���� �ɸ���.

//LinkedList : �� ���� ���� �յ��� ������� ������ �ִ�. �˻��ÿ� index�� ��ȣ�� �Ҵ�ȴ�.
				//�˻��� ArratList�� ���ؼ� ������
				//����: �߰��� ���� �߰�/������ ���ϰ� �ɸ��� �ʴ´�.

public class ArrayListVSLinkedList {

	public static void main(String[] args) {
	
		//1. �����͸� �߰��ϴ� �ð� ��
		
		List<Integer> aList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		long startTime = 0, endTime=0;
		
		//1-1 Array List���� ������ �߰��ð�
		startTime = System.nanoTime();   //System.nanoTime(): ��ŸƮ �ص��� �ð��������� �յں�
		for(int i =0; i<100000;i++) {
			aList.add(0,i);   // 0��° �濡 ����ؼ� 10������ ����,��� �ڷιи��鼭 ���� �߰�
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList���� ������ �߰� �ð� " + (endTime - startTime)+ "ns");
				//395011400ns
		
		//1-2 LinkedList���� ������ �߰��ð� : ArrayList���� ������
		startTime = System.nanoTime();   //System.nanoTime(): ��ŸƮ �ص��� �ð��������� �յں�
		for(int i =0; i<100000;i++) {
			linkedList.add(0,i);   // 0��° �濡 ����ؼ� 10������ ����,��� �ڷιи��鼭 ���� �߰�
		}
		endTime = System.nanoTime();
		System.out.println("linkedList���� ������ �߰� �ð� " + (endTime - startTime)+ "ns");
				//4504100ns :250�� ����������.
		System.out.println("==================================");
		
		//2. �˻��� ��: ArrayList�� LinkedList���� �� ������
		
		//2-1 ArrayList �˻� �ð� //1407500ns
		startTime = System.nanoTime();
		for (int i =0; i <100000; i++) {
			aList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList���� ������ �˻� �ð� " + (endTime - startTime)+ "ns");
		
		//2-1 LinkedList �˻� �ð� //4206423400ns
		startTime = System.nanoTime();
		for (int i =0; i <100000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList���� ������ �˻� �ð� " + (endTime - startTime)+ "ns");
		
		
		System.out.println("====================================");
		
		//3. ������ ������ ���� �ð� ��. : LinkedList�� �ξ� ������.
		//3-1. ArrayList 384035900ns
		startTime = System.nanoTime();   //System.nanoTime(): ��ŸƮ �ص��� �ð��������� �յں�
		for(int i =0; i<100000;i++) {
			aList.remove(0);   // index 0 ��°�ڸ��� �����մϴ�. ���� ��ܿɴϴ�.
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList���� ������ ���� �ð� " + (endTime - startTime)+ "ns");
		
		//3-2 LinkedList 3655100ns
		
		startTime = System.nanoTime();   //System.nanoTime(): ��ŸƮ �ص��� �ð��������� �յں�
		for(int i =0; i<100000;i++) {
			linkedList.remove(0);   // index 0 ��°�ڸ��� �����մϴ�. ���� ��ܿɴϴ�.
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList���� ������ ���� �ð� " + (endTime - startTime)+ "ns");
		
	}

}
