package chap17.Ex08;

import java.util.Comparator;
import java.util.TreeSet;

//�̸��� ���̸� �Է½� �̸��� ���� �������� ����ϵ��� �����ϴ�.
//1. Comparable<E> �� comparTo()�޼ҵ� ������
		//������ ��ü ������ �ʿ�
//2. Comparator<E> �� compare() ����
		//������ ��ü�� �������� ����
class Abc{
	String name; 	//<<= �÷��� ���� �÷�. ���� ���� ����: �����ٶ�....��
					//ȫ�浿 , �̼���, ������ ===> ������, �̼��� ,ȫ�浿
	int age;		//����

	public Abc (String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "�̸� : " + name + ", ���� : " + age;
	}

}

class Bcd implements Comparable<Bcd>{
	String name;
	int age;
	
	public Bcd (String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Bcd o) {
	if (this.name.compareTo(o.name)>0) return 1;
	else if (this.name.compareTo(o.name)<0) return -1;
	else return 0;
	}
	
	@Override
	public String toString() {
		return "�̸� : " + name + ", ���� : " + age;
	}
}


public class Ex_TreeSetMethod_3 {

	public static void main(String[] args) {

		TreeSet<Abc> treeSet1 = new TreeSet<Abc>(new Comparator<Abc>() {
			public int compare(Abc o1, Abc o2) {
				if (o1.name.compareTo(o2.name)>0) return 1;
				else if (o1.name.compareTo(o2.name)<0) return -1;
				else return 0;
			}
		});
			
		Abc abc1 = new Abc("ȫ�浿",20);
		Abc abc2 = new Abc("�̼���",16);
		Abc abc3 = new Abc("������",29);
		
		treeSet1.add(abc1);
		treeSet1.add(abc2);
		treeSet1.add(abc3);
		
		System.out.println(treeSet1);
		
		TreeSet<Bcd> treeSet2 = new TreeSet<Bcd>();
		Bcd bcd1 = new Bcd ("ȫ�浿",20);
		Bcd bcd2 = new Bcd ("�̼���",16);
		Bcd bcd3 = new Bcd ("������",29);
		
		treeSet2.add(bcd1);
		treeSet2.add(bcd2);
		treeSet2.add(bcd3);
		
		System.out.println(treeSet2);
	}

}
