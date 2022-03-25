package chap03;

public class OperatorEx01 {

	public static void main(String[] args) {
		int data = 13; //
		
		System.out.println(Integer.toBinaryString(data)); // 2진수로 변환 13-> 1101
		System.out.println(Integer.toOctalString(data)); // 8진수로 변환 13-> 15
		System.out.println(Integer.toHexString(data)); // 16진수로 변환 13-> d
		System.out.println();
		
		System.out.println(Integer.parseInt("1101", 2)); // 2진수 1101을 십진수로 변환 1101뒤에 2라는것이 몇진수인지 알려주는 부분 8을쓰면 8진수 16을쓰면 16진수
		System.out.println(Integer.parseInt("15", 8)); // 8진수 15을 십진수로 변환
		System.out.println(Integer.parseInt("0D", 16)); // 16진수 0D를 십진수로 변환
		
		System.out.println("====================");
		
		System.out.println(~3);// 양수를 ~를 하면, 음수 :0을 기준으로 계산+1
		System.out.println(~7); //양수에 +1해서 음수붙여주면 그게 not (~) 한 값이나옴
		
		//다양한 진법 표현
		System.out.println("===================");
		System.out.println(13);
		System.out.println(0b1101);//0b는 이진수 표현
		System.out.println(015); //00는 8진법 표현인데 0로 생략가능
		System.out.println(0x0D);// 0x는 16진수 표현
		System.out.println("==================");
		
		
		
		
	}

}
