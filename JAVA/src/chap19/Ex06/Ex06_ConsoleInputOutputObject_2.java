package chap19.Ex06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex06_ConsoleInputOutputObject_2 {

	public static void main(String[] args) throws IOException {

		//1.�ֿܼ��� �ѱ��� ��ǲ (System.in) <== byte[] �迭�� �����ؼ� ó�� : �ѱ��� ó���� �� �ִ�.
		InputStream is = System.in; //new�� �������� �ʰ� ���Ḹ ����, �ֿܼ��� ��ǲ ���� �޴´�.
		
		System.out.println("�ѱ��� �Է� �ϼ��� >>>");
		
		byte[] byteArray1 = new byte[100];
		int count1 = is.read(byteArray1); // byteArray1�� byte�� \r��\n�������� ��ü�� ���� ,count1 �迭�� ���� ���� ����,
		//int data = 1s.read(); �ѱ��� ó������ ���Ѵ�. data���� 1byte read�� ���� ����.
		
		
		
		
		//2. ��ǲ ���� �ѱ��� ���Ͽ� ����(FileOutputStream)
		File f1 = new File("src/chap19/Ex06/input2.txt");
		OutputStream fos = new FileOutputStream(f1); //���� ����
		
		fos.write(byteArray1); //�޸𸮿�(����/RAM)�� ������ 
		fos.flush();			//���ۿ� ���� ������ ���Ͽ��� ����.
		
		
		
		//3. ����� ���Ͽ��� ���� �о�´�.(FileInputStream)
		
		InputStream fis = new FileInputStream(f1);// read()������ �ѱ� ó���� �� �� ����. read(byte[]) : �ѱ� ó��
		byte[] byteArray2 = new byte[100];
		
		int count2 = fis.read(byteArray2); //read(byte[])�� �־�� �ѱ� ó�� ����
		//int data2 = fis.read();  read
		
		
		System.out.println();
		System.out.println("���Ͽ��� ���� ������ �ֿܼ� ��� �մϴ�. >>>>");
		System.out.println();
		
		
		//4. �о�� �迭�� �ֿܼ� ��� �Ѵ�. (System.out)
		
		OutputStream os = System.out; // �ֿܼ� ��� : byte[]
		os.write(byteArray2);
		os.flush();
		
		
		is.close();
		fis.close();
		fos.close();
		os.close();
		
		
		
		
		
		
		
	}

}
