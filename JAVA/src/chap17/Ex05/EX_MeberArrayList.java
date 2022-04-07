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
		try {
			arrayList.add(a, member);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("예외가 발생되었습니다. 방번호를 정확하게 입력하세요");
		}
		
		
		
		
	}
	public boolean removeMember(int memberid) {
		
			for (int i =0; i <arrayList.size();i++) {
				if(arrayList.get(i).getMemberid()== memberid) {
					arrayList.remove(i);
					System.out.println(memberid);
					return true;
				}
				
			}
			return false;
		
		/*for (int i = 0; i<arrayList.size();i++){
		 	Member member = arrayList.get(i); //각 방에 저장된 Member객체를 member참조변수에 할당
		 	int tempid = member.getmemberid(); //객체의 getMemberid() 를 사용해서, 객체 내부의 memberid
		 	if(tempid == memberid){
		 	arrayList.remove(i); //arrayList방에 저장된 객체를 제거
		 	System.out.println("회원님의" + memberid + "삭제되었습니다.");
		 	return true;
		 	}
		  }
		  System.out.println(meberid + "가 존재하지 않습니다.");
		  return false;			  
		 */
				
	}       
	
	public void showAllMember() {
		//ArrayList에 저장된 모든 사용자 정보를 출력하는 메소드
		System.out.println(arrayList);
		for (int i =0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i)); //각방의 Member 객체 자체를 출력
		}
	}
	public void showSize() {
		System.out.println(arrayList.size());
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
		
		
		memberArrayList.showSize();
		
		//특정 index방에 추가적 사용자 추가
		memberArrayList.addMember2(5, memberPark); //예외 처리
		
		//모든 사용자 정보 출력
		memberArrayList.showAllMember();
		
		//특정 id를 가진 사용자 제거
		memberArrayList.removeMember(1004);
		//확인
		
		memberArrayList.showAllMember();
		
	}

}
