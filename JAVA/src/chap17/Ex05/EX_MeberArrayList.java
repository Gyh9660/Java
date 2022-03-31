package chap17.Ex05;

import java.util.ArrayList;
import java.util.Arrays;

class Member{				//DTO, VO : 각 계층간에 데이터를 받아서 전달해주는 클래스
	private int memberid;
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
	
}

class MemberArrayList{ 			//MemberArrayList를  객체화하면 ArrayList 객체가 만들어진다.
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() { //기본 생성자
		arrayList = new ArrayList<Member>();
	}
	public void addMember(Member member){ // Member 객체를 받아서 맨 마지막 방에 값을 추가하는 메소드
		/*코드*/
		arrayList.add(member);
		
		
		
	}
	
	public void addMember2(int a,Member member) { //매개변수 2개를 받아서 //특정 인덱스 방번호에 값을 추가
		//코드
		arrayList.add(a, member);
		
	}
	public boolean removeMember(int memberid) {
		if(arrayList.contains(memberid)) {
			arrayList.remove(memberid);
		}return true;
		
	}

	public void showAllMember() {
		//ArrayList에 저장된 모든 사용자 정보를 출력하는 메소드
		System.out.println(arrayList);
	}
	
	
	
}

public class EX_MeberArrayList {

	public static void main(String[] args) {

		MemberArrayList memberArrayList = new MemberArrayList();
		Member memberLee = new Member(1001, "이지원");
		Member memberKim = new Member(1002, "김원국");
		Member memberSon = new Member(1003, "손지수");
		Member memberPark = new Member(1004, "박학원");

		memberArrayList.addMember(memberLee);	//각 객체를 생성해서 ArrayList에 저장
		memberArrayList.addMember(memberKim);
		memberArrayList.addMember(memberSon);
		memberArrayList.addMember(memberPark);
		
		//특정 index방에 추가적 사용자 추가
		memberArrayList.addMember2(3, memberPark);
		
		//모든 사용자 정보 출력
		memberArrayList.showAllMember();
		
		//특정 id를 가진 사용자 제거
		memberArrayList.removeMember(1004);
		//확인
		
		memberArrayList.showAllMember();
		
	}

}
