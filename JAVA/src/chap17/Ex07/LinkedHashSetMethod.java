package chap17.Ex07;

//LinkedHashSet : ���� ������ �� ���� ���� ��ġ ������ �� ���� ���� ��ġ ������ ������.
	//HashSet�� ������ : ��� �޼ҵ尡 �����ϴ�. �ߺ��� ���� �������� �ʴ´� ���ȣ(index)���������� �ʴ´�.
						//�⺻ for������ ����� �� ����.
	//HashSet�� ������ : HashSet�� �Է´�� ��µ��� �ʴ´�. LinkedHashSet�� �Է´�� ��µȴ�.
	
	
import java.util.Arrays;

//Set<E> :�������̽�, ���ȣ�� ����(�ε���), �ߺ��� ���� ���� �� ����.
	// -HashSet			:�ߺ��� ���� ���� �� ����. ���� ������ ������� �������� �ʴ´�.
	// -LinkedHashSet	:�ߺ��� ���� ���� �� ����. ��½� ������� ���.
	// -TreeSet			:����ɶ� ���� ������ �Ǿ ����. ascending(���� ���� ���ĵǾ� �����)0->9,a -> z, �� -> ��
							//���� : descending(���� ���� ����) 9->0,z->a,��->��
										

//����� ���� Ȯ�� : ��Ʈ�� ����Ʈ L
//ã�� / �ٲٱ� : ��Ʈ�� f
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMethod {

	public static void main(String[] args) {

		Set<String> linkedhSet1 = new LinkedHashSet(); //Set�� interface�̹Ƿ� Ÿ�����θ� ����
			//Set�� ���ʸ� Ÿ�Ժ����� wrapper Ŭ������ ����� ���, equlas(), hashCode() �޼ҵ尡 ������ toString() ������
		
		
		
		//1. add(E element); : Set�� ���� �߰�, �ٱ��Ͽ� ���������.
		linkedhSet1.add("��");
		linkedhSet1.add("��");
		linkedhSet1.add("��"); //"��"�� �ߺ� ���� �ȵ�
		System.out.println(linkedhSet1);
		System.out.println(linkedhSet1.toString()); //toString()�޼ҵ尡 �����ǵǾ��ִ�.
	
		System.out.println("=========================");
		
		//2. addAll (�ٸ� set ��ü) : �ڽ��� Set���� �ٸ� Set�� ����� ���� �߰� : �ߺ��� ���� ���ŵ�
 		Set<String> linkedhSet2 = new LinkedHashSet();
 		linkedhSet2.add("��");
 		linkedhSet2.add("��");
 		linkedhSet2.addAll(linkedhSet1); 
		System.out.println(linkedhSet2);//[��, ��, ��] //�Է°� ����� ����
		
		System.out.println("====================");
	
		//3. remove (Object o ) : ������ ����, (List�� ��� ���ȣ�� ����)
		linkedhSet2.remove("��");
		System.out.println(linkedhSet2);
		
		//4.clear() : ��� ����
		linkedhSet2.clear();
		System.out.println(linkedhSet2);
	
		//5.isEmpty() : ��������� true, ������� ������ false
		System.out.println(linkedhSet2.isEmpty());
	
		//6.contains(Object o) : ���� Set�� �����ϸ� true, �׷��� ������ false
		Set<String> linkedhSet3 = new LinkedHashSet<>();
		linkedhSet3.add("��");
		linkedhSet3.add("��");
		linkedhSet3.add("��");
		System.out.println(linkedhSet3); //�Է°� ����� �����ϴ�
		System.out.println(linkedhSet3.contains("��")); //true
		System.out.println(linkedhSet3.contains("��")); //false
		
		//7.size : Set�� ���Ե� ���� ����
		System.out.println(linkedhSet3.size());
		
		System.out.println("============iterator()�� ����� ���=================");
		//8. iterator() : Set �� index�� ������ �ʴ´�. for���� ���ȣ�� �������, �����������, enhanced for���� ��밡��,
							//��ȸ��, Set�� ������ ��ȸ�ϸ鼭 ���.
							//hasNext() : Set���� ���� �����ϸ� true �������� ������ false
							//next() : ���簪�� ����ϰ� ���������� �̵�
	
		Iterator<String> iteratior = linkedhSet3.iterator();
			//Ŭ����<E> ������ü = Set��ü.iterator();
		while (iteratior.hasNext()) {
			System.out.print(iteratior.next()+ " ");
		}
		System.out.println();
		
		System.out.println("================Enhanced for ���� ����ؼ� ���===========");
		
		for ( String k : linkedhSet3) {
			System.out.print(k+ " ");
		}
		System.out.println();
		
		//9. toArray() : set�� ������ �迭�� ������. ObjectŸ������ ����, �ٿ� ĳ������ �ʿ���
		Object[] objArray = linkedhSet3.toArray();
		System.out.println(Arrays.toString(objArray)); //
		for (int i = 0; i<objArray.length;i++) {
			System.out.print(objArray[i]+ " ");
		}
		System.out.println();
		System.out.println("=============================");
		for ( Object k : objArray) { //�ٿ� ĳ������ �ʿ��ϴ�.
			System.out.print(k+ " ");
		}
		System.out.println();
		System.out.println();
		
		
		//10.toArray(T[] t) : �ٷ� �ٿ� ĳ������ ���� ���
		String[] strArray1 = linkedhSet3.toArray(new String[0]); // 0 : ����ũ�⸦ �����մϴ�.
		//���� ũ�Ⱑ ���� ������ ������� �����Ϸ��� ����ũ�⸸ŭ ��������
		
		System.out.println(Arrays.toString(strArray1));
	
	
	
		//11. ���� Set�� ������ ���� ũ�⸦ ũ�� ���� ���� Null�� ��� �� �� �ִ�.
		String[] strArray2 = linkedhSet3.toArray(new String[5]);
		System.out.println(Arrays.toString(strArray2)); //������� null
	
	
	
		Set<Integer> intSet1 = new LinkedHashSet();
		
		intSet1.add(30);
		intSet1.add(50);
		intSet1.add(100);
		intSet1.add(10);
		
		//iterator��� ,Enhanced for���� ����ؼ� ���.
		Iterator<Integer> iterator = intSet1.iterator();
		//iterator���
		System.out.println("===========iterator=========");
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+ " ");
		}
		System.out.println();
	
		System.out.println("========Enhanced For��=========");
		//Enhanced for��
		for(Integer k : intSet1) {
			System.out.print(k+ " ");
		}
		System.out.println();
		
		
		
	}

}
