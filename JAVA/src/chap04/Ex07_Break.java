package chap04;

public class Ex07_Break {

	public static void main(String[] args) {

		//1. 단일 loop가 적용된 곳에서 break 탈출
	for ( int i = 0; i<10; i++) {
		System.out.println(i);
		break; //break를 만나면 해당 구문을 빠져나옴
	}//0
		System.out.println("==============");
		
	//2. for문 내에서 if조건을 사용해서 break를 넣어서 해당 구문을 빠져나온다.
	for ( int i=0;i<10;i++) {
		if( i==5) { //i가 5일때 for문을 빠져나온다( break는 if를 제외한 가장근처의 {}를 탈출한다.
			break;
		}
		System.out.print(i + " ");
	}
		System.out.println();
		System.out.println("==================");
	//3. 다중 Loop 문일때 break 탈출 (하나의 반복문만 빠져나온다.)
	for (int i=0; i<5; i++) {
		for ( int j = 0; j<5; j++) {
			if (i == 2) { //2일때 break해서 i가 2일떄만 없음 2만생략 0 , 1, 3, 4일떄는 다찍힘
				break;
			}
			System.out.println(i+ "," +j);
		}
	}
		System.out.println("================");
	//4. 다중 Loop(반복문) 에서 한꺼번에 탈출 <<1번째 방법 라벨(LABEL)이름을 사용해서 탈출하는 방법
	POST1: for (int i=0; i<5; i++) { //post1 => Label 이걸 넣고 정의를하게되면 break 뒤에 post1을 붙이면 그곳까지 탈출함
		for (int j =0; j<5; j++) {
			if(i==2) {
				break POST1;
			} 
			System.out.println(i + "," +j);
			
		}
	}
	System.out.println("=====================");
	//4. 다중 Loop (반복문)에서 한꺼번에 탈출<< 2, 변수의 조건을 false로 만들어서 빠져나오는 방법
	for (int i=0; i<5; i++) {
		for(int j=0; j<5; j++) {
			if (i == 2) {
				i = 100;
				break;
			}
			System.out.println(i + "," +j);
		}
	}
	
	
	
	
	
	
	
		
		
		
	}

}
