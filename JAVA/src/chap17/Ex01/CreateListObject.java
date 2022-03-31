package chap17.Ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CreateListObject {

	public static void main(String[] args) {

		//1. List ���� Ŭ������ �����ڸ� ����Ͽ� ��ü ����
		//List�� �������̽� �̹Ƿ� new Ű �ڿ� �� �� ����. ArrayList, Vector, LinkedList ������ Ŭ������ ������ List�� �������ִ�.
		//capacity : �޸��� ���� ũ�⸦ �Ҵ� , �⺻���� 10//ArrayList�� ����� ����Ȯ��(���̵� ��������)
		// size() : �濡 ����� ���� ���� <<========== ���̾ȵ������� 0�̳���
		
		List<Integer> aList1 = new ArrayList<>(); //capacity = 10
		List<Integer> aList2 = new ArrayList<>(); //capacity = 30, �޸��� ���� Ȯ��.
		
		List<Integer> aList3 = new Vector<>();
		List<Integer> aList4 = new Vector<>(30);

		List<Integer> aList5 = new LinkedList<>();
		//List<Integer> aList6 = new LinkedList<>(30); //LinkedList�� ������� �Ҵ��� �ȵȴ�.
		
		//2. Arrays Ŭ������ ���� �޼ҵ带 �̿� �ϴ� ��� : ������ ũ�⸦ �ٲܼ� ����.
				//����, ����, �Ϸ� 24�� <==������ ���� ���� �Ҷ� ���.
		
		List<Integer> aList7 = Arrays.asList(1,2,3,4); // ������ ���� ����
		List<String> aList8 = Arrays.asList("��","ȭ","��","��","��","��","��"); // ������ ���� ����
		aList7.set(1, 7); //set()�޼ҵ� : ������ ���� ���� �Ҷ�, Index 1�� 7�� �Ҵ� �ϰڴ�.
		//aList7.add(5); �����߻� �Ұ���! add()���������� ���� �� �߰� �Ҷ� ���.
		
		aList8.set(0, "��");
		//aList8.add("��"); //�����߻� �߰��ºҰ���
		System.out.println(aList7);
		System.out.println(aList8);
	}

}
