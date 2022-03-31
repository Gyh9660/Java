package chap15.Ex13;


/*
 * ¿©·¯ ¾²·¹µå°¡ °øÀ¯µÈÇÊµå¿¡ Á¢±ÙÇÒ ‹š¿¡´Â µ¿½Ã¼ºÀÇ ¹®Á¦°¡ ¹ß»ý.
 * ===>µ¿±âÈ­´Â µ¿½Ã¼º ¹®Á¦¸¦ ÇØ°á
 *  
 *  µ¿±âÈ­ : ¿©·¯ ½º·¹µå°¡ °øÀ¯µÈ ÇÊµå¸¦ Á¢±ÙÇÒ¶§ ÇÏ³ªÀÇ ¾²·¹µå°¡ ¿Ï·áµÇ¸é ´Ù¸¥ ¾²·¹µå¿¡¼­ Á¢±ÙÀÌ °¡
 *  ÇÏ³ªÀÇ ¾²·¹µå°¡ »ç¿ëÁßÀÎ °æ¿ì lockÀÌ °É¸°´Ù. ÀÛ¾÷ÀÌ ¿Ï·áµÇ¸é ´Ù¸¥ ¾²·¹µå°¡ Á¢±Ù °¡´ÉÇÏµµ·Ï lockÀ» Ç®¾îÁØ´Ù.
 *  
 *   - ¸ðµç µ¿±âÈ­µÈ ¸Þ¼Òµå´Â this(ÀÚ½ÅÀÇ °´Ã¼ )¶ó´Â Å°¸¸ °¡Áü.
 *   - ¿©·¯ ¸Þ¼Òµå°¡ µ¿±âÈ­µÈ ¸Þ¼ÒµåÀÏ °æ¿ì : ÇÏ³ªÀÇ ¾²·¹µå¸¸ Á¢±ÙÀÌ °¡´É
 *   
 * Å¬·¡½º ³»ºÎ¿¡ ¿©·¯°³ÀÇ µ¿±âÈ­ ¸Þ¼Òµå°¡ Á¸ÀçÇÒ °æ¿ì : ¸ðµÎ ¾²·¹µå°¡ Á¢±ÙÇÏ´Â Å°°¡ this 
 *   ¿©·¯°³ÀÇ µ¿±âÈ­ ¸Þ¼Òµå ³»¿¡¼­ ¸ÖÆ¼ ¾²·¹µå¸¦ »ç¿ëÇÏ°íÀÚ ÇÒ°æ¿ì µ¿±âÈ­ ºí¶ôÀ» »ý¼ºÈÄ Å°¸¦ ´Ù¸£°Ô ¼³Á¤.
 */


class A{}
class B{}
class C{}


