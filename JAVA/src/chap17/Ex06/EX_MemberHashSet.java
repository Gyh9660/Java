package chap17.Ex06;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;


// �߿� : Set�� �ߺ��� ���� �����Ҽ� ����.
	//wrapper Ŭ���� integer, Long, Double, Float, Character, Byte, Short, Boolean
	//wrapperŬ������ equals(), hashCode()�޼ҵ尡 ������ �Ǿ��ִ�.
	//Ư�� ��ü�� ������ �� ��ü�� Set�� ������ ��� �� ��ü�� ObjectŬ������ equals(), hashCode()�� ������ ������Ѵ�.
	//��ü�� Ư�� �ʵ��� ���� ������ �ߺ��� �ĺ��ϴ� �ʵ带 ����.

class Member{				//DTO, VO : �� �������� �����͸� �޾Ƽ� �������ִ� Ŭ����
	private int memberid;	//Set�� ���� �ĺ���, memberid�ʵ��� ���� ������ ���� ��ü�̴ٶ�� ����
							//equals(), hashCode() 
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
	@Override			//member1.equals(member2)
		public boolean equals(Object obj) {	//��ü�� ������ Object�� ��ĳ����
		if (this.memberid == ((Member)obj).memberid) {
			return true;
		}else {
			return false;
		}
		/*if (obj instanceof Member) { //�ٿ�ĳ�����Ҷ� ��Ÿ�� ����������, Object�� Member��ü�� ���ԵǾ� ������
		 * 		Member member = (Member) obj; // obj�� object�� ��ĳ���� �Ǿ �ٿ�ĳ����
		 * 		if( this.memberid == member.memberid){ //this.memberid : member1 ��ü�� ,mbmber.memberid :member2
		 * 			return true;
		 * 		}else{
		 * 			return false;
		 * 		}
		 * 		}
		 * }
		 * return false; //obj�� MemberŸ���� �������� ������
		 */
	}
	@Override
		public int hashCode() { //memberid �ʵ��� ���� ���� �Ҷ� ������ hashCode�� ����
			return Objects.hash(memberid); //�������,
				//Objects.hashCode(memberid,memberName); �������� �ʵ带 �������� hashCode�� ���E�Ҽ� �ֵ�.
					//memberid, memberName�ʵ��� ���� ��� ������ ��� ������ hashCode();
			//return memberid;
			//this.memberid
			//return this.memberid; //�ϳ��� �ʵ常�� �������� hashCode()����,
			
		}
}

class MemberHashSet{ 			//MemberArrayList��  ��üȭ�ϸ� ArrayList ��ü�� ���������.
	private Set<Member> hashSet; //Set ���� : <Member> �ʵ��� private (������,setter)
	
			//Set <Member> hashSet = new HashSet<Member>();
	public MemberHashSet() { //�⺻ ������ ȣ��� Set�� �������� Ȱ��ȭ
		hashSet = new HashSet<Member>();
	}
	
	public void addMember(Member member){ // Member ��ü�� �޾Ƽ� �� ������ �濡 ���� �߰��ϴ� �޼ҵ�
		hashSet.add(member); //Member ��ü�� ��ǲ�޾� hashSet�� member��ü�� ����, �ߺ�����Ǹ� �ȵȴ�.
							//Member ��ü�� memberid �ʵ��� ���̵����� ���, ������ ��ü�̴ٶ�� ����
							//equals(),hashCode()�޼ҵ� ������ : memberid
		
		
	}
	public boolean removeMember(int memberid) { //memberid �� Member��ü ���� �ʵ��̹Ƿ� Set�� ����� ��ü�� �����;��Ѵ�.
		// Set�� index�� �������� �����Ƿ� �⺻ for ���� ����Ҽ� ����
		//���� for �� ����� �� �ְ�, iterator�� ����� �� �ִ�.
		//iterator ����ؼ� remove
		/*
		 Iterator<Member> ir = hashSet.iterator(); //iterator :��ȸ��,
		 while (ir.hasnext()) {					//hasNext() :hashSet�� ���������ҋ� true,false
		 	Member member = ir.next();			//Next(); ���� �����ְ� ���������� �̵�
		 	int tempid = member.getMemberid();
		 	
		 	if (tempid == memberid){
		 		hashSet.remove(member);
		 		return true;
		 	}
		 }
		 	System.out.println("���̵� �������� �ʽ��ϴ�.");
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
		//ArrayList�� ����� ��� ����� ������ ����ϴ� �޼ҵ�
		//iterator
		Iterator<Member> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+ " ");
		}
		System.out.println();
		/*
		 Iterator<Member> ir = hashSet.iterator(); //���� ����
		 while( ir.hasNext()){
		 	Member member = ir.next(); //hashSet�� ���� ������´�.
		 	System.out.println(member); //hashSet�� ��ü�� ��� ,toString()�޼ҵ� ������ :�ʵ��� �����
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
		Member memberLee = new Member(1001, "������");
		Member memberKim = new Member(1002, "�����");
		Member memberSon = new Member(1003, "������");
		Member memberPark = new Member(1004, "���п�");
		Member memberPark2 = new Member(1004, "���п�");

		memberHashSet.addMember(memberLee);
		memberHashSet.addMember(memberKim);
		memberHashSet.addMember(memberSon);
		memberHashSet.addMember(memberPark);
		memberHashSet.addMember(memberPark2);
		
		
		memberHashSet.showSize(); //4�� ���
		
		
		//��� ����� ���� ���
		memberHashSet.showAllMember();
		
		//Ư�� id�� ���� ����� ����
		memberHashSet.removeMember(1002);
		//Ȯ��
		
		memberHashSet.showAllMember();
		
	}

}
