package chap14.Ex08;

//ID�� ���� NULL�� ��� Exception �߻�
//userID�� 8�� �̻� 20�ڰ� �ƴѰ�� Exception �߻�

//�Ϲ� ���� ����-
class IDFormatException extends Exception { //2���� �����ڸ� ����
	public IDFormatException() {
		super();
	}
	public IDFormatException(String message) { //���ܹ߻��� ���ܿ� ���� �޼����� ���, e.getMessage();
		super(message);
	}
}

public class IDFormatTest {
	
	private String userID;	//üũ : null, 8���̻� 20�ڰ� �ƴ� ��� Exception
	//userID ĸ��ȭ�Ǿ� �ִ�. private : �ܺο��� ������ �Ұ��� ����Ŭ������ ����
		//������, setter�� ����ؼ� ���� �Ҵ�
	//private���� ������ ��� : getter�� setter�� ���
	public String getUserID() { //�޼ҵ� ȣ��� �޸��� userID�� ������
		return userID ;
	}
	public void setUserID(String userID) throws IDFormatException {//setter :�޸��� ���� �Ҵ�.
		if (userID == null) {
			throw new IDFormatException("���̵�� Null�ϼ� �����ϴ�.");
		}else if (userID.length()< 8 ||userID.length()>20) {
			throw new IDFormatException("���̵�� 8���̻� 20�����Ϸ� ��� �����մϴ�");
		}else {
			System.out.println("���������� �� �ԷµǾ����ϴ�.");
		}
		this.userID = userID;
		
	}
	

	public static void main(String[] args) {
		IDFormatTest test = new IDFormatTest();
		
		//1. userID�� null�ΰ��
		String userID = null;
		
		try {
			test.setUserID(userID); //setter ȣ��� null�Է��� ȣ��
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("============================");
		
		//2. userID�� 7�ڸ� ���� ���
		userID = "1234567";
		
		try {
			test.setUserID(userID);
		}catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("==================");
		//3. null�� �ƴϰ� 8���̻� 20�� �̸�
		userID = "123456789";
		
		try {
			test.setUserID(userID);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(test.getUserID());
	}

}
