package chap17.Ex06;

import java.util.Arrays;

//Set<E> :인터페이스, 방번호가 없다(인덱스), 중복된 값을 넣을 수 없다.
	// -HashSet			:중복된 값을 넣을 수 없다. 값을 꺼내면 순서대로 꺼내지지 않는다.
	// -LinkedHashSet	:중복돈 값을 넣을 수 없다. 출력시 순서대로 출력.
	// -TreeSet			:저장될때 값이 정렬이 되어서 저장. ascending(오름 차순 정렬되어 저장됨)0->9,a -> z, 가 -> 하
							//참고 : descending(내림 차순 정렬) 9->0,z->a,하->가


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMethod {

	public static void main(String[] args) {

		Set<String> hSet1 = new HashSet(); //Set은 interface이므로 타입으로만 지정
		
		//1. add(E element); : Set에 값을 추가, 바구니에 막집어넣음.
		hSet1.add("가");
		hSet1.add("나");
		hSet1.add("가"); //"가"를 중복 저장 안됨
		System.out.println(hSet1);
		System.out.println(hSet1.toString()); //toString()메소드가 재정의되어있다.
	
		//2. addAll (다른 set 객체) : 자신의 Set에서 다른 Set에 저장된 값을 추가 : 중복된 값은 제거됨
 		Set<String> hSet2 = new HashSet();
		hSet2.add("나");
		hSet2.add("다");
		hSet2.addAll(hSet1);
		System.out.println(hSet2);
	
		//3. remove (Object o ) : 값으로 삭제, (List인 경우 방번호로 삭제)
		hSet2.remove("나");
		System.out.println(hSet2);
		
		//4.clear() : 모두 삭제
		hSet2.clear();
		System.out.println(hSet2);
	
		//5.isEmpty() : 비어있으면 true, 비어있지 않으면 false
		System.out.println(hSet2.isEmpty());
	
		//6.contains(Object o) : 값이 Set에 존재하면 true, 그렇지 않으면 false
		Set<String> hSet3 = new HashSet<>();
		hSet3.add("가");
		hSet3.add("나");
		hSet3.add("다");
		System.out.println(hSet3);
		System.out.println(hSet3.contains("나")); //true
		System.out.println(hSet3.contains("라")); //false
		
		//7.size : Set에 포함된 값의 갯수
		System.out.println(hSet3.size());
		
		System.out.println("============iterator()를 사용한 출력=================");
		//8. iterator() : Set 은 index를 가지지 않는다. for문은 방번호로 값을출력, 사용하지못함, enhanced for문은 사용가능,
							//순회자, Set의 값들을 순회하면서 출력.
							//hasNext() : Set내에 값이 존재하면 true 존재하지 않으면 false
							//next() : 현재값을 출력하고 다음값으로 이동
	
		Iterator<String> iteratior = hSet3.iterator();
			//클래스<E> 참조객체 = Set객체.iterator();
		while (iteratior.hasNext()) {
			System.out.print(iteratior.next()+ " ");
		}
		System.out.println();
		
		System.out.println("================Enhanced for 문을 사용해서 출력===========");
		
		for ( String k : hSet3) {
			System.out.print(k+ " ");
		}
		System.out.println();
		
		//9. toArray() : set의 값들을 배열로 보낸다. Object타입으로 리턴, 다운 캐스팅이 필요함
		Object[] objArray = hSet3.toArray();
		System.out.println(Arrays.toString(objArray)); //
		for (int i = 0; i<objArray.length;i++) {
			System.out.print(objArray[i]+ " ");
		}
		System.out.println();
		System.out.println("=============================");
		for ( Object k : objArray) { //다운 캐스팅이 필요하다.
			System.out.print(k+ " ");
		}
		System.out.println();
		System.out.println();
		
		
		//10.toArray(T[] t) : 바로 다운 캐스팅을 한후 출력
		String[] strArray1 = hSet3.toArray(new String[0]); // 0 : 방의크기를 지정합니다.
		//방의 크기가 실제 값보다 작을경우 컴파일러가 방의크기만큼 지정해줌
		
		System.out.println(Arrays.toString(strArray1));
	
	
	
		//11. 실제 Set의 값보다 방의 크기를 크게 했을 경우는 Null이 들어 갈 수 있다.
		String[] strArray2 = hSet3.toArray(new String[5]);
		System.out.println(Arrays.toString(strArray2)); //빈공간은 null
	
	
	
		Set<Integer> intSet1 = new HashSet();
		
		intSet1.add(30);
		intSet1.add(50);
		intSet1.add(100);
		intSet1.add(10);
		
		//iterator출력 ,Enhanced for문을 사용해서 출력.
		Iterator<Integer> iterator = intSet1.iterator();
		//iterator출력
		System.out.println("===========iterator=========");
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+ " ");
		}
		System.out.println();
	
		System.out.println("========Enhanced For문=========");
		//Enhanced for문
		for(Integer k : intSet1) {
			System.out.print(k+ " ");
		}
		System.out.println();
		
		
		
	}

}
