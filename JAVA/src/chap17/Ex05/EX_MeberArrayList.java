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
		try {
			arrayList.add(a, member);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("���ܰ� �߻��Ǿ����ϴ�. ���ȣ�� ��Ȯ�ϰ� �Է��ϼ���");
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
		 	Member member = arrayList.get(i); //�� �濡 ����� Member��ü�� member���������� �Ҵ�
		 	int tempid = member.getmemberid(); //��ü�� getMemberid() �� ����ؼ�, ��ü ������ memberid
		 	if(tempid == memberid){
		 	arrayList.remove(i); //arrayList�濡 ����� ��ü�� ����
		 	System.out.println("ȸ������" + memberid + "�����Ǿ����ϴ�.");
		 	return true;
		 	}
		  }
		  System.out.println(meberid + "�� �������� �ʽ��ϴ�.");
		  return false;			  
		 */
				
	}       
	
	public void showAllMember() {
		//ArrayList�� ����� ��� ����� ������ ����ϴ� �޼ҵ�
		System.out.println(arrayList);
		for (int i =0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i)); //������ Member ��ü ��ü�� ���
		}
	}
	public void showSize() {
		System.out.println(arrayList.size());
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
		
		
		memberArrayList.showSize();
		
		//Ư�� index�濡 �߰��� ����� �߰�
		memberArrayList.addMember2(5, memberPark); //���� ó��
		
		//��� ����� ���� ���
		memberArrayList.showAllMember();
		
		//Ư�� id�� ���� ����� ����
		memberArrayList.removeMember(1004);
		//Ȯ��
		
		memberArrayList.showAllMember();
		
	}

}
