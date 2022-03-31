package chap16.Ex05;

class Student{
	String name;
	String id;
	int pass;

	Student(String name, String id, int pass){
		this.name = name;
		this.id = id;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "이름 : "+ name + ", id : "+ id + ", pass : "+ pass;
	}
}
class Professor{
	String name;
	int year;
	String email;
	
	Professor(String name, int year, String email){
		this.name = name;
		this.year = year;
		this.email = email;
	}
	@Override
	public String toString() {
		return "이름 : "+name + ", year : " + year + ", email : " +email;
	}
}
class Tiger{
	String name;
	String run;
	
	Tiger(String name, String run){
		this.name = name;
		this.run = run;
	}
	@Override
	public String toString() {
		return "이름 : "+name + ", run : " + run;
	}
}
class Banana{
	String name;
	String color;
	int price;
	
	Banana(String name, String color, int price){
		this.name = name;
		this.color = color;
		this.price = price;
	}
	@Override
	public String toString() {
		return "이름 : "+name + ", color : " + color + " , price : " + price;
	}
}
//이게맞음
class B<Q>{
	private Q q;

	public Q getQ() {
		return q;
	}

	public void setQ(Q q) {
		this.q = q;
	}
	
}

class A<T,V,C>{
	private T t;
	private V v;
	private C c;
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
}

public class EX_Object_Generic {

	public static void main(String[] args) {

		A<String,String,Integer> a1 = new A<String,String,Integer>();
		a1.setT("홍길동");
		a1.setV("hong");
		a1.setC(19);
		System.out.println(a1.getT());
		System.out.println(a1.getV());
		System.out.println(a1.getC());
		System.out.println("===================");
		
		A<String,Integer,String> a2 = new A<String,Integer,String>();
		a2.setT("이순신");
		a2.setV(4);
		a2.setC("lee@naver.com");
		System.out.println(a2.getT());
		System.out.println(a2.getV());
		System.out.println(a2.getC());
		System.out.println("===================");
		
		A<String,String,Void> a3 = new A<String,String,Void>();
		a3.setT("호랑이");
		a3.setV("달립니다");
		System.out.println(a3.getT());
		System.out.println(a3.getV());
		System.out.println("====================");
		
		A<String,String,Integer> a4 = new A<String,String,Integer>();
		a4.setT("바나나");
		a4.setV("노랑색");
		a4.setC(10000);
		System.out.println(a4.getT());
		System.out.println(a4.getV());
		System.out.println(a4.getC());
		
		//이게 맞음
		B<Student> b1 = new B<Student>();
		b1.setQ(new Student("홍","길",29));
		System.out.println(b1.getQ());
		
	}

}
