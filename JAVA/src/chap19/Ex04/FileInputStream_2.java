package chap19.Ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class FileInputStream_2 {
	
	public static void main(String[] args) throws IOException {
		
	//1. �Է� ���� ����
		File inFile = new File ("src\\chap19\\Ex04\\FileInputStream_2.txt");
	//2. 1. byte ���� �б�(�� ����Ʈ�� �о ó��) //ó�� �ӵ��� ������.
		InputStream is1= null; //��ü ����, Finally ������� close
		try {
			is1 = new FileInputStream(inFile); //��ü����
			int data ; //byte�� ���� x int�� ����
			while ((data=is1.read())!=-1) {//������ �����Ƿ� read()�޼ҵ常 ���, �ѱ��� ��� read(byte�迭)
				System.out.print((char)data);
				
			}
		} catch (IOException e) {
			System.out.println("������ ã�� ���߽��ϴ�.");
		}finally {
			if(is1 != null) {
				try {
					is1.close(); //null�϶� close �ϸ� IOException
				} catch (IOException e) {

				}
			}
		}
		System.out.println();
		System.out.println("===========Try (with resouce)==================");
		
		//2-2
		
		//1. �Է� ���� ����
				File inFile2 = new File ("src\\chap19\\Ex04\\FileInputStream_2.txt");
				
			//try (With resource : ()�� ��ü���� <== close()�� �ڵ����� �ȴ�, FileInputStream �� Closeable �������̽��� ����
				try(InputStream is2 = new FileInputStream(inFile2)){					int data ;
					while ((data=is2.read())!=-1) {//������ �����Ƿ� read()�޼ҵ常 ���, �ѱ��� ��� read(byte�迭)
						System.out.print((char)data);
						
					}
				} catch (IOException e) {
					System.out.println("������ ã�� ���߽��ϴ�.");
				}
		
		
		//3. 2. n-byte ������ �б�(byte[]�� ó�� ��ġ�������� ���� ������ ����) : ���� byte�� ���ÿ� �о ó���ӵ��� ����.
				//�迭�� ���� ũ�⸸ŭ �о� �鿩�� byte�迭�� �����Ѵ�.
				//�ѱ� ó������
				
			System.out.println();
			System.out.println();
			System.out.println("==========================");
			InputStream is3 = new FileInputStream(inFile2); //throws�� ó��,
			byte[] byteArray1 = new byte[9]; //�迭�� 9��, 0~8����// �迭�� ����Ʈ�迭
			
			int count1;
			while((count1 = is3.read(byteArray1))!= -1) { //-1�� ������ ���������� 
					//is3.read() : 1 byte �� �д´�.
					//is3.read(byteArray1) : �迭�� ũ��(9) byte�� �д´�.
					//count1 : 9, 9, 2 , -1 
				
				
				
				for(int i=0; i<count1; i++) {
					System.out.print((char)byteArray1[i]);
				}
				System.out.println(": count1 =" + count1);
				/*
				System.out.println();
				System.out.println("================");
				String str = new String(byteArray1,Charset.forName("MS949"));
				System.out.println(str);
				System.out.println("================");
				*/
			}
			is3.close();
		
			
			System.out.println("================================");
			//3. 2-1. n-byte ������ �о �ѱ� ó��[�迭 ������ �о �ѱ� ó��]
			InputStream is4 = new FileInputStream(inFile2);
			byte[] byteArray2 = new byte[100];
			
			int count2;
			
			while((count2 =is4.read(byteArray2))!= -1) {//count2 = 100, -1
				System.out.println(new String(byteArray2,Charset.forName("MS949")));
				
			}
			
			System.out.println();
			System.out.println("=============================================================");
			//4. 3. n-byte ������ �о ����. offset, length ���
			
			InputStream is5 = new FileInputStream(inFile2);
			byte[] byteArray3 = new byte[9];
			
			int offset = 3;
			int length = 6;
			int count3 = is5.read(byteArray3, offset, length); //length ��ŭ �տ��� �о�ͼ� byteArray3�� offset ��ġ�� �����ض�
		//length 6 => [������ ���� �а�]FileIn ���� �о�ͼ� [6byte] byteArray3�� �����ϴµ� [0~8����] offset 3 => 3������� FileIn�� �ѹ濡 �ϳ��� �����ض�. �׾տ� 0 1 2 ������ ����?����?����ΰ� offset + length <= byte[]��ũ��// offset + length ���� �迭��ũ�⺸�� �۰ų�(�������� �ڿ������� ������ �ű⵵ ����д�) ���Ƶ� ������ ũ�� �ȵ�.
				
				for(int i =0; i< offset + count3;i++) {
					System.out.print((char)byteArray3[i]);
				}
			is5.close();
			
			
			
			
			
			
			
			
			
			
		
	}

}
