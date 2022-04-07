package chap17.Ex06;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;


// 중요 : Set은 중복된 값을 저장할수 없다.
	//wrapper 클래스 integer, Long, Double, Float, Character, Byte, Short, Boolean
	//wrapper클래스는 equals(), hashCode()메소드가 재정의 되어있다.
	//특정 객체를 생성후 그 객체를 Set에 저장할 경우 그 객체의 Object클래스의 equals(), hashCode()를 재정의 해줘야한다.
	//객체의 특정 필드의 값이 같은때 중복을 식별하는 필드를 생성.

class Member{				//DTO, VO : 각 계층간에 데이터를 받아서 전달해주는 클래스
	private int memberid;	//Set에 넣을 식별자, memberid필드의 값이 같을때 같은 객체이다라고 선언
							//equals(), hashCode() 
	private String memberName;
	
	public Member(int memberid,String memberName) { //생성자를 통해서 필드에 값할당
		this.memberid = memberid;
		this.memberName= memberName;
		
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
		public String toString() {
			return memberName + "회원님의 id는 "+memberid+"입니다.";
		}
	@Override			//member1.equals(member2)
		public boolean equals(Object obj) {	//객체의 정보가 Object로 업캐스팅
		if (this.memberid == ((Member)obj).memberid) {
			return true;
		}else {
			return false;
		}
		/*if (obj instanceof Member) { //다운캐스팅할때 런타임 오류를방지, Object에 Member객체가 포함되어 있을때
		 * 		Member member = (Member) obj; // obj는 object로 업캐스팅 되어서 다운캐스팅
		 * 		if( this.memberid == member.memberid){ //this.memberid : member1 객체의 ,mbmber.memberid :member2
		 * 			return true;
		 * 		}else{
		 * 			return false;
		 * 		}
		 * 		}
		 * }
		 * return false; //obj가 Member타입을 내포하지 않을때
		 */
	}
	@Override
		public int hashCode() { //memberid 필드의 값이 동일 할때 동일한 hashCode를 생성
			return Objects.hash(memberid); //권장사항,
				//Objects.hashCode(memberid,memberName); 여러개의 필드를 조건으로 hashCode를 생섷할수 있따.
					//memberid, memberName필드의 값이 모두 동일할 경우 동일한 hashCode();
			//return memberid;
			//this.memberid
			//return this.memberid; //하나의 필드만을 조건으로 hashCode()생성,
			
		}
}

class MemberHashSet{ 			//MemberArrayList를  객체화하면 ArrayList 객체가 만들어진다.
	private Set<Member> hashSet; //Set 선언 : <Member> 필드의 private (생성자,setter)
	
			//Set <Member> hashSet = new HashSet<Member>();
	public MemberHashSet() { //기본 생성자 호출시 Set의 참조변수 활성화
		hashSet = new HashSet<Member>();
	}
	
	public void addMember(Member member){ // Member 객체를 받아서 맨 마지막 방에 값을 추가하는 메소드
		hashSet.add(member); //Member 객체를 인풋받아 hashSet에 member객체를 저장, 중복저장되면 안된다.
							//Member 객체의 memberid 필드의 값이동일할 경우, 동일한 객체이다라고 정의
							//equals(),hashCode()메소드 재정의 : memberid
		
		
	}
	public boolean removeMember(int memberid) { //memberid 는 Member객체 내의 필드이므로 Set에 저장된 객체를 가져와야한다.
		// Set은 index가 존재하지 않으므로 기본 for 문은 사용할수 없다
		//향상된 for 문 사용할 수 있고, iterator를 사용할 수 있다.
		//iterator 사용해서 remove
		/*
		 Iterator<Member> ir = hashSet.iterator(); //iterator :순회자,
		 while (ir.hasnext()) {					//hasNext() :hashSet에 값이존재할떄 true,false
		 	Member member = ir.next();			//Next(); 값을 던져주고 다음값으로 이동
		 	int tempid = member.getMemberid();
		 	
		 	if (tempid == memberid){
		 		hashSet.remove(member);
		 		return true;
		 	}
		 }
		 	System.out.println("아이디가 존재하지 않습니다.");
		 	return false;
		 */
		
		/*for(Member k : hashSet) {
			if(k.getMemberid() == memberid) {
				hashSet.remove(k);
				return true;
			}
		}
		return false;*/
		//iterator
		/*Iterator<Member> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(memberid)) {
				hashSet.remove(memberid);
				return true;
			}	
		}
		return false;*/
		Iterator<Member> iterator = hashSet.iterator();
			while(iterator.hasNext()) {
				Member member = (Member)iterator.next();
					if(member.getMemberid() == memberid) {
						hashSet.remove(member);
						return true;
				}	
		}
		return false;
	}       
	
	public void showAllMember() {
		//ArrayList에 저장된 모든 사용자 정보를 출력하는 메소드
		//iterator
		Iterator<Member> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+ " ");
		}
		System.out.println();
		/*
		 Iterator<Member> ir = hashSet.iterator(); //지역 변수
		 while( ir.hasNext()){
		 	Member member = ir.next(); //hashSet의 값을 가지고온다.
		 	System.out.println(member); //hashSet의 객체를 출력 ,toString()메소드 재정의 :필드의 값출력
		 }
		 */
	}
	public void showSize() {
		System.out.println(hashSet.size());
	}
	
	
}

public class EX_MemberHashSet {

	public static void main(String[] args) {
		MemberHashSet memberHashSet = new MemberHashSet();
		Member memberLee = new Member(1001, "이지원");
		Member memberKim = new Member(1002, "김원국");
		Member memberSon = new Member(1003, "손지수");
		Member memberPark = new Member(1004, "박학원");
		Member memberPark2 = new Member(1004, "박학원");

		memberHashSet.addMember(memberLee);
		memberHashSet.addMember(memberKim);
		memberHashSet.addMember(memberSon);
		memberHashSet.addMember(memberPark);
		memberHashSet.addMember(memberPark2);
		
		
		memberHashSet.showSize(); //4개 출력
		
		
		//모든 사용자 정보 출력
		memberHashSet.showAllMember();
		
		//특정 id를 가진 사용자 제거
		memberHashSet.removeMember(1002);
		//확인
		
		memberHashSet.showAllMember();
		
	}

}
