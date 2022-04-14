package chap19.Ex08;
/*
 * Application Default : MS949
 * reader/Writer �� ���� Ŭ������ ����ϼ���.
 * 
 * 1.�ֿܼ��� �ѱ��� �о
 * C:\Temp\a\aaa.txt(MS949)
 * C:\Temp\b\bbb.txt(UTF-8)
 * ���Ͽ� ������
 * 
 * a,b������ Application���� ����
 * 
 * 2.�� ���Ͽ��� ���� ������ �ֿܼ� ���� ���� ���
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ex_Reader_Writer {

	public static void main(String[] args) {
		
		File file = new File("C:\\Temp\\a\\aaa.txt"); //MS949
		File file2 = new File("C:\\Temp\\b\\bbb.txt"); //UTF-8
		
		try(InputStreamReader isr = new InputStreamReader(System.in);	
			OutputStream os = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(os, "MS949");
		
			InputStreamReader isr2 = new InputStreamReader(System.in);	
			OutputStream os2 = new FileOutputStream(file2);
			OutputStreamWriter osw2 = new OutputStreamWriter(os2, "UTF-8");	){
				
			System.out.println("�ѱ��� ���ϴ� ��� �Է� �ϼ���(MS949) >>");
			
			int data;
			while((data = isr.read())!= '\r') { 
				 osw.write((char)data);
			}
				osw.flush();
				
			
			System.out.println("�ѱ��� ���ϴ� ��� �Է� �ϼ���(UTF-8) >>");
			int data2;
			while((data2 = isr2.read())!= '\r') { 
				 osw2.write((char)data2);
			}
				osw2.flush();
			} catch (Exception e) {}
			
			System.out.println();
		
		
			System.out.println("========�ֿܼ� ���=========");
			
			System.out.println();
			
			try (InputStream is = new FileInputStream(file);
				 InputStreamReader isr1 = new InputStreamReader(is);
				 
				 InputStream is2 = new FileInputStream(file2);
				 InputStreamReader isr2 = new InputStreamReader(is2,"UTF-8");){ 
				
				int data;
				while((data=isr1.read())!= -1) {
					System.out.print((char)data);
					}
				System.out.println();
				int data2;
				System.out.println();
				while((data2=isr2.read())!= -1) {
					System.out.print((char)data2);
					}	
					
				} catch (Exception e) {}	
			
				System.out.println();
		
	
		
	}

}
