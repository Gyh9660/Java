package chap19.Ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/*
 * 	1. is1  <== InputStream ��ü (�����η� ����: ms949.txt), ����ó��
 * 	2. is2	<== InputStream ��ü (����η� ����: utf-8.txt), ����ó��(try ~with resource�� ����ó��
 * 				close()�޼ҵ带 �ڵ����� ó��
 */



public class Ex3_Exception1 {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("=====ms949 ������ 1==========");
		File file1 = new File("D:\\gyh\\JAVA\\src\\chap19\\Ex04\\Exception-ms949.txt");
		System.out.println(file1.getAbsolutePath());
		InputStream is1 = null;
		Reader reader1 = null;
		BufferedReader in1 = null;
		try {
			is1 = new FileInputStream(file1);
			reader1 = new InputStreamReader(is1);
			in1 = new BufferedReader(reader1);
		} catch (FileNotFoundException e) {
			System.out.println("������ ���� ���� �ʽ��ϴ�.");
		}
		
		int data;
		try {
			while((data = in1.read()) != -1) { 
				System.out.print((char)data);
			}
		} catch (IOException e) {
			System.out.println("������ ���� ���ϴ� ���ܰ� �߻��Ǿ����ϴ�.");
		}finally {
			try {
				if (is1 != null) {
					is1.close();
				}
				if (reader1 != null) {
					reader1.close();
				}
				if (in1 != null) {
					in1.close();
				}
			}catch (IOException e) {
				System.out.println("���ܰ� �߻��߽��ϴ�.");
			}
		}
		
		
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("=====ms949 ������ 2==========");
		
		File file4 = new File("D:\\gyh\\JAVA\\src\\chap19\\Ex04\\Exception-ms949.txt");
		
		System.out.println(file1.getAbsolutePath());
		
		InputStream is4 = null;
		try {
			is4 = new FileInputStream(file4);
			byte[] array2= is4.readAllBytes();
			String str2 = new String(array2,"MS949");
			System.out.println(str2);
		} catch (IOException e1) {
			System.out.println("���ܹ߻�.");
			e1.printStackTrace();
		}finally {
			if (is4 != null) {
				try {
					is4.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("���ܰ� �߻��߽��ϴ�.");
				}
			}
		}
		

		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("=====ms949 ������ 3==========");
		//is5 = �����η� ���� -ms949.txt ����ó�� try ���� �ǿ���
		File file5 = new File("D:\\gyh\\JAVA\\src\\chap19\\Ex04\\Exception-ms949.txt");
		
		System.out.println(file5.getAbsolutePath());
		InputStream is5 = null; //���� ������ ����. finally������� is5.close()
	
		byte[] arr5 = new byte[100];
		
		try {
			is5 = new FileInputStream(file5);
		} catch (FileNotFoundException e2) {
			System.out.println("���� ���������ʽ��ϴ�.");
		}
		
		int data5=0;
		
		try {
			while((data5 = is5.read(arr5))!= -1) {
				String str5 = new String(arr5, 0, data5, Charset.forName("MS949"));
				System.out.println(str5);
			}
		} catch (IOException e2) {
			System.out.println("����");
		}finally {
			if(is5 != null) {
				try {
					is5.close();
				} catch (IOException e) {
					System.out.println("����");
				}
			}
		}

		System.out.println();
		System.out.println();
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//3-2 ���� Ʈ����ĳġ ���� Exception�� ���ؼ� ���� try catch�� ó��
		System.out.println("=====ms949 ������ 3-2==========");
		InputStream is6 = null; //���� ������ ����. finally������� is5.close()
		
		byte[] arr6 = new byte[100]; 
		//�ѱ� ó�� #1 : byte[] ����
	
		int data6=0;
		try {
			is6 = new FileInputStream(file5); //FileNotFoundException
			
			
			while((data6 = is6.read(arr6))!= -1) { //IOException
				//�ѱ� ó�� #2 : read(byte�迭)
				String str6 = new String(arr6, 0, data6, Charset.forName("MS949"));
				//�ѱ� ó�� #3 : String(byte�迭,offset,length,Charset.forName("encoding"))
				System.out.println(str6);
			}
		} catch (IOException e2) {
			System.out.println("����");
		}finally {
			if(is6 != null) {	//is6�� null�� �ƴҶ� ��ü�� �޸𸮿��� ����
				try {
					is6.close();
				} catch (IOException e) {
					System.out.println("����");
				}
			}
		}
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//2. is2 : ����η� ���� -utf-8.txt , ����ó�� try~with resource�� ����ó��
		System.out.println("==========utf-8 ����� 1==========");
		
		File file2 = new File("src/chap19/Ex04/Exception-utf-8.txt");
		System.out.println(file2.getAbsolutePath());
		
		 
		try (InputStream is2 = new FileInputStream(file2)){
			//try (..) ..�� �־������
			Reader reader2 = new InputStreamReader(is2,"UTF-8");
			//Reader reader2 = new InputStreamReader(is2);
			//is2�ڿ� UTF-8�� ��������� ���ڰ� �������ʰ���
			BufferedReader in2 = new BufferedReader(reader2);
			int data2;
			while((data2 = in2.read()) != -1) { 
				System.out.print((char)data2);
			}
		} catch (IOException e) {
			System.out.println("���ܹ߻�.");
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("==========utf-8 ����� 2==========");
		
		File file3 = new File("src/chap19/Ex04/Exception-utf-8.txt");
		System.out.println(file3.getAbsolutePath());
		try (InputStream	is3 = new FileInputStream(file3)){
			byte[] array1 = is3.readAllBytes();
			String str1 = new String(array1,"UTF-8");
			//String str1 = new String(array1,"UTF-8");
			//array1�ڿ� UTF-8�� ��������� ���ڰ� �������ʰ���
			System.out.println(str1);
			
		} catch (IOException e) {
			System.out.println("���ܹ߻�.");
			e.printStackTrace();

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("==========utf-8 ����� 3==========");
		
		File file7 = new File("src/chap19/Ex04/Exception-utf-8.txt");
		System.out.println(file7.getAbsolutePath());
		try (InputStream is7 = new FileInputStream(file3)){
			byte[] array7 = is7.readAllBytes();
			String str7 = new String(array7,"UTF-8");
			System.out.println(str7);
			
		} catch (IOException e) {
			System.out.println("���ܹ߻�.");
			e.printStackTrace();
		}

		System.out.println("==========utf-8 ����� 3-2==========");
		
		byte[] arr8 = new byte[100];
			// �ѱ�ó�� #1
		int data8 = 0;
		
		try (InputStream is8 = new FileInputStream(file7))
			//try (with resourse : ��ü ����, RAM�� ���) <= close() �ڵ����� ó���ȴ�. AutoCloseable�� close() ������ Ŭ�������� �Ѵ�.
			{
			while((data8=is8.read(arr8))!=-1) {
				//�ѱ� ó�� #2 : is.read(byte�迭);
				String str8 = new String(arr8, 0, data8, Charset.forName("UTF-8"));
				//�ѱ� ó�� #3 : new String(byte �迭,[offset,length,]<==���� ����"encoding");
				System.out.println(str8);
			}
		} catch (IOException e) {
			System.out.println("���� �߻�");
		}
	
	
	
	
	
	
	
	}
}
