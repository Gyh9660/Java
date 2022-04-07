package chap17.Ex08;

import java.util.Comparator;
import java.util.TreeSet;

//이름과 나이를 입력시 이름을 오름 차순으로 출력하도록 구현하다.
//1. Comparable<E> 의 comparTo()메소드 재정의
		//기존의 객체 수정이 필요
//2. Comparator<E> 의 compare() 구현
		//기존의 객체를 수정없이 구현
class Abc{
	String name; 	//<<= 컬럼이 정렬 컬럼. 오름 차순 정렬: 가나다라....하
					//홍길동 , 이순신, 강감찬 ===> 강감찬, 이순신 ,홍길동
	int age;		//나이

	public Abc (String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age;
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
		return "이름 : " + name + ", 나이 : " + age;
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
			
		Abc abc1 = new Abc("홍길동",20);
		Abc abc2 = new Abc("이순신",16);
		Abc abc3 = new Abc("강감찬",29);
		
		treeSet1.add(abc1);
		treeSet1.add(abc2);
		treeSet1.add(abc3);
		
		System.out.println(treeSet1);
		
		TreeSet<Bcd> treeSet2 = new TreeSet<Bcd>();
		Bcd bcd1 = new Bcd ("홍길동",20);
		Bcd bcd2 = new Bcd ("이순신",16);
		Bcd bcd3 = new Bcd ("강감찬",29);
		
		treeSet2.add(bcd1);
		treeSet2.add(bcd2);
		treeSet2.add(bcd3);
		
		System.out.println(treeSet2);
	}

}