class MyData{ //°øÀ¯ °´Ã¼ : ¿©·¯ ¾²·¹µå°¡ °´Ã¼¿¡ Á¢±ÙÇÑ´Ù.
	//¾²·¹µå´Â Key¸¦ È¹µæÇØ¾ß »ç¿ë°¡´É ÇÑ¾²·¹µå°¡ ÀÛ¾÷ÀÌ ¿Ï·áµÉ‹š±îÁö ´Ù¸¥ ¾²·¹µå´Â Á¢±ÙÀ» ÇÒ¼ö ¾ø´Ù.
		//µ¿±âÈ­µÈ ¸Þ¼Òµå´Â Key°ªÀÌ ¸ðµÎ this°¡ ÀÚµ¿À¸·Î µî·Ï, ¼öÁ¤ÀÌ ºÒ°¡ÇÔ.
			//µ¿±âÈ­ ¸Þ¼Òµå´Â Key°ªÀ» ³ÖÀ»¼ö ¾ø´Ù.
			//ÇÏ³ªÀÇ ¾²·¹µå°¡ Á¢±ÙÇÒ¶§ Key¸¦ °¡Áö°í µ¿±âÈ­µÈ ¸Þ¼Òµå¸¦ Á¢±Ù °¡´ÉÇÏ´Ù.
			//Key´Â °´Ã¼¸¦ Å°·Î »ç¿ëÇÒ ¼ö ÀÖ´Ù.
		//µ¿±âÈ­ ºí·°Àº Key°ªÀ» ÀÓÀÇ·Î ÇÒ´ç °¡´ÉÇÏ´Ù.
	synchronized void abc() { //¿©·¯¾²·¹µå°¡ Á¢±ÙÇÒ¶§ µ¿½Ã¼º ¹®Á¦¸¦ ¹æÁöÇÏ±â À§ÇØ¼­ µ¿±âÈ­ Ã³¸®¸¦ ÇÑ´Ù.
		for(int i=0; i<3; i++) {
			try {Thread.sleep(10);} catch (InterruptedException e1) {} //0.01ÃÊ µô·¹ÀÌ
			System.out.println(i + "sec");
			try {Thread.sleep(1000);} catch (InterruptedException e) {} //1ÃÊ µô·¹ÀÌ
		}
	}
	
void bcd() { //¿©·¯¾²·¹µå°¡ Á¢±ÙÇÒ¶§ µ¿½Ã¼º ¹®Á¦¸¦ ¹æÁöÇÏ±â À§ÇØ¼­ µ¿±âÈ­ Ã³¸®¸¦ ÇÑ´Ù.
	synchronized (new A()) { //¾²·¹µå°¡ Á¢±ÙÇÒ º°µµÀÇ Å°¸¦ »ý¼º
		try {Thread.sleep(20);} catch (InterruptedException e1) {} //0.02ÃÊ µô·¹ÀÌ
		for(int i=0; i<3; i++) {
			System.out.println(i + "ÃÊ");
			try {Thread.sleep(1000);} catch (InterruptedException e) {} //1ÃÊ µô·¹ÀÌ
		
		}	
	}
}
		
	void cde() { //¿©·¯¾²·¹µå°¡ Á¢±ÙÇÒ¶§ µ¿½Ã¼º ¹®Á¦¸¦ ¹æÁöÇÏ±â À§ÇØ¼­ µ¿±âÈ­ Ã³¸®¸¦ ÇÑ´Ù.
	
		synchronized (new Object()) { //º°µµÀÇ Å°¸¦ »ý¼º : ÀÓÀÇÀÇ Å°, ¾²·¹µå°¡ Á¢±ÙÇÏ´Â Å°(°øÀ¯°´Ã¼) °´Ã¼»ý¼º
		try {Thread.sleep(30);} catch (InterruptedException e1) {} //0.03ÃÊ µô·¹ÀÌ
		for(int i=0; i<3; i++) {
			System.out.println(i + "¹øÂ°");
			try {Thread.sleep(1000);} catch (InterruptedException e) {} //1ÃÊ µô·¹ÀÌ
		}
		}
	}
	
	
}



public class KeyObject_3 {

	public static void main(String[] args) {

		//°øÀ¯ °´Ã¼
		MyData myData = new MyData();
		
		//¼¼°³ÀÇ ¾²·¹µå°¡ °¢°¢ÀÇ ¸Þ¼Òµå È£Ãâ
		new Thread() {	//ÀÍ¸í Å¬·¡½º : ¾²·¹µåÅ¬·¡½º¸¦ ±¸ÇöÇÏ´Â ÀÚ½Ä ÀÍ¸í Å¬·¡½º
			public void run() {
				myData.abc();	//abc ¸Þ¼Òµå È£­Œ
			};
		}.start();
		
		new Thread() {	//ÀÍ¸í Å¬·¡½º : ¾²·¹µåÅ¬·¡½º¸¦ ±¸ÇöÇÏ´Â ÀÚ½Ä ÀÍ¸í Å¬·¡½º
			public void run() {
				myData.bcd();	//bcd ¸Þ¼Òµå È£­Œ
			};
		}.start();
		
		new Thread() {	//ÀÍ¸í Å¬·¡½º : ¾²·¹µåÅ¬·¡½º¸¦ ±¸ÇöÇÏ´Â ÀÚ½Ä ÀÍ¸í Å¬·¡½º
			public void run() {
				myData.cde();	//cde ¸Þ¼Òµå È£­Œ
			};
		}.start();
		
		
		
		
		
	}

}
