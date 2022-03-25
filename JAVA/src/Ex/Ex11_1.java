package Ex;

public class Ex11_1 {

	public static void main(String[] args) {

		//String에 값을 할당할 때 생성자를 통해서 할당// 별도의 메모리 공간을 가진다. //new를 사용하면 새주소를할당
		String aa = new String("안녕");
		String bb = new String("안녕");
		System.out.println(aa);
		System.out.println(bb);
		
		//기본 자료형일때 : == (값을 비교)
		//참조 자료형일때 : == (참조하는 메모리의 주소의 번지를 비교)
		//참조 자료형일때 값을 비교 : str1.equals(str2)<==참조변수 str1값과 str2에 들어가있는 값을 비교
		
		
		if (aa == bb) {  //메모리의 주소 값을 비교 (aa, bb는 다른 메모리주소를갖는다.)
			System.out.println(true);
		}else {
			System.out.println(false); //false 출력(가리키는 주소값이  다르다)
		}
		System.out.println("=============");
		
		if (aa.equals(bb)) { //메모리의 값을 비교할때 aa.equals(bb) aa변수에 들어가있는 값과 bb변수에 들어가있는 값을 비교
			System.out.println(true); //true 가 출력 (값을 비교)
		}else {
			System.out.println(false);
		}
		System.out.println("====================");
		System.out.println("====================");
		// String에 값을 리터럴 값을 바로 할당. // 메모리 공간을 공유 한다.
		
		String a = "안녕";
		String b = "안녕";
				
		if (a==b) { //참조 자료형에서 "=="는 메모리의 주소를 비교 , 기본자료형에서 ==는 값을비교
			System.out.println(true); //true
		}else {
			System.out.println(false);
		}
	}

}
