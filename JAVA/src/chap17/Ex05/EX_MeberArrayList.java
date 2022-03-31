package chap17.Ex05;

import java.util.ArrayList;
import java.util.Arrays;

class Member{				//DTO, VO : �� �������� �����͸� �޾Ƽ� �������ִ� Ŭ����
	private int memberid;
	private String memberName;
	
	public Member(int memberid,String memberName) { //�����ڸ� ���ؼ� �ʵ忡 ���Ҵ�
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
			return memberName + "ȸ������ id�� "+memberid+"�Դϴ�.";
		}
	
}

class MemberArrayList{ 			//MemberArrayList��  ��üȭ�ϸ� ArrayList ��ü�� ���������.
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() { //�⺻ ������
		arrayList = new ArrayList<Member>();
	}
	public void addMember(Member member){ // Member ��ü�� �޾Ƽ� �� ������ �濡 ���� �߰��ϴ� �޼ҵ�
		/*�ڵ�*/
		arrayList.add(member);
		
		
		
	}
	
	public void addMember2(int a,Member member) { //�Ű����� 2���� �޾Ƽ� //Ư�� �ε��� ���ȣ�� ���� �߰�
		//�ڵ�
		arrayList.add(a, member);
		
	}
	public boolean removeMember(int memberid) {
		if(arrayList.contains(memberid)) {
			arrayList.remove(memberid);
		}return true;
		
	}

	public void showAllMember() {
		//ArrayList�� ����� ��� ����� ������ ����ϴ� �޼ҵ�
		System.out.println(arrayList);
	}
	
	
	
}

public class EX_MeberArrayList {

	public static void main(String[] args) {

		MemberArrayList memberArrayList = new MemberArrayList();
		Member memberLee = new Member(1001, "������");
		Member memberKim = new Member(1002, "�����");
		Member memberSon = new Member(1003, "������");
		Member memberPark = new Member(1004, "���п�");

		memberArrayList.addMember(memberLee);	//�� ��ü�� �����ؼ� ArrayList�� ����
		memberArrayList.addMember(memberKim);
		memberArrayList.addMember(memberSon);
		memberArrayList.addMember(memberPark);
		
		//Ư�� index�濡 �߰��� ����� �߰�
		memberArrayList.addMember2(3, memberPark);
		
		//��� ����� ���� ���
		memberArrayList.showAllMember();
		
		//Ư�� id�� ���� ����� ����
		memberArrayList.removeMember(1004);
		//Ȯ��
		
		memberArrayList.showAllMember();
		
	}

}
