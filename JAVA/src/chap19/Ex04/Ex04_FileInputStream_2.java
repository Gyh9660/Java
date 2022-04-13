package chap19.Ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

// FileInputSTream
// is1: MS949 한글로 읽기 처리, try (with resource) , 예외 처리
// is2: UTF-8 한글 읽기 처리, try 예외처리S





public class Ex04_FileInputStream_2 {

	public static void main(String[] args) {

		System.out.println("========MS949===========");
		File inFile = new File("src\\chap19\\Ex04\\files\\file-ms949.txt");
		byte[] arr1 = new byte[100];
		try (InputStream is1 = new FileInputStream(inFile)){
			int data;
			while((data = is1.read(arr1))!= -1) {
				String str = new String(arr1,"MS949");
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println("예외가 발생");
		}
		
		
		System.out.println("=========UTF-8===========");
		File inFile2 = new File("src\\chap19\\Ex04\\files\\file-utf-8.txt");
		byte[] arr2 = new byte[200];
		InputStream is2 = null;
		int data2= 0;
		try {
			is2 = new FileInputStream(inFile2);
			while((data2 = is2.read(arr2))!= -1) {
				String str2 = new String(arr2,0,data2,Charset.forName("UTF-8"));
				System.out.println(str2);
			}
		} catch (IOException e) {
			System.out.println("예외가 발생");
		}finally {
			if(is2 != null) {
				try {
					is2.close();
				} catch (IOException e) {
					System.out.println("예외가 발생");
				}
			}
		}
		
		System.out.println("========MS949===========");
		File inFile3 = new File("src\\chap19\\Ex04\\files\\file-ms949.txt");
		try (InputStream is3 = new FileInputStream(inFile3)){
				byte[] arr3 = is3.readAllBytes();
				String str3 = new String(arr3,"MS949");
				System.out.println(str3);
		} catch (IOException e) {
			System.out.println("예외가 발생");
		}
		
		
	}

}
