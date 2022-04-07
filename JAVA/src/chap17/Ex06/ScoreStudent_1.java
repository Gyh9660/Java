package chap17.Ex06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 1. �л��� : 5 ������ ���� �Է� ������ ArrayList�� capacityũ�� ����
 * 2. �����Է� : 1������ ��ǲ���������� �Է¹��� �л��������� �����Է� ArrayList�� ������ü������ for��
 	3. ��������Ʈ : ArrayList�� ����� student ��ü�� �����ͼ� score ���� ���
 	4. �м� : �ְ����� : , �������  :
 	5. ����
 */
class Student{
	int score;		//������ �Է� , �ʵ��� �� �Ҵ�. (1. ��ü ������ ����, 2.private(������, setter/getter)
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
        int studentNum = 0;	//while ����ۿ��� ����, ��������
       // int maxScore = 0; ����������
       // int sum = 0;
        while(run) {		//run =true
            System.out.println("----------------------------------------------------");
            System.out.println("1.�л��� | 2.�����Է� | 3.��������Ʈ | 4.�м� | 5.����");
            System.out.println("----------------------------------------------------");
            System.out.println("����> ");
            int selectNo = scanner.nextInt(); //����, //

            if(selectNo == 1) {
                System.out.println("�л����� �Է��ϼ��� : ");
                	//�ڵ� �ۼ� \
                studentNum = scanner.nextInt();
                //studentNum = sacnner.nextInt(); // �л����� ��ǲ
                arr = new ArrayList<Student>(studentNum);
                System.out.println("�Է¿Ϸ�");
            } else if(selectNo == 2) {
            		//�ڵ��ۼ�
            	System.out.println("�л��� ��ŭ ������ �Է��Ͻÿ�:");
               for(int i=0;i<studentNum;i++) {
            	  System.out.println((i+1)+" �� �л� ������ �Է��ϼ��� : "); 
            	  Student student = new Student(scanner.nextInt());
            	  arr.add(student);
            	  System.out.println("�Է¿Ϸ�"); 
            	 // studentNum+=1; �̷��� �ȵ�.
               }
               /*if (studentNum == 0 ) { //studentNum�� �Ҵ� �޾ƾ� for���� ������ �����Ҽ� �ִ�.
               		System.out.println("�л����� ���� �Է� �ϼ���.");
               		}else {
               			//for ���� ���ؼ� ��ǲ���� �л�����ŭ ������ �Է�
               			 for(int i =0;i<studentNum; i++){ //���������� studentNum
               			 	//��ǲ�� �޾Ƽ� ��ǲ���� ���� Student��ü�� score ������ �Ҵ�.��ü�� �����ؼ� 
               			 	 Student student = new Student(); //�⺻ �����ڸ����� ��ü����, �ʵ忡 �����Ҵ�
               			 	 System.out.print((i + 1)+"�� �л� ������ �Է��ϼ��� : ");
               			 	 student.score = scanner.nextInt(); //�л������� ������ �޾Ƽ� �ʵ忡 ���� �Ҵ�.
               			 	 arr.add(student); //ArrayList�� �ʵ忡 ���� �Ҵ��� ��ü�� ArrayList�� ����
               			 	 System.out.println("�Է¿Ϸ�"); //�Է� �Ϸ��ϰ� ��� �ϰ� ����
               			 	 
               			 }
               		}
               		*/
            } else if(selectNo == 3) {
            		for(int i=0; i<studentNum;i++) {
            			System.out.println(arr.get(i).getScore());
            		}
             //���� ����Ʈ ���, ArrayList �� ������ �Ҵ�� ��ü�� ����, ��ü ������, �ʵ��ǰ��� �������
            /*
             if (studentNum == 0 ){
             	System.out.println("�л����� ���� �Է� �ϼ���.");
             }else {
             	for (int i = 0 ; i<studentNum ; i++){ ArrayList��ü�� �����ͼ� Student.score �ʵ��ǰ��� ���
             		Student student = arr.get(i); //ArrayList�� ������ Student��ü�� ������
             		//System.out.println(student.score); //�ʵ��� ���� ��ü�� ���� ���,
             		System.out.println(Student.getScore()); //�ʵ��� ���� getter�� ���.
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
            System.out.println("�ְ����� : " + maxScore);
            System.out.println("������� : " + (float) sum / studentNum);
            /*
             * if (studnetNum == 0) {
             * 		System.out.println("�л����� ���� �Է� �ϼ���.");
             * }else {
             * 		int maxScore = 0; // �ִ� ������ �޴� ���� <�ʱⰪ�Ҵ�>
             * 		int sum = 0; //�հ踦 �����ϴ� �������� <�ʱⰪ�Ҵ�>
             * 		//1. ArrayList�� ���m�� ������ �´�. 2. Student ��ü�� score �ʵ��� ���� �����ͼ� ó��
             * 		for( int i = 0; i < studentNum; i++) {
             * 			Student student = arr.get(i);
             * 			//�ִ� ���� ������ �Ҵ�
             * 			//3�� �����ڸ� ����ؼ� �ִ밪�� ������ �Ҵ�.
             * 			maxScore = (student.score>maxScore) ? student.score:maxScore;	
             * 			sum += student.score; //sum = sum + student.score
             * 		}
             *		//maxScore ������ ���� ���� ������, sum : ��� ���ھ� ���Ѱ��� ������ ��Ƽ� ���
             *		 System.out.println("�ְ����� : " + maxScore);
             *		 System.out.println("������� : " + (float) sum / studentNum);
             * }
             * 
             */
            } else if(selectNo == 5) {
            	break; //run = false; ==> run false �ϋ� while ���� ��������
              }
        }
        System.out.println ("���α׷� ����");
	}
}
