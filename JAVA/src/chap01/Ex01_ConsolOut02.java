package chap01;
public class Ex01_ConsolOut02 {
	public static void main(String[] args) {
		System.out.printf("나의 나이는 %d입니다. \n", 30); //printf는 "출력포멧",인자,인자 ["%d"(%d는 뒤에오는 정수값을 인자로 받아서 처리(10진수))] //
		System.out.printf("%o\n",10);//%o는 8진수를 인자값으로 받을떄//
		System.out.printf("%x\n", 30);//%x는 16진수를 인자값으로 받을때//
		System.out.printf("%s\n", "출력");//%s는 문자열을 인자값으로 받을떄//
		System.out.printf("%f\n", 5.800000);//%f는 실수값을 인자값으로 받을때//
		System.out.printf("%4.2f\n", 12335.812345);//%4.2f는 전체 4자리, 소숫점 이하 2자리를 인풋 받을때//
		System.out.printf("%d 와 %4.2f", 10, 5.8);
	}

}
