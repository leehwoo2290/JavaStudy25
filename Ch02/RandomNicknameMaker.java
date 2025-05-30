package Ch02;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomNicknameMaker {

	//한글 아스키 코드는 https://d2.naver.com/helloworld/76650?source=post_page 참고
	public static final int CHOSUNG_RANGE_VALUE = 0x1112 - 0x1100;
	public static final int FIRST_CHOSUNG_VALUE = 0x1100;
	public static final int[] UNUSUAL_CHOSUNGS = {0x1101, 0x1104,0x1108,0x110A,0x110D};
	
	public static final int JUNGSUNG_RANGE_VALUE = 0x1175 - 0x1161;
	public static final int FIRST_JUNGSUNG_VALUE = 0x1161;
	public static final int[] UNUSUAL_JUNGSUNGS = {0x1164, 0x1168,0x1170};
	
	public static final int JONGSUNG_RANGE_VALUE = 0x11C2 - 0x11A8;
	public static final int FIRST_JONGSUNG_VALUE = 0x11A8;
	public static final int[] UNUSUAL_JONGSUNGS = 
		{0x11A9, 0x11AA,0x11AC, 0x11AD, 0x11B0, 0x11B1, 0x11B2, 0x11B3, 0x11B4, 0x11B5, 0x11B6, 0x11B9, 0x11BB, 0x11BE, 0x11B9};
	
	public static boolean returnIncludeUnusalHangul(int[] _unusalHanguls, int _randomInteager) {
		
		boolean bIncludeUnusalHangul = false;
		
		for(var unsualHangul : _unusalHanguls) {
			
			if(unsualHangul == _randomInteager ) {
				
				bIncludeUnusalHangul = true;
				break;
			}
		}
		
		return bIncludeUnusalHangul;
	}
	
	public static String createRandomHangul(int _range, int _firstVal, int[] _unusalHanguls) {
		
		Random random = new Random();
		
		int randomInteager = 0;
		
		do {		
			randomInteager = random.nextInt(_range) + _firstVal;
			
		}while(returnIncludeUnusalHangul(_unusalHanguls, randomInteager));
		
		char[] randomHangul = Character.toChars(randomInteager);
		
		return new String(randomHangul);
	}
	
	public static String createRandomNickname(int _nickNameLength) {

		Random random = new Random();
		String randomHangul = "";
		
		for(int i = 0; i < _nickNameLength; i++) {
			
			randomHangul+=createRandomHangul(CHOSUNG_RANGE_VALUE, FIRST_CHOSUNG_VALUE, UNUSUAL_CHOSUNGS);
			randomHangul+=createRandomHangul(JUNGSUNG_RANGE_VALUE, FIRST_JUNGSUNG_VALUE, UNUSUAL_JUNGSUNGS);
			
			//받침 들어가는 확률 제한
			if(random.nextInt(10) == 0) {
				randomHangul+=createRandomHangul(JONGSUNG_RANGE_VALUE, FIRST_JONGSUNG_VALUE, UNUSUAL_JONGSUNGS);
			}		
		}	
		
		String nfcRandomHangul = Normalizer.normalize(randomHangul, Normalizer.Form.NFC);
		
		return nfcRandomHangul;
    }
	
	
	public static void main(String[] args) {
		 
		Scanner input = new Scanner(System.in);
		
		System.out.print("랜덤 생성할 닉네임 글자 수: ");
		int randomNicknameLength = input.nextInt();
		
		
		for(int i = 0; i < 500; i ++){
			
			if(i % 10 == 0) {
				System.out.println();
			}
			System.out.print(createRandomNickname(randomNicknameLength) + " ");
		}
		
		//개선 사항
		//평소 안쓰는 문자들 확률 내리거나 없애버리기 
		//영어랑 합쳐서?
		
	   
	}

}
