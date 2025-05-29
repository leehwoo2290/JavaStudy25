package Ch02;

//모든 은행들의 부모 클래스
public class BankType {

	public void print() {
		
		System.out.print("BankType은 ");
	}

	public static void main(String[] args) {
			
		// 코딩을 하면서 중요한것중 하나가 앞으로 프로젝트가 점점 커질때 기능이 추가되면서 그에따라 추가되는 코드가 최소화되도록 만드는 것이라고 생각한다.
		
		//-----------------------------------------기존 사용하던 방법 -------------------------------------------------------	
		
		// 프로젝트가 진행될수록 배열 수도 많아지고 코드도 길어진다.. 신한 은행 추가하면 Shinhan[] Shinhans 추가 ...
		// 은행이 늘어날때마다 배열의 수와 for문의 수가 늘어난다.
		// 프로그램이 복잡해질수록 답이없어짐
		
		System.out.println("\n기존 방법\n");
		
		Hana[] hanas = new Hana[1];
		Kakao[] kakaos = new Kakao[1];
		Hanguk[] hanguks = new Hanguk[1];
		//Shinhan[] shinhans = new Shinhan[1];
		
		hanas[0] = new Hana();
		kakaos[0] = new Kakao();
		hanguks[0] = new Hanguk();
		
		for(int i = 0; i < hanas.length; i++) {
			
			hanas[i].print();
		}
		for(int i = 0; i < kakaos.length; i++) {
			
			kakaos[i].print();
		}
		for(int i = 0; i < hanguks.length; i++) {
	
			hanguks[i].print();
		}
		//for(int i = 0; i < hanguks.length; i++) {
		//	
		//	Shinhan[i].print();
		//}
		
		//무한증식..
		
		//--------------------------------------------다형성을 활용한 방법---------------------------------------------------
			
		
		// 은행이 늘어나도 배열은 하나로 해결 가능하고(확장성 용이), for문이 늘어날 일도 없어서 코드도 간결하다(가독성 용이)  
		
		System.out.println("\n다형성을 활용한 방법\n");
		
		BankType[] bankTypes = new BankType[3];
		
		bankTypes[0] = new Hana();
		bankTypes[1] = new Kakao();
		bankTypes[2] = new Hanguk();	
		//신한 은행이 추가 되더라도 한줄만 추가하면된다
		//bankTypes[3] = new Shinhan();
		
		for(int i = 0; i < bankTypes.length; i++) {
			
			bankTypes[i].print();
		}
	}	
}

//BankType의 자식 클래스
class Hana extends BankType {

	public void print() {
		
		//super는 부모타입을 의미 여기서는 BankType
		//BankType의 print함수를 실행한다는 소리
		super.print();
		System.out.println("Hana 입니다.");
	}
}

//BankType의 자식 클래스
class Kakao extends BankType{

	public void print() {
		
		//super는 부모타입을 의미 여기서는 BankType
		//BankType의 print함수를 실행한다는 소리
		super.print();
		System.out.println("Kakao 입니다.");
	}
}

//BankType의 자식 클래스
class Hanguk extends BankType {

	public void print() {
		
		//super는 부모타입을 의미 여기서는 BankType
		//BankType의 print함수를 실행한다는 소리
		super.print();
		System.out.println("Hanguk 입니다.");
	}
}
