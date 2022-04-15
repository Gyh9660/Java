package fruit_Ex;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 상속을 다루는 문제 입니다. 하위의 생성자에 super()메소드 사용
 * 
 */

class Fruit{
	String fruitName;	//과일 이름
	String color;		//과일 색
	int large;			//과일 크기
	Fruit(){
		
	}
	Fruit(String fruitName, String color, int large){
		this.fruitName = fruitName;
		this.color = color;
		this.large = large;
	}
	
	public String toString() { //과일의 정보를 출력하는 메소드
		return "과일의 이름 :"+fruitName+"이고, 색깔은 "+ color +"이고, 크기는 "+ large +"입니다.";
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLarge() {
		return large;
	}

	public void setLarge(int large) {
		this.large = large;
	}
	
}

class Apple extends Fruit {
	Apple(String fruitName, String color, int large){
		super(fruitName,color,large);
		
	}
	
}
class Orange extends Fruit {
	Orange(String fruitName, String color, int large){
		super(fruitName,color,large);
		
	}
}
class Banana extends Fruit {
	Banana(String fruitName, String color, int large){
		super(fruitName,color,large);
		
	}
}


public class Fluit_test {

	public static void main(String[] args) {
		ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
		//1. 코드 작성 : 스캐너를 인풋 받는 코드 작성.
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean run = true;		
		while(run) {
			System.out.println("===============================================");
		System.out.println("1. 사과 | 2. 오렌지 | 3. 바나나 | 4. 정보출력 | 5. 종료");
		System.out.println("===============================================");
			System.out.println("선택>>");
			num = sc.nextInt();
			
			if(num == 1) {
				System.out.println("선택 >> 1");	
				System.out.println("과일명 : ");
				String Name;
				Name = sc.next();
				System.out.println("색깔 : ");
				String color;
				color = sc.next();
				System.out.println("크기 : ");
				int large = sc.nextInt();
				Apple apple = new Apple(Name,color,large);
				fruitList.add(apple);
			}else if(num == 2) {
				System.out.println("선택 >> 2");	
				System.out.println("과일명 : ");
				String Name;
				Name = sc.next();
				System.out.println("색깔 : ");
				String color;
				color = sc.next();
				System.out.println("크기 : ");
				int large = sc.nextInt();
				Orange orange = new Orange(Name,color,large);
				fruitList.add(orange);
			}else if(num == 3) {
				System.out.println("선택 >> 3");	
				System.out.println("과일명 : ");
				String Name;
				Name = sc.next();
				System.out.println("색깔 : ");
				String color;
				color = sc.next();
				System.out.println("크기 : ");
				int large = sc.nextInt();
				Banana banana = new Banana(Name,color,large);
				fruitList.add(banana);
			}else if(num == 4) {
				System.out.println("선택 >> 4");
				for(Fruit k : fruitList) {
					System.out.println(k);
				}
			}else if(num == 5) {
				System.out.println("선택 >> 5");
				break;
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
		
		
		
		
		//2. 코드 작성 : 스캐너로 받은 값으로 각각의 객체를 생성해서 ArrayList에 저장
		/*
		3. 선택>> 4 객체를 가져와서 객체를 출력했을때 ArrayList의 모든객체를 가져와서 객체 정보를 출력	, Enhanced For 문을 사용헤서
			출력결과 :
			과일의 이름 : <사과> 이고, 색깔은 <빨간색> 이고, 크기는 <10> 입니다.
			과일의 이름 : <오렌지> 이고, 색깔은 <주황색> 이고, 크기는 <12> 입니다.
			과일의 이름 : <바나나> 이고, 색깔은 <노란색> 이고, 크기는 <15> 입니다.
		*/
		
	}

}
