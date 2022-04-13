package chap19.Ex07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//추가 기능을 제공하는 스트림 : 기반스트림이 존재해야한다. 단독으로 사용할 수 없다.
//BufferedInputStream : InputStream의 필터를 장착해서 읽기 성능을 아주 빠르게 한 스트림. , 단독으로 사용할수 없다. 기반스트림에 추가기능
//BufferedOutputStream : OutputStream의 필터를 장착해서 쓰기 성능을 아주 빠르게 한 스트림. , 단독으로 사용할수 없다. 기반스트림에 추가기능

public class BufferedInput_BufferedOutputStream {

	public static void main(String[] args) {

		//두파일을 복사, Buffered를 사용하지 않고 처리하는 경우, Buffered를 사용하는 경우 속도차리를 비교
		
		File orgfile = new File("src\\chap19\\Ex07\\mycat_origin.jpg");	//원본 파일
		
		File copyfile1 = new File("src\\chap19\\Ex07\\mycat_copy1.jpg");	//Buffered를 사용하지 않고 처리하는 경우
		
		File copyfile2 = new File("src\\chap19\\Ex07\\mycat_copy2.jpg");	//Buffered를 사용해서 처리하는 경우
		
		
		//성능 측정을 하기 위한 변수 선언
		long start, end, time1, time2; //time1 : Buffered(X), time2 : Buffered(O)
		
		//1. Buffered를 사용하지 않고 처리하는 경우 (BufferedInputStream, BufferOutputStream)
	
		
		start = System.nanoTime(); //시작 시간
		
		try(InputStream is = new FileInputStream(orgfile);//Auto close()
			OutputStream os = new FileOutputStream(copyfile1); //Auto close()	
				) {
			//데이터 복사 코드 생성;	
			int data;
			while ((data=is.read())!= -1) { //is에서 1byte 읽어서, -1은 마지막까지
				os.write(data);			//os에 1byte 쓰기
			}
		
		} catch (IOException e) {}
		end = System.nanoTime();
		time1 = end -start;
		System.out.println("Without BufferdXXXStream : " + time1); //Buffered를 사용하지 않고 복사. copy1.jpg
		
		
		//2. Buffered를 사용해서 처리하는 경우( BufferedInputStream, BufferOutputStream)
		
		start = System.nanoTime();
		
		try(InputStream is = new FileInputStream(orgfile);	  //기반 스트림
			BufferedInputStream bis = new BufferedInputStream(is); //추가 기능을 제공하는 스트림 성능을 빠르게 처리 (Buffer 사용함)
			OutputStream os = new FileOutputStream(copyfile2); //기반 스트림
			BufferedOutputStream bos = new BufferedOutputStream(os);// 추가 기능을 제공 (필터)
				) {
			//데이터 복사할 코드 생성
			int data;
			while((data = bis.read())!=-1) { //버퍼를 사용해서 읽기(빠르다)ㅉ
				bos.write(data);			//버퍼를 사용해서 쓰기(빠르다)
			}
		} catch (IOException e) {}
		end = System.nanoTime();
		time2 = end - start;
		System.out.println("With BufferedXXXStream : "+ time2);
		
		//사용한 경우 (time2), 사용하지 않은 경우 (time1)의 비율
		System.out.println("Buffer를 사용한 경우 속도 차이 몇 배 : " + (time1/time2)+ "배 빠름");
		
		
	}

}
