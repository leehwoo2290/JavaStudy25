package Ch02;

import java.util.Scanner;

//자판기 출력 외부 별도 구현
import MainSystem.DrawExam;

public class VendingMachine {
	
	//문제점 account별로 객체가 존재하지 않음 user와 admin이 각각 하나존재 할 뿐임 -> 계정별 구매목록 쇼핑카트 만들기등 기능추가 불가 수정 필요
	public static Scanner inputStr = new Scanner(System.in);
	public static Scanner inputInt = new Scanner(System.in);	

	//VendingMachineClass(예정)
	
	//추후 모든 배열들 가변 배열로 수정요망
	
	//products[i][0] = 물품명
	//products[i][1] = 물품가격
	//products[i][2] = 물품수
	public static String[][] products;
	
	//AccountClass(예정) - 모든계정 타입의 상위클래스
	
	//요구 기능이 많을거 같아서 가변배열 변경후 추가수정
	//accounts[i][0] = 계정 타입
	//accounts[i][1] = id
	//accounts[i][2] = pw
	public static String[][] accounts  = {{"admin", "admin123", "admin@@123!"},
										  {"user", "leeleelee", "abc1234"},
										  {"user", "imuser", "qwe12345@@"}};
	
	//AdminClass(예정)
	
	//관리자의 수익
	public static int profit = 0;
	
	//UserClass(예정)
	
	//유저의 소지금
	public static int userMoney = 0;
	
	//products[i][0] = 유저가 구매한 물품명
	//products[i][1] = 유저가 구매한 물품수
	public static String[][] userPurchasedProducts;
	
	//userShoppingCartProductIndexes[i][0] = 유저가 해당 index의 물품을 장바구니에 추가햇는지
	//장바구니 파트는 급하게 하드코딩된 부분이 많음 클래스가 너무 길어서 복잡함 ..
	public static boolean[] userShoppingCartProductIndexes;
	
	//StateMachineClass(예정)
	public static void start() {
		
		//관리자 재고 초기 설정
		setVendingMachineSize();
		addProduct(-1);
		//유저 소지금 세팅
		setUserMoney();
	}
	
	//StateMachineClass(예정)
	public static boolean update(String _accountType) {
		
		boolean bRun = true;
		
		switch (_accountType) {
		case "admin": {
			System.out.println("로그인 성공 계정 타입: " + _accountType + "\n");
			//adminClass의 adminMenu실행
			adminMenu();
			break;
		}
		case "user": {
			System.out.println("로그인 성공 계정 타입: " + _accountType + "\n");
			//userClass의 userMenu실행 
			userMenu();
			break;
		}
		
		default:
			System.out.println("로그인 실패 프로그램 종료");
			bRun = false;
			break;
		}
		
		return bRun;
	}
	
	//Accountclass(예정)
	public static String checkAccount_Validated() {
		
		System.out.println("\n\n---------------------------");
		System.out.println("로그인 ID PW 입력");
		
		System.out.print("ID: ");	
		String inputAdminID = inputStr.next();
		
		System.out.print("PW: ");
		String inputAdminPW = inputStr.next();
		
		String accountType = ""; 
		
		for (int i = 0; i < accounts.length; i++)
		{
			if(accounts[i][1].equals(inputAdminID) && accounts[i][2].equals(inputAdminPW)) {
				
				accountType = accounts[i][0];
				break;
			}		
		}
		
		return accountType;
	}
	
	//AdminClass(예정)
	public static void adminMenu() {
		
		System.out.println("\n\n---------------------------");
		System.out.println("관리자 메뉴 실행");
		System.out.println("1.물품 수정 2.물품 삭제 3.수익 확인");
		
		
		int inputAdminMenuType = inputInt.nextInt();
		int inputProductNum = 0;
		
		switch (inputAdminMenuType) {
			
		case 1: 
			System.out.print("수정할 물품 번호 입력: ");
			inputProductNum = inputInt.nextInt();
			addProduct(inputProductNum);
			break;
		
		case 2: 
			System.out.print("삭제할 물품 번호 입력: ");
			inputProductNum = inputInt.nextInt();
			deleteProduct(inputProductNum);
			break;
			
		case 3: 
			System.out.print("수익: " + profit);
			break;
			
		default:
			throw new IllegalArgumentException("잘못된 메뉴 타입 입력");		
		}		
	}
	
	//VendingMachineClass(예정) admin클래스에서 실행
	public static void setVendingMachineSize() {
		
		System.out.print("추가할 자판기 메뉴의 크기를 할당하시오: ");
		
		int productsCnt = inputInt.nextInt();
	
		//products[i][0] = 물품명
		//products[i][1] = 물품가격
		//products[i][2] = 물품수
		products = new String[productsCnt][3];
		//products[i][0] = 유저가 구매한 물품명
		//products[i][1] = 유저가 구매한 물품수
		userPurchasedProducts = new String[productsCnt][2];
		
		userShoppingCartProductIndexes = new boolean[productsCnt];
	}
	
