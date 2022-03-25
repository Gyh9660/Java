package chap14.Ex05;
//직접 생성한 객체에서 AutoCloseable를 사용해본다
	//try (객체 생성구문 ) {} catch {} : 자동으로 close() 된다//try(with Resource)
	//1. AutoCloseable 인터페이스의 close() 메소드를 오버라이딩 구현 해야 한다.

	//java.lang.AutoCloseable : java.lang<====import 문을 사용하지 않아도 된다.
	//java.lang.Object

	//예외를 처리하는 방법
		//1. try catch 를 사용해서 예외 처리 : 자신이 직접 예외를 처리 하겠다.
		//2. throws를 통해서 예외를 처리하는 방법 : 예외를 내가 처리하지 않고 호출하는 곳에서 예외를 처리 하도록 미룬다.
				//예외 저낙. 메소드 예외 전가
			//throw : 예외를 강제로 발생시킨다.
class A implements AutoCloseable{
	String resource; //resource = null
	
	A(String resource){ //생성자의 매개변수로 String값을 받아서 메모리로 로딩
		this.resource=resource;
	}
	@Override
	public void close() throws Exception { //close ()메소드가 자동으로 호출 된다.
		System.out.println(resource);
		
		if (resource != null) {
			resource = null;
			System.out.println("리소스가 해제 되었습니다.");
			System.out.println(resource);
		}
	}
}

public class TryWithResource_2 {

	public static void main(String[] args) {
		//1. 자동 리소스 해제 사용
		try(A a1 = new A ("특정파일");){
			
		}catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
		}//finally 블락에 al.close()메소드를 자동으로 호출함.
		
		
		System.out.println("==============");
		
		
		//2. 수동으로 리소스 해제
		A a2 = null;
		try {
			a2 = new A("생성자 초기값 할당");
		}catch (Exception e) {
			
		}finally {
			if(a2.resource != null) {
				try {
					a2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		
		
		
	}
}
