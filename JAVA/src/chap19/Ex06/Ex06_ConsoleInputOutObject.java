package chap19.Ex06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

// �ֿܼ��� �迭 100byte ���� �ѱ��� ��ǲ ���� ���� input.txt�� ���� �� ,charSet : Default
// input.txt ���Ͽ��� ���� �о �ֿܼ� ���.

//���� throws�� ó��



public class Ex06_ConsoleInputOutObject {

	public static void main(String[] args) throws IOException {
		File outFile = new File ("src/chap19/Ex06/input.txt");
		
		InputStream is = new FileInputStream(outFile);
		System.out.println("========�ֿܼ� �� �Է�=============");
		System.out.println("�Է��ϼ���>>");
		
		InputStream is2 = System.in;
		
		byte[] isArray2 = new byte[100];
		int count2 = is2.read(isArray2);
		String str2 = new String (isArray2, 0, count2, Charset.defaultCharset());
<<<<<<< HEAD
		System.out.println(str2);//String �κ��� �����
=======
		System.out.println(str2);
>>>>>>> f9947f560b44ba7c875cf07602da956846341778
		
		System.out.println("============input.txt�� �� ����=============");
		
		OutputStream os = new FileOutputStream(outFile);
		OutputStream os2 = System.out;
		
		byte[] osArray1 = str2.getBytes(Charset.defaultCharset());
<<<<<<< HEAD
		//str.getbytes���ƴ϶� �׳� isArray2�����ϸ� ��
		
		os.write(osArray1,0,count2);
		// �迭�� 0 �� count1�� �������ָ� ���� �迭�κ��� ������..?
=======
		
		os.write(osArray1,0,count2);
		
>>>>>>> f9947f560b44ba7c875cf07602da956846341778
		os.flush();
		
		System.out.println();
		
		System.out.println("==========input.txt�� �� �о����============");
		byte[] isArray1 = new byte[100];
		int count1 = is.read(isArray1);
		String str1 = new String (isArray1, 0, count1, Charset.defaultCharset());
		System.out.println(str1);
<<<<<<< HEAD
		//String �κ� ������.
		System.out.println("==============System.out���� �ֿܼ� ���============");
		os2.write(isArray1, 0, count1);
		//isArray1�� �����ص���.
		os2.flush();
		
		os2.close();
		os.close();
		is.close();
		is2.close();
		//is~os ���� close�������
=======
		
		System.out.println("==============System.out���� �ֿܼ� ���============");
		os2.write(isArray1, 0, count1);
		
		os2.flush();
		
		os2.close();
>>>>>>> f9947f560b44ba7c875cf07602da956846341778
	}

}