	//vendingMachineClass(예정) admin클래스에서 실행
	//물품의 초기설정과 단일 물품 설정을 한 함수에 구현
	//초기 설정의 경우 _inputMenuNum == -1 추후 가상함수를 활용해 별도 구현해 해결
	public static void addProduct(int _inputMenuNum) {
				
		//존재하지 않는 index
		if(_inputMenuNum != -1 && checkProductNull_Validated(_inputMenuNum - 1)) {
			
			return;
		}
		
		//자판기 출력은 외부 구현한 DrawExam을 활용
		//한글은 " "과 공백의 길이가 맞지 않아 출력에 이상이 생김 
		//"아"의 길이와 " "의 길이가 다름;
		//결과엔 이상 없지만 가급적 영문, 숫자만 사용 권장
		System.out.println("제품명 영어 사용 권장 (자판기출력 과정 한글과 공백의 길이가 맞지 않아 출력에 이상이 생김)");
		
		//추후 가상함수를 활용해 별도 구현해 해결
		//-1이면 초기설정 이외값은 단일 제품 추가
		int curPointer = _inputMenuNum == -1 ? 0 : _inputMenuNum - 1;
		//초기 설정의 경우 정상 loop 단일 젶무 추가의 경우 1번만 loop
		int loopCnt =  _inputMenuNum == -1 ? products.length : 1;
		
		for(int i = 0; i < loopCnt; i++) {
			
			System.out.print("\n\n");
			System.out.print("추가할 물품명: ");
			products[curPointer][0] = inputStr.next();
			
			System.out.print("추가할 물품 가격: ");
			products[curPointer][1] = inputStr.next();
			
			System.out.print("추가할 물품 갯수: ");
			products[curPointer][2] = inputStr.next();
			
			//초기화
			userPurchasedProducts[curPointer][1] = "0";
			curPointer++;
			
			System.out.print((curPointer + 1) + "번 제품 추가완료");
			System.out.println("---------------------------");
		}
	}
	
	//VendingMachineClass(예정) admin클래스에서 실행
	public static void deleteProduct(int _inputMenuNum) {
		
		//존재하지 않는 index
		if(checkProductNull_Validated(_inputMenuNum - 1)) {
					
			return;
		}
		
		products[_inputMenuNum - 1][0] = "";
		products[_inputMenuNum - 1][1] = "";
		products[_inputMenuNum - 1][2] = "";
		
		System.out.print(_inputMenuNum + "번 제품 삭제완료");
		System.out.println("---------------------------");
	}
	
	//VendingMachineClass(예정)
	public static void printRemainProduct() {
		
		System.out.println("\n\n---------------------------");
		System.out.println("현재 관리자의 수익: " + profit);
		System.out.println("---------------------------");
		System.out.println("\n남은 물품 제품명 / 남은 물품 가격 / 남은 물품 갯수\n");
		
		//해당 출력은 과제랑 상관 없어서 외부에 구현
		DrawExam drawExam = new DrawExam();
		drawExam.DrawVendingMachineStart(products);
	}

	//VendingMachineClass(예정)
	public static boolean checkProductNull_Validated(int _inputNum) {
		
		//올바르지 않은 index 
		if( products.length <= _inputNum) {
			
			System.out.println("\n\n해당 물품은 존재하지 않습니다.");
			return false;
		}	
		if(products[_inputNum][2].isEmpty()) {
			
			System.out.println("\n\n해당 물품은 존재하지 않습니다.");
			return false;
		}
		
		return true;
	}
	
	//VendingMachineClass(예정)
	public static boolean checkCanBuyProduct_Validated(int _inputNum) {
			
		if(!checkProductNull_Validated(_inputNum)) {
				
			return false;
		}
		////products[i][2] = 물품수, 물품의 재고가 없음
		if(Integer.valueOf(products[_inputNum][2]) <= 0) {
				
			System.out.println("\n\n해당 물품의 잔고가 부족합니다.");
			return false;
		}	
		//products[i][1] = 물품가격, 물품의 가격이 userMoney보다 큼
		if(Integer.valueOf(products[_inputNum][1]) > userMoney) {
				
			System.out.println("\n\n유저의 소지금이 부족합니다.");
			return false;
		}
		return true;
	}
		
	//UserClass(예정)
	public static void userMenu() {
			
			System.out.println("\n\n---------------------------");
			System.out.println("유저 메뉴 실행");
			System.out.println("1.물품 구매 2.장바구니 추가 3.구매 물품 확인 4.소지금 확인");
				
			int inputAdminMenuType = inputInt.nextInt();
			
			switch (inputAdminMenuType) {
			
			case 1: 
				//유저 제품 구매
				userPurchasedProduct();
				break;
			
			case 2: 
				//유저 장바구니 추가
				addShoppingCartProduct();			
				break;
				
			case 3: 
				//유저가 구매한 제품과 갯수
				printUserPurchasedProduct();
				break;
				
			case 4: 
				System.out.print("수익: " + userMoney);
				break;
				
			default:
				throw new IllegalArgumentException("잘못된 메뉴 타입 입력");		
			}		
		}
		
