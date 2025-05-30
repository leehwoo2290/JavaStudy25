package MainSystem;

public class DrawExam {

	public enum TopBottom {
		Top, Bottom 
	}
	
	public static String makeSpaceString(int maxLength, String inputString) {
		
		 //middleVar는 모든 입력값의 최대 길이 - 현재 입력받은 문자열의 길이 / 2 
		 //최대한 문자를 중앙으로 배치하기 위한 방법
		 //ex) maxLength == 5 현재 문자열의 길이 == 2면 middleVar은 (5-2)/2 == 1이 된다.
		 int middleVar = (maxLength - inputString.length()) / 2;
		 String spaceString = "";
		 for(int i = 0, j = 0; i< maxLength; i++) {
			 
			 //ex) maxLength == 5 현재 문자열의 길이 == 2면 새로운 문자열의 0, 3, 4번째에 공백을 추가한다. 
			 //이는 새로운 문자열은 {" ", "s1", "s2", " ", " "}이 됨을 의미한다.
			 if(i < middleVar  || i >= middleVar + inputString.length() ) {
				 
				 spaceString+=" ";
				 continue;
			 }
			 
			 //기존 inputString의 문자열을 추가한다.
			 spaceString+=inputString.charAt(j++);
		 }
		 return spaceString;
	}
	
	public static void printTopBottomString(int roofBottomCnt, TopBottom _topBottom) {
		
		 for(int i = 0; i< roofBottomCnt; i++) 
		 {
			 System.out.print(_topBottom == TopBottom.Top ?  "█" : "█"); 		
		 }
		 System.out.println(); 
	}
	
	public void DrawVendingMachineStart(String[][] _sArr) {
		
		//임시코드
		int maxLength = 0;
		String[] s1 = new String[_sArr.length];
		String[] s2 = new String[_sArr.length];
		String[] s3 = new String[_sArr.length];
		
		for(int i =0; i < _sArr.length; i++) {
					
			s1[i] = _sArr[i][0];
			maxLength = Math.max(maxLength, s1[i].length());
			s2[i] = _sArr[i][1];
			maxLength = Math.max(maxLength, s2[i].length());
			s3[i] = _sArr[i][2];
			maxLength = Math.max(maxLength, s3[i].length());
								
		}
		
				
				//int maxLength = Math.max(s1.length(), s2.length());
				//maxLength = Math.max(maxLength, s3.length());
				
				int productCnt = s1.length;
				int maxLine = 3;
				
				//productCnt/maxLine + 1인 이유는 나머지가 남는경우 마지막 줄이 짤리기 때문에
				for(int angang = 0, curProductCnt = 0; angang < productCnt/maxLine + 1; angang++) {
					
					//+4는 적당한 임시값
					printTopBottomString((maxLength + 4) * maxLine, TopBottom.Top);
					 
					 String spaceStringS1 = "";
					 String spaceStringS2 = "";
					 String spaceStringS3 = "";
					 
					 for(int ri = 0; ri < maxLine; ri++) {			
						 
						 //예외처리
						 //sCnt >= productCnt ? "" : s1[sCnt] -> s1,2,3 배열의 끝에 도달했음을 체크하고 만약 그럴시 makeSpaceString에 공백을 넣는다. 
						 spaceStringS1 += "█" + " " + makeSpaceString(maxLength, curProductCnt >= productCnt ? " " : s1[curProductCnt]) + " " + "█";
						 spaceStringS2 += "█" + "$" +  makeSpaceString(maxLength, curProductCnt >= productCnt ? " " : s2[curProductCnt]) + " " + "█";
						 spaceStringS3 += "█" + " " +  makeSpaceString(maxLength, curProductCnt >= productCnt ? " " : s3[curProductCnt]) + " " + "█";	
						 
						 //curProductCnt는 현재 순회중인 product 순서를 나타냄
						 curProductCnt++;
					 }
					 System.out.println(spaceStringS1); 
					 System.out.println(spaceStringS2); 
					 System.out.println(spaceStringS3); 
				}
				
				printTopBottomString((maxLength + 4) * maxLine, TopBottom.Bottom);
	}
	
	public static void main(String[] args) {
	
		//한글은 " "과 공백의 길이가 맞지 않아 출력에 이상이 생김 
		//"아"의 길이와 " "의 길이가 다름;
		//결과엔 이상 없지만 가급적 영문, 숫자만 사용 권장
		String[] s1 = {"tenu1", "ten45u1","accaca","dwdwdwaw","fafwenu1","aaaaaaaaa","fafwenu1","fassfwenu1","enu1"};
		String[] s2 = {"$1559444","$57", "$33","$155","$5788","$8888","$8888","$8888","$8888"};
		String[] s3 = {"13", "55","101010101","888888","344524243","4","8888","888","8889"};
		
	
		
	}
}
