package chap05;

import java.util.Arrays;

public class Ex2_08_MethodOfString_02 {
	
	public static void main(String[] args) {
		//5. 문자열 수정
		//toLowerCase() : 소문자로 변환. toUpperCase() : 대문자로 변환
		String str1 = "Java Study";
		System.out.println(str1.toLowerCase()); // java study
		System.out.println(str1.toUpperCase()); // JAVA STUDY
		System.out.println("==============");
		
		//replace(old,new) : old 를 new로 바꿈.
		System.out.println(str1.replace("Study", "공부"));//Java 공부
		System.out.println("===========");
		
		//substring(시작index,자를 마지막 방index 앞까지) : 문자열을 잘라서 출력
		System.out.println(str1.substring(0,5)); //Java 
		System.out.println(str1.substring(6,8)); //tu
		System.out.println("============");
		
		//split() : 특정 문자를 기준으로 잘라서 String[] 배열에 저장
		
		String str11 = "abc/def-ghi jkl";
		String[] strArray = str11.split("/|-| "); //자를 인자: '/' 또는 '-' 또는 '공백'
		System.out.println(Arrays.toString(strArray));
		
		String str111 = "오늘의 날씨는 흐립니다. ";
		String []strArray2 = str111.split(" "); //공백을 기준으로 잘라서 strArray2 배열에 저장
		System.out.println(Arrays.toString(strArray2));
		
		String str1111 = "이름, 나이, 성별, 전화번호, 메일주소";
		String[] strArray3 = str1111.split(",");
		System.out.println(Arrays.toString(strArray3));
		for (int i =0; i <strArray3.length; i++) {
			System.out.print(strArray3[i]+ " ");
		}
		
		//trim() : 앞뒤의 공백을 제거함.
		System.out.println("================");
		System.out.println("              abc        ");
		System.out.println("              abc       ".trim());
		
		//6. 문자열의 내용 비교.
		//equals() : 대소문자를 구분하면서 값을 비교
		//equalsIgnoreCase() : 대소문자 구별없이 값을 비교
		
		String str2 = new String("Java");
		String str3 = new String("Java");
		String str4 = new String("java");
		
		//메모리의 주소 값 비교 (==)
		System.out.println(str2==str3);//false
		System.out.println(str3==str4);//false
		System.out.println(str4==str2);//false
		System.out.println("===============");
		
		//값을 비교(equals(), equalsIgnoreCase() )
		System.out.println(str2.equals(str3)); //true, 대소문자 구별
		System.out.println(str3.equals(str4)); // false, 대소문자 구별
		System.out.println(str3.equalsIgnoreCase(str4)); // true , 대소문자 구별 하지않는다.
		
		
		
	}
}
