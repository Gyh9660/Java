package chap19.Ex05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//InputStream : �߻� Ŭ���� <== FileInputStream�� InputStream�� ������ Ŭ����
//OutputStream : �߻� Ŭ���� <== FileOutputStream�� OutputStream�� ������ Ŭ����
//FileInputStream : byte() ���� ������ �б�
//FileOutputStream : byte() ���� ������ ����


// Windows �ܼ�, �޸��� Enter �� ������ : \r\n
// MAC : \n

public class FileOutputStream_1 {

	public static void main(String[] args) throws IOException {
		
		//1. �Է� ���� ����(�������� ����)
		File outFile = new File ("src/chap19/Ex05/FileOutput1.txt");
		
		//2. 1- byte �б�
		OutputStream os1 = new FileOutputStream(outFile); //����ó��
			//FileOutputStream�� �������� �ʴ� ������ ������ ����� ������
			//FileInputStream�� ��ο� ������ �����ؾߵ�, ���ܹ߻�
		
		os1.write('J'); //write�� IOEXception �߻� ����ó��
		os1.write('A'); //write�� IOEXception �߻� ����ó��
		os1.write('V'); //write�� IOEXception �߻� ����ó��
		os1.write('A'); //write�� IOEXception �߻� ����ó��
		os1.write('\r');	//13 <== ���� ����
		os1.write('\n'); 	//10
	
				//�߿� : write() �޼ҵ�� �޸� (����)�� ����, ���۰� ������ ���Ͽ� ����
				//		flush() : ���ۿ� ����� ������ ���Ͽ� ������ ���� �Ҵ� ���
		
		os1.flush(); //���۰� �� ���� �ʴ��� ������ ���Ͽ� ���⸦ �Ѵ�., <== �������������� write()�� ����ϸ� flush()�� ����Ұ��� ����
		os1.close(); //close() ȣ��� flush() ���� �۵���
		
		//2. n-byte ���� ���� (byte[]�� offset���� length���� byte ������ ����)
		OutputStream os2 = new FileOutputStream(outFile); //����ó���ʿ� //�����
		//OutputStream os2 = new FileOutputStream(outFile,true);//true�� ������ �̾��, �⺻������ false�� �ԷµǾ��ְ�(�����Ǿ�����) �̴� ������� FileOutputStream(File o, Boolean append)
		byte[] byteArray1 = "Hello!".getBytes();	//String ---> byte�� ��ȯ : getBytes()
		
		os2.write(byteArray1);
		os2.write('\n'); //\r�� ��������, \n�� �־ Windows���� Enter ó������.
		
		os2.flush();
		os2.close();		//����Ⱑ �ȴ�.
		
		
		//3. n-byte ���� ���� (byte[]�� offset���� length���� byte ������ ����)
		OutputStream os3 = new FileOutputStream(outFile,true);//�̾��
		
		byte[] byteArray2 ="Better the last smile than the first laughter".getBytes();
		os3.write(byteArray2, 7, 8); // write �ϋ��� offset�ڿ��� length �о ����. 7byte �ں��� 8byte�д´�.
									//read �϶��� �ݴ�� ó��. 8�� �о�ͼ� 7������� ����
		os3.flush();
		os3.close();
		
		
		
		
	}
	

}
