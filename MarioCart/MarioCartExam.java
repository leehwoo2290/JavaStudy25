package MarioCart;

import java.util.ArrayList;
import java.util.Scanner;

import MarioCart.dto.CartDTO;
import MarioCart.dto.MemberDTO;
import MarioCart.service.CartService;
import MarioCart.service.MemberService;

public class MarioCartExam {

	public static Scanner input = new Scanner(System.in);
	
	public static ArrayList<MemberDTO> memberDTOs = new ArrayList<MemberDTO>();
	
	public static ArrayList<CartDTO> cartDTOs = new ArrayList<CartDTO>();
	
	public static MemberDTO loginState; 
	
	static {
		
		cartDTOs.add(new CartDTO("세이버", 300, 7, 7, 8));
		cartDTOs.add(new CartDTO("마라톤", 320, 6, 6, 7));
	}
	
	public static void main(String[] args) {
	
		boolean bRun = true;
	
		while(bRun) {
		
			System.out.println("1. 회원관리 | 2. 카트관리 | 3. 게임실행 | 4. 종료");

			System.out.print(">>>");
			String select = input.next(); 
			
			switch (select) {
			case "1": 
				MemberService memberService = new MemberService();
				loginState = memberService.menu(input, memberDTOs, loginState);			
				break;
			case "2": 
				CartService cartService = new CartService();
				cartService.menu(input, loginState, memberDTOs, cartDTOs);			
				break;
			case "4":
				bRun = false;
				break;
			
			default:
				break;
			}
		}
		
		for(var x : memberDTOs) {
			
			System.out.println(x.getNickName());
		}

	}

}
