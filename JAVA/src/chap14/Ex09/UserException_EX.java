package chap14.Ex09;


class A{
	String season; //봄,여름,가을,겨울 (예외발생 : 봄,여름,가을,겨울만 입력하세요)
	String week; //월,화,수,목,금,토,일 (예외발생 : 월,화,수,목,금,토,일만 입력하세요)
	int scoreKor; //0~100값만 입력 (예외발생 : 0~100 까지 정수만 입력 하세요)
	int scoreEng;//0~100값만 입력 (예외발생 : 0~100 까지 정수만 입력 하세요)
	String userID; //12자이상 20자 사이의 문자 (예외발생 : 12자이상 20자 사이의 문자만 넣으세요)
	
	void check (String season, String week, int scoreKor, int scoreEng, String userID) throws SeasonException, WeekException, ScoreKorException, ScoreEngException, UserIDException {
		if(season != "봄"&&season != "여름"&&season != "가을"&&season !="겨울") {
			throw new SeasonException("예외발생 : 봄,여름,가을,겨울만 입력하세요");
		}else if(week != "월"&&week != "화" &&week != "수"&&week !="목"&&week != "금"&&week != "토"&&week !="일") {
			throw new WeekException("예외발생 : 월,화,수,목,금,토,일만 입력하세요");	
		}else if(scoreKor<0||scoreKor>100) {
			throw new ScoreKorException("예외발생 : 0~100 까지 정수만 입력 하세요");
		}else if(scoreEng<0||scoreEng>100){
			throw new ScoreEngException("예외발생 : 0~100 까지 정수만 입력 하세요");
		}else if(userID.length()<12||userID.length()>20) {
			throw new UserIDException("예외발생 : 12자이상 20자 사이의 문자만 넣으세요");
		}else {
			System.out.println("정상적으로 잘 입력되었습니다.");
			this.season=season;
			this.week=week;
			this.scoreKor=scoreKor;
			this.scoreEng=scoreEng;
			this.userID=userID;
			System.out.println("계절 : "+season+", 요일 : "+week+", 국어 : "+scoreKor+", 영어 : "+scoreEng+", ID : "+userID);
		}
	}
		
}
class SeasonException extends Exception{
	public SeasonException() {
		super();
	}
	public SeasonException(String message) {
		super(message);
	}
}

class WeekException extends Exception{
	public WeekException() {
		super();
	}
	public WeekException(String message) {
		super(message);
	}
}

class ScoreKorException extends Exception{
	public ScoreKorException() {
		super();
	}
	public ScoreKorException(String message) {
		super(message);
	}
}

class ScoreEngException extends Exception{
	public ScoreEngException() {
		super();
	}
	public ScoreEngException(String message) {
		super(message);
	}
}

class UserIDException extends Exception{
	public UserIDException() {
		super();
	}
	public UserIDException(String message) {
		super(message);
	}
}

public class UserException_EX {

	public static void main(String[] args) {

		A a = new A();
		
		try {
			a.check("여름","월", 60, 70, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("화","월", 60, 70, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("봄","여름", 60, 70, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("봄","월", 601, 70, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("봄","월", 60, 170, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("봄","월", 60, 70, "12345a345345334534bcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
