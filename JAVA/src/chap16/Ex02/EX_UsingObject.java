package chap16.Ex02;
//Object�� ����ؼ� 4���� ��ü�� ������ ���
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
		return "�̸� : "+ name + ", id : "+ id + ", pass : "+ pass;
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
		return "�̸� : "+name + ", year : " + year + ", email : " +email;
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
		return "�̸� : "+name + ", run : " + run;
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
		return "�̸� : "+name + ", color : " + color + " , price : " + price;
	}
}
class Good{ 
	private Object object = new Object();

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}	
public class EX_UsingObject {

	public static void main(String[] args) {
		
		Good goods1 = new Good();
		goods1.setObject(new Student("ȫ�浿","hong",19));
		System.out.println((Student)goods1.getObject());
		
		Good goods2 = new Good();
		goods2.setObject(new Professor("������", 3, "kim@naver.com"));
		System.out.println((Professor)goods2.getObject());
		
		Good goods3 = new Good();
		goods3.setObject(new Tiger("ȣ����", "�޸���"));
		System.out.println((Tiger)goods3.getObject());
		
		Good goods4 = new Good();
		goods4.setObject(new Banana("�ٳ���", "���", 10000));
		System.out.println((Banana)goods4.getObject());
	}

}
