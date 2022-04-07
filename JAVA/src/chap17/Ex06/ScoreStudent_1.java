package chap17.Ex06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 1. 학생수 : 5 임의의 값을 입력 했을때 ArrayList의 capacity크기 지정
 * 2. 점수입력 : 1번부터 인풋받은값까지 입력받은 학생수에따라서 점수입력 ArrayList에 각각객체를저장 for문
 	3. 점수리스트 : ArrayList에 저장된 student 객체를 가져와서 score 값을 출력
 	4. 분석 : 최고점수 : , 평균점수  :
 	5. 종료
 */
class Student{
	int score;		//점수를 입력 , 필드의 값 할당. (1. 객체 생성후 직접, 2.private(생성자, setter/getter)
	public Student() {
		
	}
	public Student(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

public class ScoreStudent_1 {

	public static void main(String[] args) {

        ArrayList<Student> arr = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int studentNum = 0;	//while 블락밖에서 선언, 전역변수
       // int maxScore = 0; 지역변수로
       // int sum = 0;
        while(run) {		//run =true
            System.out.println("----------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("----------------------------------------------------");
            System.out.println("선택> ");
            int selectNo = scanner.nextInt(); //선택, //

            if(selectNo == 1) {
                System.out.println("학생수를 입력하세요 : ");
                	//코드 작성 \
                studentNum = scanner.nextInt();
                //studentNum = sacnner.nextInt(); // 학생수를 인풋
                arr = new ArrayList<Student>(studentNum);
                System.out.println("입력완료");
            } else if(selectNo == 2) {
            		//코드작성
            	System.out.println("학생수 만큼 점수를 입력하시오:");
               for(int i=0;i<studentNum;i++) {
            	  System.out.println((i+1)+" 번 학생 점수를 입력하세요 : "); 
            	  Student student = new Student(scanner.nextInt());
            	  arr.add(student);
            	  System.out.println("입력완료"); 
            	 // studentNum+=1; 이러면 안됨.
               }
               /*if (studentNum == 0 ) { //studentNum을 할당 받아야 for문의 범위를 지정할수 있다.
               		System.out.println("학생수를 먼저 입력 하세요.");
               		}else {
               			//for 문을 통해서 인풋받은 학생수만큼 점수를 입력
               			 for(int i =0;i<studentNum; i++){ //종료지점이 studentNum
               			 	//인풋을 받아서 인풋받은 값을 Student객체의 score 변수에 할당.객체를 생성해서 
               			 	 Student student = new Student(); //기본 생성자를통해 객체생성, 필드에 직접할당
               			 	 System.out.print((i + 1)+"번 학생 점수를 입력하세요 : ");
               			 	 student.score = scanner.nextInt(); //학생점수를 ㅇㅂ력 받아서 필드에 값을 할당.
               			 	 arr.add(student); //ArrayList에 필드에 값을 할당한 객체를 ArrayList에 저장
               			 	 System.out.println("입력완료"); //입력 완료하고 출력 하고 개행
               			 	 
               			 }
               		}
               		*/
            } else if(selectNo == 3) {
            		for(int i=0; i<studentNum;i++) {
            			System.out.println(arr.get(i).getScore());
            		}
             //점수 리스트 출력, ArrayList 각 점수가 할당된 객체가 저장, 객체 생성후, 필드의값을 직접출력
            /*
             if (studentNum == 0 ){
             	System.out.println("학생수를 먼저 입력 하세요.");
             }else {
             	for (int i = 0 ; i<studentNum ; i++){ ArrayList객체를 가져와서 Student.score 필드의값을 출력
             		Student student = arr.get(i); //ArrayList의 각방의 Student객체를 가져옴
             		//System.out.println(student.score); //필드의 값을 객체로 직접 출력,
             		System.out.println(Student.getScore()); //필드의 값을 getter로 출력.
             	}
             }
             */
            } else if(selectNo == 4) {
            	int maxScore = 0;
                int sum = 0;
            	for(int i=0; i<arr.size();i++) {
            		if(maxScore<arr.get(i).getScore()) {
            			maxScore = arr.get(i).getScore();
            			sum+=arr.get(i).getScore();
            		}
            	}
            System.out.println("최고점수 : " + maxScore);
            System.out.println("평균점수 : " + (float) sum / studentNum);
            /*
             * if (studnetNum == 0) {
             * 		System.out.println("학생수를 먼저 입력 하세요.");
             * }else {
             * 		int maxScore = 0; // 최대 점수를 받는 변수 <초기값할당>
             * 		int sum = 0; //합계를 저장하는 지역변수 <초기값할당>
             * 		//1. ArrayList의 객쳋를 가지고 온다. 2. Student 객체의 score 필드의 값을 가져와서 처리
             * 		for( int i = 0; i < studentNum; i++) {
             * 			Student student = arr.get(i);
             * 			//최대 값을 변수에 할당
             * 			//3항 연산자를 사용해서 최대값을 변수에 할당.
             * 			maxScore = (student.score>maxScore) ? student.score:maxScore;	
             * 			sum += student.score; //sum = sum + student.score
             * 		}
             *		//maxScore 변수의 최조 값을 적용후, sum : 모든 스코어 더한값을 변수에 담아서 출력
             *		 System.out.println("최고점수 : " + maxScore);
             *		 System.out.println("평균점수 : " + (float) sum / studentNum);
             * }
             * 
             */
            } else if(selectNo == 5) {
            	break; //run = false; ==> run false 일떄 while 문을 빠져나옴
              }
        }
        System.out.println ("프로그램 종료");
	}
}
