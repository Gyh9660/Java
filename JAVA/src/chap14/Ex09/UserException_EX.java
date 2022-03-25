package chap14.Ex09;


class A{
	String season; //��,����,����,�ܿ� (���ܹ߻� : ��,����,����,�ܿ︸ �Է��ϼ���)
	String week; //��,ȭ,��,��,��,��,�� (���ܹ߻� : ��,ȭ,��,��,��,��,�ϸ� �Է��ϼ���)
	int scoreKor; //0~100���� �Է� (���ܹ߻� : 0~100 ���� ������ �Է� �ϼ���)
	int scoreEng;//0~100���� �Է� (���ܹ߻� : 0~100 ���� ������ �Է� �ϼ���)
	String userID; //12���̻� 20�� ������ ���� (���ܹ߻� : 12���̻� 20�� ������ ���ڸ� ��������)
	
	void check (String season, String week, int scoreKor, int scoreEng, String userID) throws SeasonException, WeekException, ScoreKorException, ScoreEngException, UserIDException {
		if(season != "��"&&season != "����"&&season != "����"&&season !="�ܿ�") {
			throw new SeasonException("���ܹ߻� : ��,����,����,�ܿ︸ �Է��ϼ���");
		}else if(week != "��"&&week != "ȭ" &&week != "��"&&week !="��"&&week != "��"&&week != "��"&&week !="��") {
			throw new WeekException("���ܹ߻� : ��,ȭ,��,��,��,��,�ϸ� �Է��ϼ���");	
		}else if(scoreKor<0||scoreKor>100) {
			throw new ScoreKorException("���ܹ߻� : 0~100 ���� ������ �Է� �ϼ���");
		}else if(scoreEng<0||scoreEng>100){
			throw new ScoreEngException("���ܹ߻� : 0~100 ���� ������ �Է� �ϼ���");
		}else if(userID.length()<12||userID.length()>20) {
			throw new UserIDException("���ܹ߻� : 12���̻� 20�� ������ ���ڸ� ��������");
		}else {
			System.out.println("���������� �� �ԷµǾ����ϴ�.");
			this.season=season;
			this.week=week;
			this.scoreKor=scoreKor;
			this.scoreEng=scoreEng;
			this.userID=userID;
			System.out.println("���� : "+season+", ���� : "+week+", ���� : "+scoreKor+", ���� : "+scoreEng+", ID : "+userID);
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
			a.check("����","��", 60, 70, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("ȭ","��", 60, 70, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("��","����", 60, 70, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("��","��", 601, 70, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("��","��", 60, 170, "12345abcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("========================");
		try {
			a.check("��","��", 60, 70, "12345a345345334534bcderf");
		} catch (SeasonException | WeekException | ScoreKorException | ScoreEngException | UserIDException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
