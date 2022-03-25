package chap14.Ex08;

//ID의 값을 NULL일 경우 Exception 발생
//userID가 8자 이상 20자가 아닌경우 Exception 발생

//일반 예외 생성-
class IDFormatException extends Exception { //2개의 생성자만 구성
	public IDFormatException() {
		super();
	}
	public IDFormatException(String message) { //예외발생시 예외에 대한 메세지가 출력, e.getMessage();
		super(message);
	}
}

public class IDFormatTest {
	
	private String userID;	//체크 : null, 8자이상 20자가 아닌 경우 Exception
	//userID 캡슐화되어 있다. private : 외부에서 접근이 불가능 같은클래스만 가능
		//생성자, setter를 사용해서 값을 할당
	//private으로 설정된 경우 : getter나 setter를 사용
	public String getUserID() { //메소드 호출시 메모리의 userID를 던져줌
		return userID ;
	}
	public void setUserID(String userID) throws IDFormatException {//setter :메모리의 값을 할당.
		if (userID == null) {
			throw new IDFormatException("아이디는 Null일수 없습니다.");
		}else if (userID.length()< 8 ||userID.length()>20) {
			throw new IDFormatException("아이디는 8자이상 20자이하로 사용 가능합니다");
		}else {
			System.out.println("정상적으로 잘 입력되었습니다.");
		}
		this.userID = userID;
		
	}
	

	public static void main(String[] args) {
		IDFormatTest test = new IDFormatTest();
		
		//1. userID가 null인경우
		String userID = null;
		
		try {
			test.setUserID(userID); //setter 호출시 null입력후 호출
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("============================");
		
		//2. userID를 7자를 넣은 경우
		userID = "1234567";
		
		try {
			test.setUserID(userID);
		}catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("==================");
		//3. null이 아니고 8자이상 20자 미만
		userID = "123456789";
		
		try {
			test.setUserID(userID);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(test.getUserID());
	}

}
