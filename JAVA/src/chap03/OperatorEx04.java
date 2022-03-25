package chap03;

public class OperatorEx04 {

	public static void main(String[] args) {
		/*
		 * 대입 연산자 ( =, +=, -=, *=, /=, >>=, <<=, >>>=)
		 * a = b; <=== 오른쪽의 값을 왼쪽에 할당해라 라는 의미 , ==(같다)
		 * a +=b; <== a= a+b; 를 축약해놓은것
		 * a -=b; <== a= a - b;
		 * a *=b; <== a= a * b;
		 * a /=b; <== a= a / b;
		 * a &=b; <== a= a & b;
		 * a |=b; <== a= a | b;
		 * a <<=b; <== a= a << b;
		 * 
		 */
		int value1 = 3;
		value1 = value1 + 3;
		System.out.println(value1);
		System.out.println();
		
		int value2; //기본형 자료형인 경우 변수의 값을 넣지 않을 경우 기본값으로 0이 할당
		value2 = 5; //참조자료 형일 경우 변수의 값을 할당 하지 않을 경우 기본값으로 NULL이 할당
		//축약 표현
		
		System.out.println(value2 +=2 ); //value2 =value2 +2 // 5+2=7
		System.out.println(value2 -=2); // value2 =value2 -2 // 7-2=5
		System.out.println(value2 /=2); // value2 =value2 /2 // 5/2=2.5 이지만 int타입이라 2만 저장
		value2 = 5; System.out.println(value2 %= 2);
		value2 = 5; System.out.println(value2 |= 2); // 5 = 0101 2 = 0010 OR = 0111 = 7 //value2 = value2 | 2 
		value2 = 5; System.out.println(value2 &= 2); //5 = 0101 2 = 0010 AND = 0000 = 0 //value2 = value2 & 2
		
		value2 = 5; System.out.println(value2 <<= 2); // valur2 = value2 << 2 왼쪽으로 2칸이동해라
		value2 = 5; System.out.println(value2 >>= 2); // value2 = value2 >> 2 오른쪽으로 2자리이동해라
		value2 = -5; System.out.println(value2 >>>= 2); // value2 = value2 >>> 2 오른쪽으로 이동하는데 보수비트까지 같이이동해라
		byte value3;
		value3 = -128; System.out.println(value3 >>>= 2);
		
		
	}

}
