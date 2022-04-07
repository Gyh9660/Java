package chap17.Ex10;


//Map<K,V> : Key는 중복 되지 않는다. <== Set으로 관리
//HashMap vs LinkedHashMap
	//HashMap<K,V> : 입력과 출력이 다를수 있따. 출력이 랜덤하게 출력
	//LinkedHashMap<K,V> :  Key는 링크되어있다. 앞의 값과 뒤의 값의 정보를 가진다.	
		//입력 순서대로 출력이 됩니다.


import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashTableMethod {

	public static void main(String[] args) {

		Map<Integer,String> lhMap1 = new LinkedHashMap<>();
		
		//1. put(K key, V value) : 값을 넣을때.
		lhMap1.put(2, "나다라");
		lhMap1.put(1, "가나다");
		lhMap1.put(3, "다라마");
		//lhMap1.put(3, "가가가"); //키는 중복해서 저장 될 수 없다. 값을 넣을경우 기존의 값이 수정이 된다.
		
		System.out.println(lhMap1); 
		
		//2. putAll(다른맵객체) : 다른 맵을 복사해서 사용.
		Map<Integer, String> lhMap2 = new LinkedHashMap();
		lhMap2.putAll(lhMap1);
		System.out.println(lhMap2);
		
		//3. replace (K key, V value) ; Key에 저장된 값을 value로 수정.
		lhMap2.replace(1, "가가가");
		lhMap2.replace(4, "라라라"); //key 4는 존재하지 않는다. 작동이안됨(예외도 발생안됨)
		
		System.out.println(lhMap2);
		
		//4. replace(K key, V oldValue, V newValue) :oldValue를 newValue로 수정
		lhMap2.replace(1, "가가가", "나나나");
		lhMap2.replace(2, "다다다", "라라라"); //동작안됨 <--- key와value가 정확히 일치해야 수정됨.
		System.out.println(lhMap2);
		
		//5. get(Object Key) : Map의 값을 가져와라, key를 넣어줘야 key에 할당된 Value를 출력.
		System.out.println(lhMap2.get(1)); //주의  1 index가 아니라 Key
		System.out.println(lhMap2.get(2)); //주의  2 index가 아니라 Key
		System.out.println(lhMap2.get(3)); //주의  3 index가 아니라 Key
		
		//6. containsKey(Object key); 맵에 해당 키가 존재하는지 확인 ,true,false
		System.out.println(lhMap2.containsKey(1));//true
		System.out.println(lhMap2.containsKey(5));//false
		
		//7. containsValue(Object value); 맵에 해당 value가 존재하는지 확인, true,false
		System.out.println(lhMap2.containsValue("나나나")); //true
		System.out.println(lhMap2.containsValue("다다다")); //false
		
		//8. Set<K> KeySet() : 키만 추출
		Set<Integer> keySet = lhMap2.keySet(); //lhMap2에 저장된 keySet을 추출
		System.out.println(keySet);
		
		//9. Set<Map.Entry<K,V>> entrySet() : 키와 값의 셋(Set)을 추출
		Set<Map.Entry<Integer, String>> entrySet = lhMap2.entrySet();
		System.out.println(entrySet);
		
		//10. size();총 갯수
		System.out.println(lhMap2.size()); //3
		
		//11. remove(Object key) // 키를 넣어서 key와 value를 삭제.
		lhMap2.remove(1); //1번삭제 
		lhMap2.remove(4); //동작하지 않음
		System.out.println(lhMap2);
		
		//12. remove (Object key, Object value) // key와 value가 정확하게 일치할때 삭제
		lhMap2.remove(2,"나다라");//삭제
		lhMap2.remove(3,"다다다");//동작 안함
		System.out.println(lhMap2);
		
		//13. clear() :모두삭제
		lhMap2.clear();
		System.out.println(lhMap2);
		
		
	}

}
