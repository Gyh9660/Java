package chap17.Ex03;

//Vector : ArrayList�� ��� �޼ҵ尡 �����ϰ� ���/������ ����
	//Vector�� ��� �޼ҵ尡 ����ȭ ó���� �Ǿ� �ִ�. ��Ƽ������ ȯ�濡 ���ǵ��� �Ǿ� �ִ�.
	
//�̱� ������ ȯ�� : ArrayList
//��Ƽ ������ ȯ�� : Vector

//LinkerList vs ArrayList ������



import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class LinkedListMethod_1 {

	public static void main(String[] args) {
		// List�� �޼ҵ� : 13�� ������ �޼ҵ�, 
			//1. ArrayList
			//2. Vector
			//3. LinkedList
		
		List<Integer> linkedList1 = new LinkedList<Integer>();
		
		//1. add (E element) : ������ ���� ���� �߰��ϱ�.
		linkedList1.add(3); linkedList1.add(4); linkedList1.add(5);
		System.out.println(linkedList1); 		//�����
		System.out.println(linkedList1.size());	//���� ����

		//2. add (int index, E element);
		linkedList1.add(1,6); //���ȣ 1 ���� 6�� �߰� //1���ڸ��� 6���ְ� �ڷ� ��ĭ���и�
		System.out.println(linkedList1);
		System.out.println(linkedList1.size());
		
		//3. addAll (�Ǵٸ� ����Ʈ�� ��ü�� �����ؼ� �߰�)
		List<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.add(1);
		linkedList2.add(2);
		
		linkedList2.addAll(linkedList1); //linkedList1�� ����� ���� �����ؼ� linkedList2�� �߰���. ���������ڷ� �߰�
		System.out.println(linkedList2);
		
		//4. addAll(int index, �Ǵٸ� ��ü );
		List<Integer> linkedList3 = new LinkedList<Integer>();
		linkedList3.add(1);
		linkedList3.add(2);
		
		linkedList3.addAll(1, linkedList3); //�ڽ��� �����ٰ� �߰� �ٸ� ��ü�� �߰�/ 1���� ���ְ� �ִ������� �ڷιи�
		
		System.out.println(linkedList3);
		
		//5. set(int index, E element ) : Ư�� ���ȣ�� ���� ����
		linkedList3.set(1, 5); //1�� ���ȣ��  ���� 5�� ����
		linkedList3.set(3, 6); //3�� ���ȣ��  ���� 6�� ����
		//linkedList3.set(4, 7); //4�� ���ȣ��  ���� 7�� ���� => �����߻� (4������ ���⋚����)[0,1,2,3]���ȣ
		//IndexOutOfBoundException
		System.out.println(linkedList3);
		
		//6. remove (int index) : Ư�� ���ȣ�� ���� ����
		linkedList3.remove(1); //���ȣ 1�� �濡 �ִ� ���� ���� -> �ڿ��ִ°��� ������ ��ܿ� //�迭�� �����ϸ� null��
		System.out.println(linkedList3);
		
		//7. remove (Object o ) : ������ ����.
		linkedList3.remove(new Integer(2)); // linkedList3 �ȿ� �ִ� 2������ [������ ������ �� �� �ִ�.]
									//�۴�� ǥ�� = �����¾ƴϰ� ������������ �����������ִ� ����, �������
		System.out.println(linkedList3);
		
		//8. clear() : ��� ����
		linkedList3.clear();
		System.out.println(linkedList3);

		//9. isEmpty() : ���� ��� ������ True, ��� ���� ������ false
		System.out.println(linkedList3.isEmpty());
		
		//10. size() : ���� ����, ���� ����
		System.out.println(linkedList3.size());
		linkedList3.add(1); linkedList3.add(2); linkedList3.add(3);
		System.out.println(linkedList3);
		System.out.println(linkedList3.size());
		System.out.println("==================");
		//11. get(int index) : �ε��� ��ȣ(���ȣ)�� ���� ������(���)
		System.out.println(linkedList3.get(0));
		System.out.println(linkedList3.get(1));
		System.out.println(linkedList3.get(2));
		System.out.println("====================");
		
		System.out.println(linkedList3); //List�ϋ��� ��ü�� �����ָ� ���� ���
		//12. toArray () : List (����Ʈ) ----> Array(�迭)�� ��ȯ
		Object[] object = linkedList3.toArray(); //linkedList3�� object �迭�� return
				//�ٿ� ĳ������ �ʿ��ϴ�.			//�⺻������ toArray()�޼ҵ�� Object Ÿ������ ������ ��
		System.out.println(Arrays.toString(object)); //�迭�ϋ��� Arrays.toString() ���.
		
		System.out.println("===============");
		
		
		//13-1 toArray(T[] t) ====> t[] : Integer�� �ٷ� ĳ����
		Integer[] integer1 = linkedList3.toArray(new Integer[0]); //[] <==����ũ�� �������� �۰��ϸ� �״�γ���
 		//0�� �ǹ̴�: ����Ʈ�� ����� ������ ���� ��� ����Ʈ�� ����� ���� ������ �´�.
		System.out.println(Arrays.toString(integer1));
		
 		System.out.println("=========================");
 		//13-1 toArray(T[] t) ====> t[] : Integer�� �ٷ� ĳ����
 		Integer[] integer2 = linkedList3.toArray(new Integer[5]); //[] <== ����ũ�Ⱑ ��ũ�� ���°����� null
 		System.out.println(Arrays.toString(integer2));
 		
	
	}

}
