package Ex;

class Student{
	//자바는 다중 상속이 불가,
	//자바의 모든 클래스는 Object클래스의 자식클래스
		//Object 클래스에서 정의한 필드나 메소드를 재사용 할 수 있다.
	String name; 	//학생이름
	int studentID;	//학번
	int kor; 		//국어점수
	int eng;		//영어점수
	int math;		//수학점수
	int sum;		//점수합계
	double avg;		//점수평균

	void hobby () {
		System.out.println("각 학생의 취미 입니다.");
	}

	@Override
	public String toString() { //Object 클래스의 메소드, 객체 자체를 출력할때,[패키지명.클래스명@해쉬코드]
		return "이름 : "+ name + ", 학번 : "+ studentID + ", 국어 : " + kor +", 영어 : " + eng + ", 수학 : " + math + ", 합계 : " + sum + ", 평균 : " + avg ;
	}

	
}
class S_철수 extends Student{

	S_철수(){ //새엉자: 1. 클래스명과 동일, 2.리턴타입이 없어야함
		
	}
	S_철수(String a, int b,int c,int d,int e){
		super.name = a; //super 부모 클래스, this 자신의 객체
		super.studentID = b;
		super.kor = c;
		super.eng = d;
		super.math = e;
		super.sum = c+d+e;
		super.avg = (double)super.sum/3; //앞에 더블까먹지말고 해주기
	}
	@Override
	void hobby() {
		System.out.println("철수의 취미는 축구입니다. ");
	}
	
}

class S_영희 extends Student{
	
	S_영희(){
		
	}
	S_영희(String a, int b,int c,int d,int e){
		super.name = a;
		super.studentID = b;
		super.kor = c;
		super.eng = d;
		super.math = e;
		super.sum = c+d+e;
		super.avg = (double)super.sum/3; 
	}
	@Override
	void hobby() {
		System.out.println("영희의 취미는 농구입니다. ");
	}
	
}

class S_영식 extends Student{
	S_영식(){
		
	}
	S_영식(String a, int b,int c,int d,int e){
		super.name = a;
		super.studentID = b;
		super.kor = c;
		super.eng = d;
		super.math = e;
		super.sum = c+d+e;
		super.avg = (double)super.sum/3;
	}
	
	@Override
	void hobby() {
		System.out.println("영식의 취미는 야구입니다. ");
	}
	
}




public class Quiz03 {

	public static void main(String[] args) {
		
		Student sa1 = new S_철수("철수",1111,70,80,90);
		System.out.println(sa1);
		Student sa2 = new S_철수();
		sa2.hobby();
		
		System.out.println("====================");
		
		Student sb1 = new S_영희("영희", 2222, 40, 36, 98);
		System.out.println(sb1);
		Student sb2 = new S_영희();
		sb2.hobby();
		
		System.out.println("====================");
		
		Student sc1 = new S_영식("영식", 3333, 77, 100, 96);
		System.out.println(sc1);
		Student sc2 = new S_영식();
		sc2.hobby();
		
		
		System.out.println("===========for 문===============");
		
		Student[] arr1 = {sa1,sb1,sc1};
		for (int i=0; i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		
		Student[] arr2 = {sa2,sb2,sc2};
		for (int i=0; i<arr2.length; i++) {
			arr2[i].hobby();
		}
		
		System.out.println("===========향상된 for문=======");
		
		for(Student t : arr1) {
			System.out.println(t);
		}
		
		for(Student k : arr2) {
			k.hobby();
		}
	}

}
