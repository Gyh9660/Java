package chap10.Ex07.Ex04;

class AA {
	String name;
	AA(String name){
		this.name = name;
		
	}
}
class BB {
	String name;
	BB(String name){
		this.name = name;
		
	}
	@Override
	public String toString() { //(기본값)패키지명.클래스명@해시ㅜ코드 ==> name 필드의 값을리턴
		return name.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if (this.name ==((BB)obj).name) {
			return true;
		}else {
			return false;
		}
	}
}
public class String_Ex02 {

	public static void main(String[] args) { 

		String s1 = new String("안녕");
		String s2 = "안녕";
		
		System.out.println(s1); // String 클래스는 toString()가 재정의 되어있다.
		System.out.println(s1.equals(s2)); //String 클래스는 equals()도 재정의 되어있다.
		
		AA aa1 = new AA("안녕");
		AA aa2 = new AA("안녕");
		System.out.println(aa1);
		System.out.println(aa1.equals(aa2)); //주소를 비교하기 떄문에
		
		BB bb1 = new BB("안녕");
		BB bb2 = new BB("안녕");
		System.out.println(bb1);
		System.out.println(bb1.equals(bb2));
	}

}
