package chap14.Ex09;
class MyAllException extends Exception{ // 일반예외(checked Exveption)
	public MyAllException() {
		super();
	}
	public MyAllException(String message) { //예외 메세지 출력. e.getmessage()
		super(message);
	}
}
class B {
	//private : 캡슐화, 객체생성후 바로 접근하지 못하도록 설정
		// 생성자, setter <== 제어후 필들의 값을 할당.
	private String season;//봄,여름,가을,겨울 (예외발생 : 봄,여름,가을,겨울만 입력하세요)
	private String week;//월,화,수,목,금,토,일 (예외발생 : 월,화,수,목,금,토,일만 입력하세요)
	private int scoreKor; //0~100값만 입력 (예외발생 : 0~100 까지 정수만 입력 하세요)
	private int scoreEng;//0~100값만 입력 (예외발생 : 0~100 까지 정수만 입력 하세요)
	private String userID;//12자이상 20자 사이의 문자 (예외발생 : 12자이상 20자 사이의 문자만 넣으세요)
	
	//하나의 메소드로 처리
	void studentInfo(String season, String week, int scoreKor, int scoreEng, String userID) throws MyAllException {
		if(season != "봄"&&season != "여름"&&season != "가을"&&season != "겨울") {
			throw new MyAllException("예외발생 : 봄,여름,가을,겨울만 입력하세요");
		}else if(week !="월"&&week !="화"&&week !="수"&&week !="목"&&week !="금"&&week !="토"&&week !="일") {
			throw new MyAllException("월,화,수,목,금,토,일 (예외발생 : 월,화,수,목,금,토,일만 입력하세요");
		}else if(scoreKor <0 || scoreKor>100) {
			throw new MyAllException("0~100값만 입력 (예외발생 : 0~100 까지 정수만 입력 하세요");
		}else if(scoreEng <0 || scoreEng>100) {
			throw new MyAllException("0~100값만 입력 (예외발생 : 0~100 까지 정수만 입력 하세요");
		}else if(userID.length() <12 || userID.length()>20) {
			throw new MyAllException("12자이상 20자 사이의 문자 (예외발생 : 12자이상 20자 사이의 문자만 넣으세요");
		}else {
			System.out.println("정상적인 출력");
			this.season=season;
			this.week=week;
			this.scoreKor=scoreKor;
			this.scoreEng=scoreEng;
			this.userID=userID;
		}
		System.out.printf("계절 : "+season+", 요일 : "+week+", 국어 : "+scoreKor+", 영어 : "+scoreEng+", ID : "+userID);
	}
}


public class Ex {

	public static void main(String[] args) {
		B b = new B();
		try {
			b.studentInfo("봄", "월", 50, 70, "123456789012345");
		} catch (MyAllException e) {
			e.printStackTrace(); //void 
			System.out.println(e.getMessage()); //Return String => print로 출력
		}
		System.out.println();
		System.out.println("======================");
		//season 필드 테스트
		try {
			b.studentInfo("뽐", "월", 50, 70, "123456789012345");
		} catch (MyAllException e) {
			System.out.println(e.getMessage());
		}
	}

}
