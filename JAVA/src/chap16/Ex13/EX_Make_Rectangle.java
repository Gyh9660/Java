package chap16.Ex13;

//�� ���� ��ǥ ���� ����ؼ� ���̸� ���ϴ� ���α׷��� �ۼ� �ϼ���.. ���ʸ� Ŭ����/���ʸ� �޼ҵ���

class Point <T,V>{ //������ ��ǥ�� ��� Ŭ����
	T x ;	//������ x��ǥ
	V y ;	//������ y��ǥ
	
	Point(T x, V y){ // ������. Setter��� �����ڸ����� �����ǰ�(��ǥ) �Ҵ�
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
		// �ڵ� �ۼ�
		double left = ((Double)p1.getX()).doubleValue();
		double right = ((Double)p2.getX()).doubleValue();
		double top = ((Double)p2.getY()).doubleValue();
		double bottom = ((Double)p1.getY()).doubleValue();
		
		//double width = right-left;
		double width = (double)p2.getX()-(double)p1.getX();
		double height = top-bottom;
		
		return width * height; //���� * ���� = ���̸� ����
		
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
		System.out.println("������ ���̴� : " + rect +" �Դϴ�. ");
		

		Point <Double,Double> p4 = new Point<Double,Double>(1.0,2.0);
		Point <Double,Double> p3 = new Point<Double,Double>(103.0,500.0);
		
		double rect2= GenericMethod.<Double,Double>makeRctangle(p3, p4);
		System.out.println("������ ���̴� : " + rect2 +" �Դϴ�. ");
	}

}
