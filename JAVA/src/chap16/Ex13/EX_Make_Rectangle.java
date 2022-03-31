package chap16.Ex13;

//두 점의 좌표 값을 사용해서 넓이를 구하는 프로그램을 작성 하세요.. 제너릭 클래스/제너릭 메소드사용

class Point <T,V>{ //한점의 좌표를 담는 클래스
	T x ;	//한점의 x좌표
	V y ;	//한점의 y좌표
	
	Point(T x, V y){ // 생성자. Setter대신 생성자를통해 변수의값(좌표) 할당
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public V getY() {
		return y;
	}
	
	
}

class GenericMethod {
	public static <T,V> double makeRctangle (Point<T,V> p1, Point<T,V> p2) {
		// 코드 작성
		double left = ((Double)p1.getX()).doubleValue();
		double right = ((Double)p2.getX()).doubleValue();
		double top = ((Double)p2.getY()).doubleValue();
		double bottom = ((Double)p1.getY()).doubleValue();
		
		//double width = right-left;
		double width = (double)p2.getX()-(double)p1.getX();
		double height = top-bottom;
		
		return width * height; //가로 * 세로 = 넓이를 리턴
		
		/*
		 * double width = (double)p2.getX()-(double)p1.getX();
		 * double height = (double)p2.getY()-(double)p1.getY();
		 */
	}
	public static <T,V> double makeRctangle2 (Point<T,V> p3, Point<T,V> p4) {
		double width = (double)p4.getX()-(double)p3.getX();
		double height = (double)p4.getY()-(double)p3.getY();
		
		return width*height;
	}
}

		


public class EX_Make_Rectangle {

	public static void main(String[] args) {
		Point <Double,Double> p1 = new Point<Double,Double>(1.0,2.0);
		Point <Double,Double> p2 = new Point<Double,Double>(10.0,50.0);
		
		double rect = GenericMethod.<Double,Double>makeRctangle(p1, p2);
		System.out.println("두점의 넓이는 : " + rect +" 입니다. ");
		

		Point <Double,Double> p4 = new Point<Double,Double>(1.0,2.0);
		Point <Double,Double> p3 = new Point<Double,Double>(103.0,500.0);
		
		double rect2= GenericMethod.<Double,Double>makeRctangle(p3, p4);
		System.out.println("두점의 넓이는 : " + rect2 +" 입니다. ");
	}

}
