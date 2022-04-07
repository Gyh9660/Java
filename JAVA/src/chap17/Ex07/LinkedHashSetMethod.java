package chap17.Ex07;

//LinkedHashSet : 값의 정보에 내 앞의 값의 위치 정보와 내 뒤의 값의 위치 정보를 가진다.
	//HashSet과 공통점 : 모든 메소드가 동일하다. 중복된 값을 저장하지 않는다 방번호(index)값을가지지 않는다.
						//기본 for문으로 출력할 수 없다.
	//HashSet과 차이점 : HashSet은 입력대로 출력되지 않는다. LinkedHashSet은 입력대로 출력된다.
	
	
import java.util.Arrays;

//Set<E> :인터페이스, 방번호가 없다(인덱스), 중복된 값을 넣을 수 없다.
	// -HashSet			:중복된 값을 넣을 수 없다. 값을 꺼내면 순서대로 꺼내지지 않는다.
	// -LinkedHashSet	:중복돈 값을 넣을 수 없다. 출력시 순서대로 출력.
	// -TreeSet			:저장될때 값이 정렬이 되어서 저장. ascending(오름 차순 정렬되어 저장됨)0->9,a -> z, 가 -> 하
							//참고 : descending(내림 차순 정렬) 9->0,z->a,하->가
										

//단축기 정보 확인 : 컨트롤 쉬프트 L
//찾기 / 바꾸기 : 컨트롤 f
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMethod {

	public static void main(String[] args) {

		Set<String> linkedhSet1 = new LinkedHashSet(); //Set은 interface이므로 타입으로만 지정
			//Set의 제너릭 타입변수로 wrapper 클래스를 사용할 경우, equlas(), hashCode() 메소드가 재정의 toString() 재정의
		
		
		
		//1. add(E element); : Set에 값을 추가, 바구니에 막집어넣음.
		linkedhSet1.add("가");
		linkedhSet1.add("나");
		linkedhSet1.add("가"); //"가"를 중복 저장 안됨
		System.out.println(linkedhSet1);
		System.out.println(linkedhSet1.toString()); //toString()메소드가 재정의되어있다.
	
		System.out.println("=========================");
		
		//2. addAll (다른 set 객체) : 자신의 Set에서 다른 Set에 저장된 값을 추가 : 중복된 값은 제거됨
 		Set<String> linkedhSet2 = new LinkedHashSet();
 		linkedhSet2.add("나");
 		linkedhSet2.add("다");
 		linkedhSet2.addAll(linkedhSet1); 
		System.out.println(linkedhSet2);//[나, 다, 가] //입력과 출력이 동일
		
		System.out.println("====================");
	
		//3. remove (Object o ) : 값으로 삭제, (List인 경우 방번호로 삭제)
		linkedhSet2.remove("나");
		System.out.println(linkedhSet2);
		
		//4.clear() : 모두 삭제
		linkedhSet2.clear();
		System.out.println(linkedhSet2);
	
		//5.isEmpty() : 비어있으면 true, 비어있지 않으면 false
		System.out.println(linkedhSet2.isEmpty());
	
		//6.contains(Object o) : 값이 Set에 존재하면 true, 그렇지 않으면 false
		Set<String> linkedhSet3 = new LinkedHashSet<>();
		linkedhSet3.add("가");
		linkedhSet3.add("나");
		linkedhSet3.add("다");
		System.out.println(linkedhSet3); //입력과 출력이 동일하다
		System.out.println(linkedhSet3.contains("나")); //true
		System.out.println(linkedhSet3.contains("라")); //false
		
		//7.size : Set에 포함된 값의 갯수
		System.out.println(linkedhSet3.size());
		
		System.out.println("============iterator()를 사용한 출력=================");
		//8. iterator() : Set 은 index를 가지지 않는다. for문은 방번호로 값을출력, 사용하지못함, enhanced for문은 사용가능,
							//순회자, Set의 값들을 순회하면서 출력.
							//hasNext() : Set내에 값이 존재하면 true 존재하지 않으면 false
							//next() : 현재값을 출력하고 다음값으로 이동
	
		Iterator<String> iteratior = linkedhSet3.iterator();
			//클래스<E> 참조객체 = Set객체.iterator();
		while (iteratior.hasNext()) {
			System.out.print(iteratior.next()+ " ");
		}
		System.out.println();
		
		System.out.println("================Enhanced for 문을 사용해서 출력===========");
		
		for ( String k : linkedhSet3) {
			System.out.print(k+ " ");
		}
		System.out.println();
		
		//9. toArray() : set의 값들을 배열로 보낸다. Object타입으로 리턴, 다운 캐스팅이 필요함
		Object[] objArray = linkedhSet3.toArray();
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
		String[] strArray1 = linkedhSet3.toArray(new String[0]); // 0 : 방의크기를 지정합니다.
		//방의 크기가 실제 값보다 작을경우 컴파일러가 방의크기만큼 지정해줌
		
		System.out.println(Arrays.toString(strArray1));
	
	
	
		//11. 실제 Set의 값보다 방의 크기를 크게 했을 경우는 Null이 들어 갈 수 있다.
		String[] strArray2 = linkedhSet3.toArray(new String[5]);
		System.out.println(Arrays.toString(strArray2)); //빈공간은 null
	
	
	
		Set<Integer> intSet1 = new LinkedHashSet();
		
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
