package chap17.Ex04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.SysexMessage;

//ArrayList vs LinkedList
//ArrayList : 값에 대해서 index 값을 가지고 있다. 검색 속도가 빠르다.
			//단점 : 중간에서 값을 추가/삭제 시 부하가 굉장히 많이 걸린다.

//LinkedList : 각 각의 값은 앞뒤의 연결고리만 가지고 있다. 검색시에 index방 번호가 할당된다.
				//검색이 ArratList에 비해서 느리다
				//장점: 중간에 값을 추가/삭제시 부하가 걸리지 않는다.

public class ArrayListVSLinkedList {

	public static void main(String[] args) {
	
		//1. 데이터를 추가하는 시간 비교
		
		List<Integer> aList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		long startTime = 0, endTime=0;
		
		//1-1 Array List에서 데이터 추가시간
		startTime = System.nanoTime();   //System.nanoTime(): 스타트 앤드의 시간차를구함 앞뒤비교
		for(int i =0; i<100000;i++) {
			aList.add(0,i);   // 0번째 방에 계쏙해서 10만번쨰 까지,계속 뒤로밀리면서 값이 추가
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList에서 데이터 추가 시간 " + (endTime - startTime)+ "ns");
				//395011400ns
		
		//1-2 LinkedList에서 데이터 추가시간 : ArrayList보다 빠르다
		startTime = System.nanoTime();   //System.nanoTime(): 스타트 앤드의 시간차를구함 앞뒤비교
		for(int i =0; i<100000;i++) {
			linkedList.add(0,i);   // 0번째 방에 계쏙해서 10만번쨰 까지,계속 뒤로밀리면서 값이 추가
		}
		endTime = System.nanoTime();
		System.out.println("linkedList에서 데이터 추가 시간 " + (endTime - startTime)+ "ns");
				//4504100ns :250배 정도빠르다.
		System.out.println("==================================");
		
		//2. 검색시 비교: ArrayList가 LinkedList보다 더 빠르다
		
		//2-1 ArrayList 검색 시간 //1407500ns
		startTime = System.nanoTime();
		for (int i =0; i <100000; i++) {
			aList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList에서 데이터 검색 시간 " + (endTime - startTime)+ "ns");
		
		//2-1 LinkedList 검색 시간 //4206423400ns
		startTime = System.nanoTime();
		for (int i =0; i <100000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList에서 데이터 검색 시간 " + (endTime - startTime)+ "ns");
		
		
		System.out.println("====================================");
		
		//3. 데이터 삭제시 실행 시간 비교. : LinkedList가 훨씬 빠르다.
		//3-1. ArrayList 384035900ns
		startTime = System.nanoTime();   //System.nanoTime(): 스타트 앤드의 시간차를구함 앞뒤비교
		for(int i =0; i<100000;i++) {
			aList.remove(0);   // index 0 번째자리를 제거합니다. 값이 당겨옵니다.
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList에서 데이터 삭제 시간 " + (endTime - startTime)+ "ns");
		
		//3-2 LinkedList 3655100ns
		
		startTime = System.nanoTime();   //System.nanoTime(): 스타트 앤드의 시간차를구함 앞뒤비교
		for(int i =0; i<100000;i++) {
			linkedList.remove(0);   // index 0 번째자리를 제거합니다. 값이 당겨옵니다.
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList에서 데이터 삭제 시간 " + (endTime - startTime)+ "ns");
		
	}

}
