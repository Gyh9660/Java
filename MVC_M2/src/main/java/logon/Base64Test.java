package logon;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//기본 제공됨

public class Base64Test {

	public static void main(String[] args) {
		base64(); //메인 메소드에서 자신의 클래스에있는 다른 메소드 호출( static 메소드)
		
		
	}

	public static void base64() {
		
		String text = "1234"; // 인코딩할 데이터를 변수에 등록
							  // 인코딩 : 암호화
		
		//인코딩 전 텍스트를 byte 배열에 저장.
		
		byte[] targetBytes = text.getBytes();
		
		/// 인코딩
		Encoder encoder = Base64.getEncoder();
			//메소드를 사용해서 Encoder 객체 생성.

		byte[] encodeByte = encoder.encode(targetBytes);
		
		String encoderText = new String(encodeByte); //String 형식으로 암호화된 데이터를 다시 변환
		
		System.out.println("============= 인코딩(암호화) ===============");
		System.out.println("인코딩 전 데이터 : " + text);
		System.out.println("인코딩 후 데이터 : " + encoderText);
		
		
		System.out.println("============= 디코딩(복호화) ===============");
		
		///디코딩
		Decoder decoder = Base64.getDecoder(); //Decoder 객체 생성
		
		byte[] decodeByte = decoder.decode(encodeByte);
		byte[] decodeByte2 = decoder.decode(encoderText); //암호호된 String 복호화
		
		
		String decoderText = new String(decodeByte);
		String decoderText2 = new String(decodeByte2);

		
		System.out.println("복호화 된 데이터 : "+ decoderText);
		System.out.println("복호화 된 데이터2 : "+ decoderText2);
		
		
	}
	
	
	
}
