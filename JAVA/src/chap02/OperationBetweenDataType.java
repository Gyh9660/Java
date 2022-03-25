package chap02;

public class OperationBetweenDataType {

	public static void main(String[] args) {
		//같은 자료형 간의 연산
		
		int value1 = 3+5; //int + int ====> int
		int value2 = 8 / 5; // int / int ===> int
		float value3 = 3.0f + 5.0f; // float + float =>float
		double value4 = 8.0  / 5.0; //double / double ==> double
		
		byte data1 = 3; 
		byte data2 = 5;
		
		//byte value5 = data1 + data2; 오류 발생
		int value5 = data1 + data2; //int보다 작은 자료형은 연산 했을때 결과를 int 타입으로 변환
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println(value5);
		System.out.println("==================");
		
		//다른 자료형 간의 연산
		
		double value6 = 5 + 3.5; //int + double ---> double 형으로
		//int value66 = 5 + 3.5; 오류발생 (int)(5 + 3.5)로하면 문제가 생기지않음, 인트로캐스팅할경우 작은자료형과 큰자료형을 같이하면 큰자료형으로 받아줘야함 위이경우에선 int가아니라 double나 float로 받아주었어야 했음.
		int value666 = (int)(5 + 3.5);
		
		double value7 = 5 / 2.0;
		byte data3 = 3;
		short data4 = 5;
		
		//short value88 = data3 +data4; 오류발생
		int value8 = data3 + data4; //int보다 작은 데이터 타입이 연산할 경우 int로 받아줘야함
		double value9 = data3 + data4; 
		
		System.out.println(value6);
		System.out.println(value666);
		System.out.println(value7);
		System.out.println(value8);
		System.out.println(value9);
		
		System.out.println((int)5.6+3.5);
		System.out.println((int)5.6+(int)3.5);
		System.out.println((int)(5.6+3.5));
		System.out.println(7/4);
		System.out.println((double)3/2);
		System.out.println((double)(3/2));
		
	}

}
