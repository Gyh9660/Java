package chap19.Ex01;

import java.io.File; //파일과 폴더를 다루는 객체
import java.io.IOException;

//주의 : 이클립스에서 파일을 생성시 C:\ 에 바로 생성하게도면 권한문제로 인한 오류가 발생할 수 있다. 
	//C:\ 안에 직접적으로 만들지말고 폴더를만들고 그안에 만들거나 관리자권한으로 실행
	//1. 이클립스를 관리자권한으로 실행
	//2. 폴더내부에 파일을 생성

//File 객체 내에 폴더 식별자를 적용할경우
			//C:\abc\abc.txt  
	
	// 1. Windows인 경우 : String path = "C:\\abc\\abc.txt"   ""내에 특수문자를 처리하기위한 기호. \
		// <-기본 default 
	// 	Windows 10인 경우: String path = "C:/abc/abc.txt"  사용 가능



	// 2. MAC인 경우 : String path = "C:/abc/abc.txt" 		

	//호환을 위해서 공통적으로 사용할 수 있는 코드 작성.
		// String path = "C:"+ File.separator + "abc" + File.separator + "abc.txt"


public class CreateFileObject {

	public static void main(String[] args) throws IOException {

		//1. File객체를 사용해서 폴더생성. 해당 파일이나 폴더가 존재하지 않는 경우
		File tempDir = new File("C:/temp001");
		if(!tempDir.exists()) {		//해당 경로에 파일이나 폴더가 존재하면 true, 아니면 false
			tempDir.mkdir();  		//폴더 생성 명령어
		}
		System.out.println(tempDir.exists()); //파일이 존재하면 true, 아니면 fasle
		
		//2. File 객체를 사용해서 파일 생성
		File newFile = new File("C:/temp001/newfile.txt"); //C:\ 파일을 생성할 경우 권한문제로 파일생성예외가 발생할수있다. <= 이클립스를 관리자 권한으로 실행(해결방법)
		if(!newFile.exists()) {
			newFile.createNewFile();	//파일을 생성할때 예외가 발생할 수 있다. 예외처리가 필요, 권한문제
		}
		System.out.println(newFile.exists());
		System.out.println();
		
		//3.파일 구분자
		File newFile2 = new File("C:\\temp001\\newfile01.txt"); //Windows 10 하위 버전용
		File newFile3 = new File("C:/temp001/newfile02.txt"); 	//Windows 10, MAC
		if (!newFile2.exists()) {newFile2.createNewFile();}
		if (!newFile3.exists()) {newFile3.createNewFile();}
		System.out.println(newFile2.exists());
		System.out.println(newFile3.exists());
		
		//모든 OS에서 공통으로 식별 가능한 코드
		File newFile4 = new File("C:"+ File.separator + "temp001" + File.separator + "newfile03.txt"); 	//호환되는코드, 
		if (!newFile4.exists()) {newFile4.createNewFile();}
		System.out.println(newFile4.exists());
		
		
		//4. 절대 경로로 처리 : 다른 시스템으로 이동될 경우 그 시스템 환경에 맞도록 셋팅(수정)이 필요함
		File newFile5 = new File("C:/temp001/newfile04.txt"); //절대 경로로 처리
		System.out.println(newFile5.getAbsolutePath()); //file객체에 저장된 파일의 절대경로를 출력
		
		
		
		//5. 상대 경로로 처리 <== 권장
		//현재 나의 작업 폴더의 위치를 알아야 한다.
		System.out.println(System.getProperty("user.dir")); //<== 현재 작업 폴더의 위치
				//이클립스 실행 폴더 위치
		File newFile6 = new File("newfile05.txt"); //상대 경로로 출력
		if (!newFile6.exists()) {newFile6.createNewFile();}
		System.out.println(newFile6.getAbsolutePath());
		
	}

}
