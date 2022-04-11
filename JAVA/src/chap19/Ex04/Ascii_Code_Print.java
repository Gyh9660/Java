package chap19.Ex04;

/*
 * ASCII 코드 값 출력 : 1byte=8bit, 제일 처음비트는 부호 비트, 7bit :128개 (0~127)
 * 	1 ~ 32비트 까지는 : 출력을 할수없는 특수한 코드, 예) null, 헤더의 시작, 경고음(7) 개행[LF] (10).....
 * 127 : delete.
 * 
 * 실제 출력 가능은 33번 비트~ 126비트
 * 영문, 숫자, 특수문자.
 * 
 * 출력
 * ===================================
 * ASCII	문자		아스키코드	문자
 * ===================================
 * 33	!		34		&
 * 35	#		36		$
 * ....
 * 126	~
 */
public class Ascii_Code_Print {

	public static void main(String[] args) {

		System.out.println("출력");
		System.out.println("======================================");
		System.out.println("ASCII\t문자\t\tASCII\t문자");
		System.out.println("======================================");
		
		/*for(int i = 33; i<127; i+=2) {
			System.out.println(i+"\t"+(char)i+"\t\t"+(i+1)+"\t"+(char)(i+1));
		}
		
		System.out.println();*/
		
		int[] arr1 = new int[94];
		for(int i = 0; i<arr1.length; i+=2) {
			arr1[i]= 33+i; arr1[i+1]= 34+i;
			System.out.println(arr1[i]+"\t"+(char)arr1[i]+"\t\t"+arr1[i+1]+"\t"+(char)arr1[i+1]);
		}
	}

}