	//UserClass(예정)
	public static void setUserMoney() {
		
		System.out.println("\n\n유저 메뉴 시작");
		System.out.print("유저의 시작 소지금을 입력하시오: ");
		
		userMoney = inputInt.nextInt();
	}
	
	
	
	//UserClass(예정)
	public static void userPurchasedProduct() {
		
		System.out.println("\n\n유저 구매 시작");
		
		boolean bRun = true;
		
		while(bRun) {
			
			//자판기 물품 출력
			printRemainProduct();
			System.out.println("---------------------------");
			System.out.println("현재 유저의 남은 소지금: " + userMoney);
			System.out.print("구매할 물품의 번호를 입력하시오(0번 입력시 구매 종료): ");
			
			int purchasedProductNum = inputInt.nextInt() - 1;
			
			//0입력시 종료
			if(purchasedProductNum == -1) {
				
				bRun = false;
			}
			//물품 구매 가능한지 체크
			else if(checkCanBuyProduct_Validated(purchasedProductNum)){
				
				System.out.print("\n\n" + (purchasedProductNum + 1) + "번 물품 구매에 성공햇습니다.");
				
				//현재 구매할 물품의 가격
				int productPrice = Integer.valueOf(products[purchasedProductNum][1]);
				//구매한 물품의 돈 계산
				userMoney-=productPrice;
				profit+=productPrice;
				//구매한거 유저의 물품 배열에 추가
				userPurchasedProducts[purchasedProductNum][0] = products[purchasedProductNum][0];
				
				//현재 유저의 purchasedProductNum번째 물품의 구매 갯수
				int curUserpurchasedProductCnt = Integer.valueOf(userPurchasedProducts[purchasedProductNum][1]);
				userPurchasedProducts[purchasedProductNum][1] = Integer.toString(curUserpurchasedProductCnt + 1);
				
				//현재남은 물품 재고
				int curProductCnt = Integer.valueOf(products[purchasedProductNum][2]);
				products[purchasedProductNum][2] = Integer.toString(curProductCnt - 1);
			}
		}
	}
	
	//임시적으로 userPurchasedProduct로직을 빌려서 사용
	//UserClass(예정)
	public static void addShoppingCartProduct() {
		
		System.out.println("\n\n장바구니 구매 시작");
		
		boolean bRun = true;
		
		while(bRun) {
			
			//자판기 물품 출력
			printRemainProduct();
			System.out.println("---------------------------");
			System.out.println("현재 유저의 남은 소지금: " + userMoney);
			System.out.print("장바구니에 추가 할 물품의 번호를 입력하시오(0번 입력시 추가 종료): ");
			
			int purchasedProductNum = inputInt.nextInt() - 1;
			
			//0입력시 종료
			if(purchasedProductNum == -1) {
				
				bRun = false;
			}
			else if(checkCanBuyProduct_Validated(purchasedProductNum)) {
				
				System.out.print("\n\n장바구니에 " + (purchasedProductNum + 1) + "번 물품 추가에 성공햇습니다.");
				
				userShoppingCartProductIndexes[purchasedProductNum] = true;
				
				printUserShoppingCartProduct();
			}
		}
	}
	
	//UserClass(예정)
	public static void printUserPurchasedProduct() {
		
		System.out.println("\n\n---------------------------");
		System.out.println("현재 유저의 남은 소지금:" + userMoney);
		System.out.println("---------------------------");
		System.out.println("\n구매한 물품\n");
		for(int i =0; i < userPurchasedProducts.length;i++) {
			
			//구매하지 않은 물품
			if(userPurchasedProducts[i][0] == null || userPurchasedProducts[i][0].isEmpty()) continue;

			System.out.println("구매한 물품명 / 개수: " + userPurchasedProducts[i][0] + " / " + userPurchasedProducts[i][1]);
			System.out.println("---------------------------");
		}
	}
	
	//UserClass(예정)
	public static void printUserShoppingCartProduct() {
			
		System.out.println("\n\n---------------------------");
		System.out.println("현재 유저의 남은 소지금:" + userMoney);
		System.out.println("---------------------------");
		System.out.println("\n장바구니 물품\n");
		for(int i =0; i < userShoppingCartProductIndexes.length;i++) {
				
			//구매하지 않은 물품
			if(!userShoppingCartProductIndexes[i]) continue;

			System.out.println("추가한 물품명: " + products[i][0]);
			System.out.println("---------------------------");
		}
	}
	
	public static void main(String[] args) {
	
		//StateMachine.start
		start();
		
		boolean bRun = true;
		
		while(bRun){
			
			bRun = update(checkAccount_Validated());		
								
		}
	}
}
