package chap17.Ex02;

//Vector : ArrayList�� ��� �޼ҵ尡 �����ϰ� ���/������ ����
	//Vector�� ��� �޼ҵ尡 ����ȭ ó���� �Ǿ� �ִ�. ��Ƽ������ ȯ�濡 ���ǵ��� �Ǿ� �ִ�.
	
//�̱� ������ ȯ�� : ArrayList
//��Ƽ ������ ȯ�� : Vector



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class VectoeMethod_1 {

	public static void main(String[] args) {
		// List�� �޼ҵ� : 13�� ������ �޼ҵ�, 
			//1. ArrayList
			//2. Vector
			//3. LinkedList
		
		List<Integer> vector1 = new Vector<Integer>();
		
		//1. add (E element) : ������ ���� ���� �߰��ϱ�.
		vector1.add(3); vector1.add(4); vector1.add(5);
		System.out.println(vector1); 		//�����
		System.out.println(vector1.size());	//���� ����

		//2. add (int index, E element);
		vector1.add(1,6); //���ȣ 1 ���� 6�� �߰� //1���ڸ��� 6���ְ� �ڷ� ��ĭ���и�
		System.out.println(vector1);
		System.out.println(vector1.size());
		
		//3. addAll (�Ǵٸ� ����Ʈ�� ��ü�� �����ؼ� �߰�)
		List<Integer> vector2 = new Vector<Integer>();
		vector2.add(1);
		vector2.add(2);
		
		vector2.addAll(vector1); //vector1�� ����� ���� �����ؼ� vector2�� �߰���. ���������ڷ� �߰�
		System.out.println(vector2);
		
		//4. addAll(int index, �Ǵٸ� ��ü );
		List<Integer> vector3 = new Vector<Integer>();
		vector3.add(1);
		vector3.add(2);
		
		vector3.addAll(1, vector3); //�ڽ��� �����ٰ� �߰� �ٸ� ��ü�� �߰�/ 1���� ���ְ� �ִ������� �ڷιи�
		
		System.out.println(vector3);
		
		//5. set(int index, E element ) : Ư�� ���ȣ�� ���� ����
		vector3.set(1, 5); //1�� ���ȣ��  ���� 5�� ����
		vector3.set(3, 6); //3�� ���ȣ��  ���� 6�� ����
		//vector3.set(4, 7); //4�� ���ȣ��  ���� 7�� ���� => �����߻� (4������ ���⋚����)[0,1,2,3]���ȣ
		//IndexOutOfBoundException
		System.out.println(vector3);
		
		//6. remove (int index) : Ư�� ���ȣ�� ���� ����
		vector3.remove(1); //���ȣ 1�� �濡 �ִ� ���� ���� -> �ڿ��ִ°��� ������ ��ܿ� //�迭�� �����ϸ� null��
		System.out.println(vector3);
		
		//7. remove (Object o ) : ������ ����.
		vector3.remove(new Integer(2)); // aList3 �ȿ� �ִ� 2������ [������ ������ �� �� �ִ�.]
									//�۴�� ǥ�� = �����¾ƴϰ� ������������ �����������ִ� ����, �������
		System.out.println(vector3);
		
		//8. clear() : ��� ����
		vector3.clear();
		System.out.println(vector3);

		//9. isEmpty() : ���� ��� ������ True, ��� ���� ������ false
		System.out.println(vector3.isEmpty());
		
		//10. size() : ���� ����, ���� ����
		System.out.println(vector3.size());
		vector3.add(1); vector3.add(2); vector3.add(3);
		System.out.println(vector3);
		System.out.println(vector3.size());
		System.out.println("==================");
		//11. get(int index) : �ε��� ��ȣ(���ȣ)�� ���� ������(���)
		System.out.println(vector3.get(0));
		System.out.println(vector3.get(1));
		System.out.println(vector3.get(2));
		System.out.println("====================");
		
		System.out.println(vector3); //List�ϋ��� ��ü�� �����ָ� ���� ���
		//12. toArray () : List (����Ʈ) ----> Array(�迭)�� ��ȯ
		Object[] object = vector3.toArray(); //vector3�� object �迭�� return
				//�ٿ� ĳ������ �ʿ��ϴ�.			//�⺻������ toArray()�޼ҵ�� Object Ÿ������ ������ ��
		System.out.println(Arrays.toString(object)); //�迭�ϋ��� Arrays.toString() ���.
		
		System.out.println("===============");
		
		
		//13-1 toArray(T[] t) ====> t[] : Integer�� �ٷ� ĳ����
		Integer[] integer1 = vector3.toArray(new Integer[0]); //[] <==����ũ�� �������� �۰��ϸ� �״�γ���
 		//0�� �ǹ̴�: ����Ʈ�� ����� ������ ���� ��� ����Ʈ�� ����� ���� ������ �´�.
		System.out.println(Arrays.toString(integer1));
		
 		System.out.println("=========================");
 		//13-1 toArray(T[] t) ====> t[] : Integer�� �ٷ� ĳ����
 		Integer[] integer2 = vector3.toArray(new Integer[5]); //[] <== ����ũ�Ⱑ ��ũ�� ���°����� null
 		System.out.println(Arrays.toString(integer2));
 		
	
	}

}
